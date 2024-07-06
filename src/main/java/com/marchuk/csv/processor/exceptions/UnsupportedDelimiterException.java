package com.marchuk.csv.processor.exceptions;

public class UnsupportedDelimiterException extends RuntimeException {
    private static final String MESSAGE = "Unsupported delimiter: %s";

    public UnsupportedDelimiterException(String line) {
        super(String.format(MESSAGE, line));
    }
}
