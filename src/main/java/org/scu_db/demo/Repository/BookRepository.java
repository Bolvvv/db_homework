package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //继承于JpaRepository,其中Title为对应的实体类，String为实体类主键属性

    Book findBooksByBookId(Integer bookId);

    @Query(value = "select * from book where book_id =?1", nativeQuery = true)
    List<Book> findBookByIdUseSql(Integer bookId);

    //设置事务注解，当操作失败时进行回滚
    @Transactional
    void deleteBookByBookId(Integer bookId);

}
