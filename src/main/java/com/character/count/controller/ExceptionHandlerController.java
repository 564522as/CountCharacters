package com.character.count.controller;

import com.character.count.util.GetDataErrorBody;
import com.character.count.util.GetDataException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpEntity<GetDataErrorBody> handleGetDataException(GetDataException e) {
        GetDataErrorBody errorBody = new GetDataErrorBody(e.getMessage(), System.currentTimeMillis());
        return new HttpEntity<>(errorBody);
    }

}
