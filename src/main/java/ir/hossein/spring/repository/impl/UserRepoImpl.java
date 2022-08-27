package ir.hossein.spring.repository.impl;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.UserModel;
import ir.hossein.spring.repository.UserRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class UserRepoImpl implements UserRepo {


    private JdbcTemplate jdbcTemplate;

    public UserRepoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }


    @Override
    public void saveOrUpdate(UserModel userModel) {

        if (userModel.getId() !=null) {
            // update
            String sql = "UPDATE user SET fName=?,lName=?, address=? WHERE id=?";
            jdbcTemplate.update(sql, userModel.getFName(),userModel.getLName(),userModel.getAddress(),userModel.getId());
        } else {
            // insert
            String sql = "INSERT INTO user ( fName,lName, address) VALUES ( ?, ?, ?)";
            jdbcTemplate.update(sql,userModel.getFName(),userModel.getLName(),userModel.getAddress());
        }
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }

    public List<BorrowModel> userBookList(int userId){
        String sql = "select borrow.id,userId,bookId from borrow join user on borrow.userid=user.id where user.id=?;";

        List<BorrowModel> listOfUserBook = jdbcTemplate.query(sql,new Object[]{userId}, new RowMapper<BorrowModel>() {

            @Override
            public BorrowModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                BorrowModel borrowModel = new BorrowModel();

                borrowModel.setId(rs.getInt("id"));
                borrowModel.setUserId(rs.getInt("userId"));
                borrowModel.setBookId(rs.getInt("bookId"));


                return borrowModel;
            }
        });
        return listOfUserBook;
    }

    @Override
    public UserModel get(int userId) {
        String sql = "SELECT * FROM user WHERE id=" + userId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<UserModel>() {

            @Override
            public UserModel extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    UserModel userModel = new UserModel();

                    userModel.setId(rs.getInt("id"));
                    userModel.setFName(rs.getString("fName"));
                    userModel.setLName(rs.getString("lName"));
                    userModel.setAddress(rs.getString("address"));

                    return userModel;
                }
                //TODO  check this null
                return null;
            }
        });
    }

    @Override
    public List<UserModel> list() {
        String sql = "SELECT * FROM user";
        List<UserModel> listOfUser = jdbcTemplate.query(sql, new RowMapper<UserModel>() {

            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel userModel = new UserModel();

                userModel.setId(rs.getInt("id"));
                userModel.setFName(rs.getString("fName"));
                userModel.setLName(rs.getString("lName"));
                userModel.setAddress(rs.getString("address"));

                return userModel;
            }
        });
        return listOfUser;
    }
}
