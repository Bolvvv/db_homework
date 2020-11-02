package org.scu_db.demo.controller;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/1")
    public String example1() {
        return "hello";
    }

    @RequestMapping("/2")
    public List<Book> example2() {
        return bookService.findAllBooks();
    }

    @RequestMapping("/3")
    public Book example3() {
        return bookService.findBookById(123);
    }

    @RequestMapping("/4")
    public List<Book> example4() {
        return bookService.findBookByIdUseSql(123);
    }
}
