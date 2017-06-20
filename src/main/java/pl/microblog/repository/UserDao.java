package pl.microblog.repository;

import pl.microblog.model.User;

import java.util.List;

public interface UserDao {
	User getUserBylogin(String login);
	void createUser(User user);
	List<String> getAllUsers();
}
