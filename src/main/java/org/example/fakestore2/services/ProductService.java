package org.example.fakestore2.services;

import org.example.fakestore2.models.Product;

import java.util.List;

public interface ProductService {
     Product getProductById(Long id);


     List<Product> getAllProducts();
}
