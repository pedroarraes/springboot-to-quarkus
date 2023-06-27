package com.englishcentral.crud.controller;

import com.englishcentral.crud.model.Product;
import com.englishcentral.crud.payload.ApiResponse;
import com.englishcentral.crud.payload.ProductRequest;
import com.englishcentral.crud.repository.ProductRepository;

import jakarta.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by christophergumera on 16/08/2018.
 */
@RestController
@RequestMapping("/api")
public class MainController {
  @Autowired
  private ProductRepository productRepository;

  /**
   * Get all products
   * @return List of Products
   */
  @GetMapping("/products")
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  /**
   * Get product by id
   * @param id
   * @return Product
   */
  @GetMapping("/products/{id}")
  public Product getProduct(@PathVariable Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      //throw new AppException("Product not found.");
      throw new WebApplicationException("Product not found.");
    }
    return product.get();
  }

  /**
   * Create new product
   * @param request
   * @return Message
   */
  @PostMapping("/products")
  public ResponseEntity createProduct(@RequestBody ProductRequest request) {
    Product product = new Product();
    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    Product result = productRepository.save(product);

    // URI location = ServletUriComponentsBuilder
    //         .fromCurrentRequest()
    //         .path("/{id}")
    //         .buildAndExpand(result.getId())
    //         .toUri();

    // return ResponseEntity.created(location).body(
    //     new ApiResponse(true,
    //         "Product was successfully saved."));

    return null;
  }

  /**
   * Update existing product
   * @param request
   * @return ResponseEntity
   */
  @PutMapping("/products/{id}")
  public ResponseEntity updateProduct(@RequestBody ProductRequest request,
                                      @PathVariable Long id) {
    Optional<Product> productOptional = productRepository.findById(id);
    if (!productOptional.isPresent()) {
      //throw new AppException("Product not found.");
      throw new WebApplicationException("Product not found.");
    }
    Product product = productOptional.get();
    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    productRepository.save(product);
    return ResponseEntity.ok()
        .body(new ApiResponse(true,
            "Product was successfully updated."));
  }

  /**
   * Delete existing product
   * @param id
   * @return ResponseEntity
   */
  @DeleteMapping("/products/{id}")
  public ResponseEntity deleteProduct(@PathVariable Long id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      
      //throw new AppException("Product not found.");
      throw new WebApplicationException("Product not found.");
    }
    productRepository .delete(product.get());
   
    return ResponseEntity.ok()
        .body(new ApiResponse(true,
            "Product was successfully deleted."));
  }
}