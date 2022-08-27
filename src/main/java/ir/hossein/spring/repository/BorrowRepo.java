package ir.hossein.spring.repository;

import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.UserModel;

import java.util.List;

public interface BorrowRepo {

    public void saveOrUpdate(BorrowModel borrowModel);

    public void delete(int borrowId);

    public BorrowModel get(int borrowId);

    public List<BorrowModel> list();
}
