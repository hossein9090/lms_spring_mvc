package ir.hossein.spring.repository;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;

import java.awt.print.Book;
import java.util.List;

public interface BookRepo {

    public void saveOrUpdate(BookModel bookModel);

    public void delete(int bookId);

    public List<BorrowModel> userBookList(int bookId);

    public BookModel get(int contactId);

    public List<BookModel> list();
}
