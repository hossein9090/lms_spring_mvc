package ir.hossein.spring.service;

import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.UserModel;

import java.util.List;

public interface UserService {

    public void saveOrUpdate(UserModel userModel);

    public void delete(int userId);

    public List<BorrowModel> userBookList(int userId);

    public UserModel get(int userId);

    public List<UserModel> list();
}
