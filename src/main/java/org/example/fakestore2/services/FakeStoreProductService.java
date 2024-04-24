package org.example.fakestore2.services;

import org.example.fakestore2.dtos.FakeStoreProductDto;
import org.example.fakestore2.exceptions.ProductNotFoundException;
import org.example.fakestore2.models.Category;
import org.example.fakestore2.models.Product;
//import org.hibernate.query.sqm.sql.FakeSqmToSqlAstConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto  fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto=
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException(id,"Product not found");
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto [] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
