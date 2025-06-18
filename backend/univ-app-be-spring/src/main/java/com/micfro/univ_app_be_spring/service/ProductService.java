package com.micfro.univ_app_be_spring.service;

import com.micfro.univ_app_be_spring.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // CREATE
// Metoda do tworzenia nowego produktu
    Product createProduct(Product product);


    // READ ALL
// Metoda do pobierania wszystkich produktów
    List<Product> getAllProducts();


//    // Metoda do pobierania jednego produktu po ID
//    Optional<Product> getProductById(Long id);
//
//
//
//    // Metoda do aktualizacji
//    Product updateProduct(Long id, Product productDetails);
//
//    // Metoda do usuwania produktu
//    void deleteProduct(Long id);
}