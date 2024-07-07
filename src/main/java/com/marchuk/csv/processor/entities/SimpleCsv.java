package com.marchuk.csv.processor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Indexed
public class SimpleCsv {

    @Id
    @GeneratedValue
    private Integer id;

    @FullTextField
    @NaturalId
    private String firstName;

    @FullTextField
    @NaturalId
    private String lastName;

    @FullTextField
    @NaturalId
    private String email;

}
