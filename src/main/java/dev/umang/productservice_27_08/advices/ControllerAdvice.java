package dev.umang.productservice_27_08.advices;

import dev.umang.productservice_27_08.dtos.ProductNotFoundErrorDTO;
import dev.umang.productservice_27_08.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundErrorDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        //code to handle the exception
        //beatify the response
        ProductNotFoundErrorDTO errorDTO = new ProductNotFoundErrorDTO();
        errorDTO.setMessage(productNotFoundException.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(404));
    }
}
