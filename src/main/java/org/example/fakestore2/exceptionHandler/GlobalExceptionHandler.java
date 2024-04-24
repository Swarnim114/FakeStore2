package org.example.fakestore2.exceptionHandler;

import org.example.fakestore2.dtos.ExceptionsDto;
import org.example.fakestore2.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionsDto> handleArithmeticException(ArithmeticException e) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("something went wrong");
        exceptionsDto.setSolution("Arithmetic exception");
        ResponseEntity<ExceptionsDto> response = new ResponseEntity<>(exceptionsDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionsDto> HandleProductNotFoundException(ProductNotFoundException e) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("something went wrong");
        exceptionsDto.setSolution("Arithmetic exception");
        ResponseEntity<ExceptionsDto> response = new ResponseEntity<>(exceptionsDto, HttpStatus.BAD_REQUEST);
        return response;
    }


}
