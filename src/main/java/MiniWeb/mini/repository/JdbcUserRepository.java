package MiniWeb.mini.repository;

import MiniWeb.mini.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;


	private final DataSource dataSource;

	@Autowired
	public JdbcUserRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void connectionClose() throws SQLException {
		if (this.connection != null) {
			connection.close();
			connection = null;
		}
	}

	public void preparedStatementClose() throws SQLException {
		if (this.pstmt != null) {
			this.pstmt.close();
			this.pstmt = null;
		}
	}

	public void resultSetClose() throws SQLException {
		if (this.rs != null) {
			this.rs.close();
			this.rs = null;
		}
	}


	@Override
	public User selectUserOne(String userId) {
		User searchedUser = new User();
		String sql = "SELECT * FROM User WHERE UserId = ?";
		try {
			connection = DataSourceUtils.getConnection(this.dataSource);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if(rs.next()){
				searchedUser.setUserId(rs.getString(1));
				searchedUser.setUserPwd(rs.getString(2));
				searchedUser.setUserName(rs.getString(3));
				searchedUser.setUserEmail(rs.getString(4));
				searchedUser.setUserPhone(rs.getInt(5));
				searchedUser.setUserGrade(rs.getString(6));
			}else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connectionClose();
				preparedStatementClose();
				resultSetClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end of finally
		return searchedUser;
	}

	@Override
	public List<User> selectUserAll() {
		return null;
	}

	@Override
	public boolean insertUser(User user) {

		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		return false;
	}
}
