package az.codebridge.task.dto;

import az.codebridge.task.status.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    @Positive
    private Double price;

    @NotBlank
    @Positive
    private Integer stockQuantity;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private ProductStatus status;

    @NotBlank
    private LocalDateTime createdAt;
}
