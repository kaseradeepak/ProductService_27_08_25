package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.dtos.FakeStoreProductDTO;
import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreprodservice")
public class FakestoreProductService implements ProductService {
    /*
    To call external APIs, we can use something known as a Rest Template
     */

    private RestTemplate restTemplate ;

    public FakestoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        FakeStoreProductDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        if(response == null){
            //Isn't null response an exception / unexpected
            //Should we throw an exception here
            //Should we handle this exception in some sort
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return response.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String image) {
        //https://fakestoreapi.com/products

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(categoryName);
        fakeStoreProductDTO.setImage(image);

        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDTO,
                FakeStoreProductDTO.class
        );
        return fakeStoreProductDTO1.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        //https://fakestoreapi.com/products

        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;
    }
}
