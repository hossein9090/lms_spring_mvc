package ir.hossein.spring.service.impl;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.repository.BookRepo;
import ir.hossein.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@Service("BookServiceImpl")
@Service()
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;


    @Override
    public void saveOrUpdate(BookModel bookModel) {
        bookRepo.saveOrUpdate(bookModel);
    }

    @Override
    public void delete(int bookId) {

        if (!userBookList(bookId).isEmpty()){
            System.out.println("ketab daste kasie !!!");
        }else {
            bookRepo.delete(bookId);
        }
    }
    @Override
    public List<BorrowModel> userBookList(int bookId){
        List<BorrowModel> userBookList = bookRepo.userBookList(bookId);
        return userBookList;
    }

    @Override
    public BookModel get(int contactId) {
        BookModel bookModel = bookRepo.get(contactId);
        return bookModel;
    }

    @Override
    public List<BookModel> list() {
        List<BookModel> bookList = bookRepo.list();
        return bookList;
    }
}
