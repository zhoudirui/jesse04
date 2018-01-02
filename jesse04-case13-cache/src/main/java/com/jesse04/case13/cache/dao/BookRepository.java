package com.jesse04.case13.cache.dao;

import com.jesse04.case13.cache.entity.Book;

/**
 * Created by fangzhipeng on 2017/4/19.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
