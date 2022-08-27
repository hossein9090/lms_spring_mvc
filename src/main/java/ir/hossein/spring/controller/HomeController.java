package ir.hossein.spring.controller;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.UserModel;
import ir.hossein.spring.service.BookService;
import ir.hossein.spring.service.BorrowService;
import ir.hossein.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowService borrowService;


    @GetMapping("/" )
    public String home() throws IOException {return "index";}

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model) throws IOException {
        List<BookModel> bookModelList = bookService.list();
        model.addObject("bookList", bookModelList);
        List<UserModel> userModelList = userService.list();
        model.addObject("userList", userModelList);
        List<BorrowModel> borrowModelList = borrowService.list();
        model.addObject("borrowList", borrowModelList);
        model.setViewName("page");
        return model;
    }

    @GetMapping("/book")
//	@RequestMapping(value = "/h", method = RequestMethod.GET)
    public ModelAndView bookList(ModelAndView model) throws IOException {
        List<BookModel> bookModelList = bookService.list();
        model.addObject("bookList", bookModelList);
        model.setViewName("homeBook");
        return model;
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        BookModel newBook = new BookModel();
        model.addObject("newBook", newBook);
        model.setViewName("BookForm");
        return model;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute BookModel bookModel) {
        bookService.saveOrUpdate(bookModel);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        bookService.delete(bookId);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public ModelAndView editBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        BookModel bookModel = bookService.get(bookId);
        ModelAndView model = new ModelAndView("BookForm");
        model.addObject("newBook", bookModel);
        return model;
    }


                                //for User :



    @GetMapping("/user")
    public ModelAndView userList(ModelAndView model) throws IOException {
        List<UserModel> userModelList = userService.list();
        model.addObject("userList", userModelList);
        model.setViewName("homeUser");
        return model;
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        UserModel newUser = new UserModel();
        model.addObject("newUser", newUser);
        model.setViewName("UserForm");
        return model;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserModel userModel) {
        userService.saveOrUpdate(userModel);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.delete(userId);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserModel userModel = userService.get(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("newUser", userModel);
        return model;
    }



                                   //for User :

    @GetMapping("/borrow")
    public ModelAndView borrowList(ModelAndView model) throws IOException {
        List<BorrowModel> borrowModelList = borrowService.list();
        model.addObject("borrowList", borrowModelList);
        model.setViewName("homeBorrow");
        return model;
    }

    @RequestMapping(value = "/newBorrow", method = RequestMethod.GET)
    public ModelAndView newBorrow(ModelAndView model) {
        BorrowModel newBorrow = new BorrowModel();
        model.addObject("newBorrow", newBorrow);
        model.setViewName("BorrowForm");
        return model;
    }

    @RequestMapping(value = "/saveBorrow", method = RequestMethod.POST)
    public ModelAndView saveBorrow(@ModelAttribute BorrowModel borrowModel) {
        borrowService.saveOrUpdate(borrowModel);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/deleteBorrow", method = RequestMethod.GET)
    public ModelAndView deleteBorrow(HttpServletRequest request) {
        int borrowId = Integer.parseInt(request.getParameter("id"));
        borrowService.delete(borrowId);
        return new ModelAndView("redirect:/page");
    }

    @RequestMapping(value = "/editBorrow", method = RequestMethod.GET)
    public ModelAndView editBorrow(HttpServletRequest request) {
        int borrowId = Integer.parseInt(request.getParameter("id"));
        BorrowModel borrowModel = borrowService.get(borrowId);
        ModelAndView model = new ModelAndView("BorrowForm");
        model.addObject("newBorrow", borrowModel);
        return model;
    }
}










