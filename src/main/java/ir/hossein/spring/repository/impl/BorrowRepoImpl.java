package ir.hossein.spring.repository.impl;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.repository.BorrowRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BorrowRepoImpl implements BorrowRepo {


    private JdbcTemplate jdbcTemplate;

    public BorrowRepoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }


    @Override
    public void saveOrUpdate(BorrowModel borrowModel) {

        if (borrowModel.getId() !=null) {
            // update
            String sql = "UPDATE borrow SET userId=?, bookId=? WHERE id=?";
            jdbcTemplate.update(sql, borrowModel.getUserId(),borrowModel.getBookId(),borrowModel.getId());
        } else {
            // insert
            String sql = "INSERT INTO borrow ( userId, bookId) VALUES ( ?, ?)";
            jdbcTemplate.update(sql,borrowModel.getUserId(),borrowModel.getBookId());
        }
    }

    @Override
    public void delete(int borrowId) {
        String sql = "DELETE FROM borrow WHERE id=?";
        jdbcTemplate.update(sql, borrowId);
    }

    @Override
    public BorrowModel get(int borrowId) {
        String sql = "SELECT * FROM borrow WHERE id=" + borrowId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<BorrowModel>() {

            @Override
            public BorrowModel extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    BorrowModel borrowModel = new BorrowModel();

                    borrowModel.setId(rs.getInt("id"));
                    borrowModel.setUserId(rs.getInt("userId"));
                    borrowModel.setBookId(rs.getInt("bookId"));

                    return borrowModel;
                }
                //TODO  check this null
                return null;
            }
        });
    }

    @Override
    public List<BorrowModel> list() {
        String sql = "SELECT * FROM borrow";
        List<BorrowModel> listOfBorrow = jdbcTemplate.query(sql, new RowMapper<BorrowModel>() {

            @Override
            public BorrowModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                BorrowModel borrowModel = new BorrowModel();

                borrowModel.setId(rs.getInt("id"));
                borrowModel.setUserId(rs.getInt("userId"));
                borrowModel.setBookId(rs.getInt("bookId"));

                return borrowModel;
            }

        });

        return listOfBorrow;
    }

}


