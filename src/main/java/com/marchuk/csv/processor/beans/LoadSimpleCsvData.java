package com.marchuk.csv.processor.beans;

import com.marchuk.csv.processor.entities.SimpleCsv;
import com.marchuk.csv.processor.repositories.SimpleCsvRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadSimpleCsvData implements CommandLineRunner {

    private final SimpleCsvRepository simpleCsvRepository;

    @Override
    public void run(String... args) throws Exception {
        List<SimpleCsv> csvs = new CsvToBeanBuilder<SimpleCsv>(
                new FileReader(new ClassPathResource("static/test.csv").getFile()))
                .withType(SimpleCsv.class)
                .build()
                .parse();
        simpleCsvRepository.saveAll(csvs);
    }

}
