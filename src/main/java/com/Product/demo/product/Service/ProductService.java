package com.Product.demo.product.Service;


import com.Product.demo.product.DTO.ProductsDTO;
import com.Product.demo.product.Entity.Products;
import com.Product.demo.product.Repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public List<Products> getAllProducts(){
    log.info("Fetching all product from database :");
    simulateSlowDbCall();
    return productRepo.findAll();
    }



     @Cacheable(value = "products",key = "#id")
    public Products getProductById(Long id) {
        log.info("Fetching products [{}] form Database ",id);
        simulateSlowDbCall();
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product Not found using this id :"+id));

    }

    @CachePut(value = "products",key = "#id")
    public Products updateProductById(Long id, ProductsDTO productsDTO) {
     log.info("updates Product [{}] in database :",id);
     Products existing =getProductById(id);
     existing.setProductName(productsDTO.getProductName());
     existing.setProductDescription(productsDTO.getProductDescription());
     existing.setProductStock(productsDTO.getProductStock());
     existing.setProductPrice(productsDTO.getProductPrice());
     existing.setCategory(productsDTO.getCategory());
        return productRepo.save(existing) ;
    }



    public Products createProducts(ProductsDTO productsDTO) {
        log.info("Creating new Product :",productsDTO.getProductName());
        Products products= Products.builder()
                .productName(productsDTO.getProductName())
                .productDescription(productsDTO.getProductDescription())
                .productStock(productsDTO.getProductStock())
                .productPrice(productsDTO.getProductPrice())
                .category(productsDTO.getCategory())
                .build();

        return productRepo.save(products);
    }
    @CacheEvict(value = "products",key = "#id")
    public void deletProductById(Long id) {
        log.info("Deleting product [{}] by id :",id);
        simulateSlowDbCall();
        productRepo.deleteById(id);
    }

    private void simulateSlowDbCall() {

        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
