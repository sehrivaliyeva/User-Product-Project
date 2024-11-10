package az.codebridge.task.service;

import az.codebridge.task.dto.ProductRequestDto;
import az.codebridge.task.dto.ProductResponseDto;
import az.codebridge.task.status.ProductStatus;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void softDeleteProduct(Long id);

    ProductResponseDto findById(Long id);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto buyProduct(Long productId, Long userId,int count);

    ProductResponseDto reverseProduct(Long productId, Long userId);


    ProductResponseDto findByProductName(String productName);

}