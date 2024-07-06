package com.marchuk.csv.processor.services.impl;

import com.marchuk.csv.processor.entities.SimpleCsv;
import com.marchuk.csv.processor.exceptions.UnsupportedDelimiterException;
import com.marchuk.csv.processor.repositories.SimpleCsvRepository;
import com.marchuk.csv.processor.services.CsvService;
import com.marchuk.csv.processor.utils.CsvBuilder;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * Service implementation for processing CSV files.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class CsvServiceImpl implements CsvService {

    private final SimpleCsvRepository repository;

    /**
     * Saves CSV data from the provided MultipartFile.
     * Detects the delimiter and maps the CSV data to SimpleCsv entities, then saves them to the repository.
     *
     * @param file the CSV file to be processed and saved.
     * @throws RuntimeException if an error occurs during processing.
     */
    public void saveCsv(MultipartFile file) {
        char delimiter = detectDelimiter(file);
        try (Reader targetReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVReader csvReader = new CSVReader(targetReader);
            csvReader.skip(1); // Skip header row
            List<SimpleCsv> simpleCsvs = CsvBuilder.csvToBean(csvReader, delimiter, SimpleCsv.class);
            repository.saveAll(simpleCsvs);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    /**
     * Detects the delimiter used in the provided CSV file.
     *
     * @param file the CSV file whose delimiter is to be detected.
     * @return the detected delimiter as a char.
     * @throws RuntimeException if an error occurs during delimiter detection.
     */
    private char detectDelimiter(MultipartFile file) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line = reader.readLine();
                if (line.contains(",")) {
                    return ',';
                } else if (line.contains(";")) {
                    return ';';
                } else if (line.contains("\t")) {
                    return '\t';
                }
                throw new UnsupportedDelimiterException(line);
            }
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

}
