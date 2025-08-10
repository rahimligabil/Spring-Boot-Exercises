package com.gabil.deneme1.Exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private final ErrorMessage errorMessage;
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage()); // RuntimeException'a mesaj gönder
        this.errorMessage = errorMessage;
    }
}
