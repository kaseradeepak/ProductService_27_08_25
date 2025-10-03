package dev.umang.productservice_27_08.services;

import dev.umang.productservice_27_08.dtos.FakeStoreProductDTO;
import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import dev.umang.productservice_27_08.models.Category;
import dev.umang.productservice_27_08.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreprodservice")
public class FakestoreProductService implements ProductService {
    private final ResourceUrlProvider resourceUrlProvider;
    /*
    To call external APIs, we can use something known as a Rest Template
     */

    private RestTemplate restTemplate ;

    public FakestoreProductService(RestTemplate restTemplate, ResourceUrlProvider resourceUrlProvider){
        this.restTemplate = restTemplate;
        this.resourceUrlProvider = resourceUrlProvider;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
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
    public Product createProduct(String title, String description, double price, Category category, String image) {
        //https://fakestoreapi.com/products

//        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
//        fakeStoreProductDTO.setTitle(title);
//        fakeStoreProductDTO.setDescription(description);
//        fakeStoreProductDTO.setPrice(price);
//        fakeStoreProductDTO.setCategory(categoryName);
//        fakeStoreProductDTO.setImage(image);
//
//        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject(
//                "https://fakestoreapi.com/products",
//                fakeStoreProductDTO,
//                FakeStoreProductDTO.class
//        );
//        return fakeStoreProductDTO1.toProduct();

        return null;
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

    @Override
    public void deleteProduct(Long id) {
        return;
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {
        return null;
    }

}
