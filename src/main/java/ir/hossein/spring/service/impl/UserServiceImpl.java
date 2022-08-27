package ir.hossein.spring.service.impl;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.UserModel;
import ir.hossein.spring.repository.BookRepo;
import ir.hossein.spring.repository.UserRepo;
import ir.hossein.spring.service.BookService;
import ir.hossein.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@Service("BookServiceImpl")
@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void saveOrUpdate(UserModel userModel) {userRepo.saveOrUpdate(userModel);}

    @Override
    public void delete(int userId) {
        if (!userBookList(userId).isEmpty()){
            System.out.println("biar ketabato pas bede dadash !!!");
        }else {
            userRepo.delete(userId);
        }
    }
    @Override
    public List<BorrowModel> userBookList(int userId){
        List<BorrowModel> userBookList = userRepo.userBookList(userId);
        return userBookList;
    }

    @Override
    public UserModel get(int userId) {
        UserModel userModel = userRepo.get(userId);
        return userModel;
    }

    @Override
    public List<UserModel> list() {
        List<UserModel> userList = userRepo.list();
        return userList;
    }
}