package ir.hossein.spring.service;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;

import java.util.List;

public interface BookService {

    public void saveOrUpdate(BookModel bookModel);

    public void delete(int bookId);

    public List<BorrowModel> userBookList(int bookId);

    public BookModel get(int contactId);

    public List<BookModel> list();
}
