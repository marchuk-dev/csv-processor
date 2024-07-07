package com.marchuk.csv.processor.repositories;

import java.util.List;

public interface SearchRepository {

    /**
     * Performs a fuzzy full-text search across specified fields of the given entity class.
     *
     * @param param The search parameter or query string.
     * @param clazz The class of the entity on which the search is performed.
     * @param <T>   The type of the entity class.
     * @return A list of entities matching the search criteria.
     */
    <T> List<T> search(String param, Class<T> clazz);

}
