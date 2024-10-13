package az.codebridge.task.entity;

import az.codebridge.task.status.ProductStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer stockQuantity;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private LocalDateTime createdAt;

}

