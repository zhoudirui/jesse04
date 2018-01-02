package com.jesse04.case13.cache.dao;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.jesse04.case13.cache.entity.Book;


/**
 * Created by fangzhipeng on 2017/4/19.
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}