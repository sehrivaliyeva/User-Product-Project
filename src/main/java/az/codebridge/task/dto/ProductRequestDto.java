package az.codebridge.task.dto;

import az.codebridge.task.status.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductRequestDto {
    @NotBlank
    private String name;

    @NotNull    
    @Positive
    private Double price;

    @NotNull
    @Positive
    private Integer stockQuantity;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ProductStatus status;

    private LocalDateTime createdAt;
}
