package com.marchuk.csv.processor.beans;


import com.marchuk.csv.processor.entities.SimpleCsv;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class EntityIndexer implements ApplicationListener<ContextRefreshedEvent> {

    private final EntityManager entityManager;

    @Override
    @Transactional
    @Async
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SearchSession searchSession = Search.session(entityManager);
        MassIndexer massIndexer = searchSession.massIndexer(SimpleCsv.class);
        try {
            massIndexer.startAndWait();
        } catch (InterruptedException e) {
//            System.exit(503); // Just stop the app
            Thread.currentThread().interrupt();
        }
    }

}