package org.scu_db.demo.service.impl;

import org.scu_db.demo.Repository.BookRepository;
import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "BookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookById(Integer bookId) {
        return bookRepository.findBooksByBookId(bookId);
    }

    @Override
    public List<Book> findBookByIdUseSql(Integer bookId) {
        return bookRepository.findBookByIdUseSql(bookId);
    }
}
