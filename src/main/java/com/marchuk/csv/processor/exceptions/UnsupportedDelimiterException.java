package com.marchuk.csv.processor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsupportedDelimiterException extends RuntimeException {
    private static final String MESSAGE = "Unsupported delimiter: %s";

    public UnsupportedDelimiterException(String line) {
        super(String.format(MESSAGE, line));
    }
}
