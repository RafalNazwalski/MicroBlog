package pl.microblog.repository;

import pl.microblog.model.Follower;

public interface FollowerDao {

	public void addUserToFollower(Follower follower);
	
	public void removeUserToFollower(Follower follower);
	
	public Boolean checkFollowerOnMyList(Follower follower);
}
