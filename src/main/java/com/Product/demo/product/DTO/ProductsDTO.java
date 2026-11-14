package com.Product.demo.product.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {

    private String productName;
    private String productDescription;
    private long ProductStock;
    private BigDecimal ProductPrice;
    private String category;

}
