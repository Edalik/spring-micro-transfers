package ru.otus.java.pro.mt.core.transfers.exceptions_handling;

public class BadRequestException extends BusinessLogicException {

    public BadRequestException(String message, String code) {
        super(message, code);
    }

}
