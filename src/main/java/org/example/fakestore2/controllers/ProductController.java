package org.example.fakestore2.controllers;

import org.example.fakestore2.models.Product;
import org.example.fakestore2.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("{id}")
    //get product by id
    public Product  getProductById(Long id){
        return productService.getProductById(id);
    }



    @GetMapping("")
    //get all product;
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
}
