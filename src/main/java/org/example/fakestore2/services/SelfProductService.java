package org.example.fakestore2.services;

import org.example.fakestore2.exceptions.CategoryNotFoundException;
import org.example.fakestore2.exceptions.ProductNotFoundException;
import org.example.fakestore2.models.Category;
import org.example.fakestore2.models.Product;
import org.example.fakestore2.repos.CategoryRepository;
import org.example.fakestore2.repos.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> Optionalproduct = productRepository.findById(id);
        if (Optionalproduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }
        return Optionalproduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null) {
            // save the category
            product.setCategory(categoryRepository.save(category));
        }
        Product savedProduct = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            // The category that is passed in the input product is invalid.
            throw new CategoryNotFoundException("Invalid category id passed");
        }
        savedProduct.setCategory(optionalCategory.get());
        return savedProduct;
    }
}