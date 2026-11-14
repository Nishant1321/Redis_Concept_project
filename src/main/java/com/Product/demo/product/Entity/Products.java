package com.Product.demo.product.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

@Column(nullable = false)
    private String productName;

@Column(length = 1000)
    private String productDescription;

@Column(nullable = false)
    private Long ProductStock;

@Column(nullable = false)
    private BigDecimal ProductPrice;

@Column(nullable = false)
private String category;

@Column(name = "Created_At")
private LocalDateTime createdAt;

@PrePersist
protected void onCreate(){
    createdAt =LocalDateTime.now();
}


}
