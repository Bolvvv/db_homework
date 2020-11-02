package org.scu_db.demo.service.impl;

import org.scu_db.demo.Repository.BookRepository;
import org.scu_db.demo.Repository.MemberRepository;
import org.scu_db.demo.Repository.TitleRepository;
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
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TitleRepository titleRepository;


    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Integer bookId) {
        return bookRepository.findBooksByBookId(bookId);
    }

    @Override
    public List<Book> findBookByIdUseSql(Integer bookId) {
        return bookRepository.findBookByIdUseSql(bookId);
    }

    @Override
    public Integer deleteBookById(Integer id) {
        bookRepository.deleteBookByBookId(id);
        return null;
    }

    @Override
    public Integer updateBook(Book book, Integer method) {
        //method表示为更新方式，method=0表示为插入操作，method=1表示为更新操作

        //执行正确时，返回0
        //错误代码：
        //1:表示数据库中已有对应id的书
        //2:表示数据库中不存在对应的人员
        //3:表示数据库中不存在对应的索引号码
        if(method == 0){
            if( bookRepository.findBooksByBookId(book.getBookId()) != null){
                return 1;
            }
        }
        if(memberRepository.findById(book.getBorrowermemno()).isEmpty()){return 2;}
        if(titleRepository.findById(book.getCallnumber()).isEmpty()){return 3;}
        bookRepository.saveAndFlush(book);
        return 0;
    }
}
