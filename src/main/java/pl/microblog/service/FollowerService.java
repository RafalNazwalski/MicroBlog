package pl.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.model.Follower;
import pl.microblog.repository.FollowerDao;

@Service
public class FollowerService {

	private FollowerDao followerDao;

	@Autowired
	public FollowerService(FollowerDao followerDao) {
		this.followerDao = followerDao;
	}
	
	public void addUserToFollower(Follower follower) {
		followerDao.addUserToFollower(follower);
	}
	
	public void removeUserToFollower(Follower follower) {
		followerDao.removeUserToFollower(follower);
	}

	public Boolean checkFollowerOnMyList(Follower follower) {
		// TODO Auto-generated method stub
		return null;
	}
}
