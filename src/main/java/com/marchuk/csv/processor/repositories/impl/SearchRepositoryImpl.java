package com.marchuk.csv.processor.repositories.impl;

import com.marchuk.csv.processor.repositories.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {

    private final EntityManager entityManager;

    @Override
    public <T> List<T> search(String param, Class<T> clazz) {
        SearchSession session = Search.session(entityManager);
        String[] fields = Arrays.stream(clazz.getDeclaredFields()).map(Field::getName)
                .filter(f -> !f.contentEquals("id")).toArray(String[]::new);
        return session.search(clazz)
                .where(s -> s.match().fields(fields).matching(param).fuzzy(2)).fetchAll().hits();
    }

}
