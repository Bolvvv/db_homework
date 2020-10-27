package org.scu_db.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private Integer bookId;
    private String edition;
    private Date borrowduedate;
    private Integer borrowermemno;
    private String callnumber;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getBorrowduedate() {
        return borrowduedate;
    }

    public void setBorrowduedate(Date borrowduedate) {
        this.borrowduedate = borrowduedate;
    }

    public Integer getBorrowermemno() {
        return borrowermemno;
    }

    public void setBorrowermemno(Integer borrowermemno) {
        this.borrowermemno = borrowermemno;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }
}
