package pl.microblog.repository;

import org.springframework.stereotype.Repository;

import pl.microblog.model.User;

@Repository
public class FollowerDaoImpl implements FollowerDao{
	
	
	private static final String ADD_TO_FOLLOWER = "INSERT INTO follower(userid,folowee_id) VALUES(:userId,:foloweeId)";
	
	@Override
	public void addUserToFollower(User user) {
		
		
	}

	@Override
	public void removeUserToFollower(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean checkFollowerOnMyList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
