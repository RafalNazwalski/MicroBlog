package pl.microblog.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.microblog.model.Follower;

@Repository
public class FollowerDaoImpl implements FollowerDao{
	
	private NamedParameterJdbcTemplate template;
	private static final String ADD_TO_FOLLOWER = "INSERT INTO follower(follower_id,followee_id) VALUES(:follower_id,:followee_id)";
	private static final String REMOVE_TO_FOLLOWER = "DELETE * FROM follower WHERE follower_id = :follower_id AND followee_id = :followee_id";
	
	public FollowerDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public void addUserToFollower(Follower follower) {
		
		Map<String,Object> params = new HashMap<>();
		
		params.put("follower_id", follower.getIdfollower());
		params.put("followee_id", follower.getIdfollowee());
		template.update(ADD_TO_FOLLOWER, params);
		
	}

	@Override
	public void removeUserToFollower(Follower follower) {
		Map<String,Object> params = new HashMap<>();
		
		params.remove("follower_id", follower.getIdfollower());
		params.remove("followee_id", follower.getIdfollowee());
		template.update(REMOVE_TO_FOLLOWER, params);
		
	}

	@Override
	public Boolean checkFollowerOnMyList(Follower follower) {
		// TODO Auto-generated method stub
		return null;
	}

}
