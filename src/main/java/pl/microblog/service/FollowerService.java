package pl.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.repository.FollowerDao;

@Service
public class FollowerService {

	private FollowerDao followerDao;

	@Autowired
	public FollowerService(FollowerDao followerDao) {
		this.followerDao = followerDao;
	}
	
	
}
