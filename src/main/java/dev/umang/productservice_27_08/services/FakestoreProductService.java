package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.dtos.FakeStoreProductDTO;
import dev.umang.productservice_27_08.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakestoreProductService implements ProductService {
    /*
    To call external APIs, we can use something known as a Rest Template
     */

    private RestTemplate restTemplate ;

    public FakestoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(String id) {
        FakeStoreProductDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        return response.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String image) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
