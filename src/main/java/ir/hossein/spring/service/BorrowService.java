package ir.hossein.spring.service;

import ir.hossein.spring.model.BorrowModel;

import java.util.List;

public interface BorrowService {

    public void saveOrUpdate(BorrowModel borrowModel);

    public void delete(int borrowId);

    public BorrowModel get(int borrowId);

    public List<BorrowModel> list();

}
