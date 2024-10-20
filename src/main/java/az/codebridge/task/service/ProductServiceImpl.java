package az.codebridge.task.service;

import az.codebridge.task.dto.ProductRequestDto;
import az.codebridge.task.dto.ProductResponseDto;
import az.codebridge.task.entity.ProductEntity;
import az.codebridge.task.entity.UserEntity;
import az.codebridge.task.exception.ProductNotFoundException;
import az.codebridge.task.exception.StockException;
import az.codebridge.task.exception.UserNotFoundException;
import az.codebridge.task.repository.ProductRepository;
import az.codebridge.task.repository.UserRepository;
import az.codebridge.task.status.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .description(productRequestDto.getDescription())
                .stockQuantity(productRequestDto.getStockQuantity())
                .status(productRequestDto.getStatus())
                .createdAt(productRequestDto.getCreatedAt())
                .build();
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return ProductResponseDto.builder()
                .name(savedProductEntity.getName())
                .price(savedProductEntity.getPrice())
                .description(savedProductEntity.getDescription())
                .stockQuantity(savedProductEntity.getStockQuantity())
                .status(savedProductEntity.getStatus())
                .build();


    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("BU MEHSUL MOVCUD DEYIL !!!"));

        productEntity.setName(productRequestDto.getName());
        productEntity.setPrice(productRequestDto.getPrice());
        productEntity.setDescription(productRequestDto.getDescription());
        productEntity.setStockQuantity(productRequestDto.getStockQuantity());
        ProductEntity save = productRepository.save(productEntity);

        return ProductResponseDto.builder()
                .name(save.getName())
                .price(save.getPrice())
                .description(save.getDescription())
                .stockQuantity(save.getStockQuantity())
                .status(save.getStatus())
                .build();

    }

    @Override
    public void softDeleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("BU MEHSUL MOVCUD DEYIL !!!"));

        productEntity.setStatus(ProductStatus.DELETED);
        productRepository.save(productEntity);

    }

    @Override
    public ProductResponseDto findById(Long id) {

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("MEHSUL MOVCUD DEYIL"));

        if (productEntity.getStatus().equals(ProductStatus.DELETED)) {
            System.out.println("MEHSUL MOVCUD DEYIL !!!");
            return null;

        } else {
            return ProductResponseDto.builder()
                    .name(productEntity.getName())
                    .price(productEntity.getPrice())
                    .description(productEntity.getDescription())
                    .stockQuantity(productEntity.getStockQuantity())
                    .status(productEntity.getStatus())
                    .build();
        }


    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
       /* List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            if (!productEntity.getStatus().equals(ProductStatus.DELETED)) {
                ProductResponseDto productResponseDto = ProductResponseDto.builder()
                        .name(productEntity.getName())
                        .price(productEntity.getPrice())
                        .stockQuantity(productEntity.getStockQuantity())
                        .description(productEntity.getDescription())
                        .status(productEntity.getStatus())
                        .build();
                productResponseDtos.add(productResponseDto);
            }
        }

        return productResponseDtos;*/

        return productRepository.findAll().stream()
                .map(productEntity -> ProductResponseDto.builder()
                        .name(productEntity.getName())
                        .price(productEntity.getPrice())
                        .description(productEntity.getDescription())
                        .stockQuantity(productEntity.getStockQuantity())
                        .status(productEntity.getStatus())
                        .build()).toList();

    }

    @Override
    public ProductResponseDto buyProduct(Long productId, Long userId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("MEHSUL MOVCUD DEYIL !!!"));
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Tapilmadi "));

        if (productEntity.getStatus().equals(ProductStatus.DELETED)) {
            throw new RuntimeException("Bu mehsul silinib ");

        }

        if (userEntity.getBalance() > productEntity.getPrice()) {
            productEntity.setStockQuantity(productEntity.getStockQuantity() - 1);
            userEntity.setBalance(userEntity.getBalance() - productEntity.getPrice());


        } else {
            throw new RuntimeException("KIFAYET QEDER BALANS YOXDUR !!!");
        }
        ProductEntity product = productRepository.save(productEntity);
        userRepository.save(userEntity);
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .stockQuantity(product.getStockQuantity())
                .status(product.getStatus())
                .build();

    }

    @Override
    public ProductResponseDto reverseProduct(Long productId, Long userId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(" bele mehsul tapilmadi !!"));
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User tapilmadi "));
        productEntity.setStockQuantity(productEntity.getStockQuantity() + 1);
        userEntity.setBalance(userEntity.getBalance() + productEntity.getPrice());
        ProductEntity save = productRepository.save(productEntity);
        userRepository.save(userEntity);
        return ProductResponseDto.builder()
                .name(save.getName())
                .price(save.getPrice())
                .description(save.getDescription())
                .stockQuantity(save.getStockQuantity())
                .status(save.getStatus())
                .build();

    }

   /* @Override
    public void buyProduct(Long id, Integer quantity) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("MEHSUL MOVCUD DEYIL !!!"));

        if (!product.getStatus().equals(ProductStatus.ACTIVE)) {
            throw new ProductNotFoundException("MEHSUL MOVCUD DEYIL !!!");
        }

        if (quantity > product.getStockQuantity()) {
            throw new StockException("LAZM OLAN MEHSUL MIQDARI BAZADA MOVCUD DEYIL !!");
        }
        product.setStockQuantity(product.getStockQuantity() - quantity);


        if (product.getStockQuantity() == 0) {
            product.setStatus(ProductStatus.OUT_OF_STOCK);
        }

        productRepository.save(product);
    }*/


}



