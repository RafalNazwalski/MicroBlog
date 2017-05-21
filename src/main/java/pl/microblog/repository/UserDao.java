package pl.microblog.repository;

import pl.microblog.model.User;

public interface UserDao {
	User getUserBylogin(String login);
	void createUser(User user);
}
