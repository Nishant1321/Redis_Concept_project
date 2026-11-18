package com.Product.demo.product.Controller;

import com.Product.demo.product.DTO.ProductsDTO;
import com.Product.demo.product.Entity.Products;
import com.Product.demo.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable  Long id){
        return ResponseEntity.ok(productService.getProductById(id));

    }

    @PostMapping
    public ResponseEntity<Products> createProducts(@RequestBody ProductsDTO productsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProducts(productsDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProductById(@PathVariable Long id ,@RequestBody ProductsDTO productsDTO){
        return ResponseEntity.ok(productService.updateProductById(id,productsDTO));
    }

    @DeleteMapping
    public ResponseEntity<Products> deletProductById(@PathVariable Long id){
        productService.deletProductById(id);
        return ResponseEntity.noContent().build();
    }



}
