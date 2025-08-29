package dev.umang.productservice_27_08.exceptions;
/*
Exception types:-
1. Compile / Checked Exception = needs to be handled
Throwable
Exception
RunTimeException

2. Runtime / Unchecked Exception
 */
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
