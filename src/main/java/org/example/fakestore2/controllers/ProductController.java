package org.example.fakestore2.controllers;

import org.example.fakestore2.models.Product;
import org.example.fakestore2.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("{id}")
    //get product by id
    public Product  getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }



    @GetMapping("")
    //get all product;
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
          return productService.createProduct(product);
    }
}
