package org.example.fakestore2.exceptions;

import lombok.Getter;
import lombok.Setter;
//import org.aspectj.bridge.IMessage;
@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {
    private Long id;
    public ProductNotFoundException(Long id ,String message) {
        super(message);
        this.id = id;

    }

}
