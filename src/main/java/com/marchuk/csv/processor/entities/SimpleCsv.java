package com.marchuk.csv.processor.entities;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SimpleCsv {

    @Id
    @GeneratedValue
    @CsvBindByName(required = true)
    private Integer id;

    @CsvBindByName(required = true)
    private String firstName;

    @CsvBindByName(required = true)
    private String lastName;

    @CsvBindByName(required = true)
    private String email;

}
