package MiniWeb.mini.repository;

import MiniWeb.mini.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	public User selectUserOne(String userId);

	public List<User> selectUserAll();

	public boolean  insertUser(User user);

	public boolean deleteUser(User user);

	public boolean updateUser(User user);
}
