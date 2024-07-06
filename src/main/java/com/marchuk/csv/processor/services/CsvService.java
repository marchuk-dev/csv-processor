package com.marchuk.csv.processor.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CsvService {
    void saveCsv(MultipartFile file) throws IOException;
}
