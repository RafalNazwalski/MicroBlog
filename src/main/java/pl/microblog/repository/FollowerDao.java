package pl.microblog.repository;

import pl.microblog.model.User;

public interface FollowerDao {

	public void addUserToFollower(User user);
	
	public void removeUserToFollower(User user);
	
	public Boolean checkFollowerOnMyList(User user);
}
