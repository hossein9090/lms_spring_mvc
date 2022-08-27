package ir.hossein.spring.service.impl;

import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.repository.BorrowRepo;
import ir.hossein.spring.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepo borrowRepo;

    @Override
    public void saveOrUpdate(BorrowModel borrowModel) {borrowRepo.saveOrUpdate(borrowModel);}

    @Override
    public void delete(int borrowId) {
        borrowRepo.delete(borrowId);
    }

    @Override
    public BorrowModel get(int borrowId) {
        BorrowModel borrowModel = borrowRepo.get(borrowId);
        return borrowModel;
    }

    @Override
    public List<BorrowModel> list() {
        List<BorrowModel> borrowList = borrowRepo.list();
        return borrowList;
    }
}
