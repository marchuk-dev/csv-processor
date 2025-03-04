package com.marchuk.csv.processor.services;

import com.marchuk.csv.processor.entities.SimpleCsv;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvService {

    /**
     * Saves CSV data from the provided MultipartFile.
     * Detects the delimiter and maps the CSV data to SimpleCsv entities, then saves them to the repository.
     *
     * @param file the CSV file to be processed and saved.
     * @throws RuntimeException if an error occurs during processing.
     */
    void saveCsv(MultipartFile file);

    /**
     * Searches for {@link SimpleCsv} entities based on a query string.
     *
     * @param query The search query string.
     * @return A list of {@link SimpleCsv} entities matching the search criteria.
     */
    List<SimpleCsv> search(String query);

}
