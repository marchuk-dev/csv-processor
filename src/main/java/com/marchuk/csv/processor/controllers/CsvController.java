package com.marchuk.csv.processor.controllers;

import com.marchuk.csv.processor.services.impl.CsvServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/csv")
public class CsvController {

    private final CsvServiceImpl service;

    @PostMapping("/upload")
    public void uploadCsv(@RequestParam("file") MultipartFile file) {
        service.saveCsv(file);
    }
    
}