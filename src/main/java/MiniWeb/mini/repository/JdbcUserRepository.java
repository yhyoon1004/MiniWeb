package MiniWeb.mini.repository;

import MiniWeb.mini.domain.User;

import java.util.List;

public class JdbcUserRepository implements UserRepository{
	@Override
	public User selectUserOne(String userId) {
		return null;
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
