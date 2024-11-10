package az.codebridge.task.dto;

import az.codebridge.task.status.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String name;

    private Double price;

    private Integer stockQuantity;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;


}
