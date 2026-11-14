package com.Product.demo.product.Repo;

import com.Product.demo.product.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Products,Long> {
}
