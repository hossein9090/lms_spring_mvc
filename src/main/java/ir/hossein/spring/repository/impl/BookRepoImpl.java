package ir.hossein.spring.repository.impl;

import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.repository.BookRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class BookRepoImpl implements BookRepo {


    private JdbcTemplate jdbcTemplate;

    public BookRepoImpl(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }


    @Override
    public void saveOrUpdate(BookModel bookModel) {

		if (bookModel.getId() !=null) {
			// update
			String sql = "UPDATE book SET name=?, authorName=? WHERE id=?";
			jdbcTemplate.update(sql, bookModel.getName(), bookModel.getAuthorName(), bookModel.getId());
		} else {
			// insert
			String sql = "INSERT INTO book ( name, authorName) VALUES ( ?, ?)";
			jdbcTemplate.update(sql,bookModel.getName(), bookModel.getAuthorName());
		}
    }

    @Override
    public void delete(int bookId) {
		String sql = "DELETE FROM book WHERE id=?";
		jdbcTemplate.update(sql, bookId);
    }

    public List<BorrowModel> userBookList(int bookId){
        String sql = "select borrow.id,userId,bookId from borrow join book on borrow.bookid=book.id where book.id=?;";

        List<BorrowModel> listOfUserBook = jdbcTemplate.query(sql,new Object[]{bookId}, new RowMapper<BorrowModel>() {

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
    public BookModel get(int bookId) {
		String sql = "SELECT * FROM book WHERE id=" + bookId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<BookModel>() {

			@Override
			public BookModel extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
				if (rs.next()) {
					BookModel bookModel = new BookModel();

                    bookModel.setId(rs.getInt("id"));
                    bookModel.setName(rs.getString("name"));
                    bookModel.setAuthorName(rs.getString("authorName"));

					return bookModel;
				}
                //TODO  check this null
				return null;
			}
		});
    }

    @Override
    public List<BookModel> list() {
        String sql = "SELECT * FROM book";
        List<BookModel> listOfBook = jdbcTemplate.query(sql, new RowMapper<BookModel>() {

            @Override
            public BookModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                BookModel bookModel = new BookModel();

                bookModel.setId(rs.getInt("id"));
                bookModel.setName(rs.getString("name"));
                bookModel.setAuthorName(rs.getString("authorName"));

                return bookModel;
            }

        });

        return listOfBook;
    }

}
