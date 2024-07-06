package com.marchuk.csv.processor.repositories;

import com.marchuk.csv.processor.entities.SimpleCsv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleCsvRepository extends JpaRepository<SimpleCsv, Integer> {
}
