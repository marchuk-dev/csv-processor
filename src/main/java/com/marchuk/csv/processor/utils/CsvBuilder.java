package com.marchuk.csv.processor.utils;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.experimental.UtilityClass;

import java.util.List;


/**
 * Utility class for building CSV-related objects.
 * Provides methods for converting CSV data to beans.
 * <p>
 * Annotations:
 * - @UtilityClass: Marks this class as a utility class, making all its methods static.
 */
@UtilityClass
public class CsvBuilder {

    /**
     * Converts CSV data to a list of beans of the specified type.
     *
     * @param <T>       the type of the bean.
     * @param csvReader the CSVReader object to read CSV data from.
     * @param delimiter the delimiter used in the CSV data.
     * @param clazz     the class type of the bean.
     * @return a list of beans populated with CSV data.
     */
    public <T> List<T> csvToBean(CSVReader csvReader, char delimiter, Class<T> clazz) {
        ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(clazz);

        return new CsvToBeanBuilder<T>(csvReader)
                .withType(clazz)
                .withSeparator(delimiter)
                .withMappingStrategy(strategy)
                .withIgnoreEmptyLine(true)
                .withIgnoreLeadingWhiteSpace(true)
                .build().parse();
    }
}
