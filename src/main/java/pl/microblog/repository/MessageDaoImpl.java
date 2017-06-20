package pl.microblog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.microblog.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao{

	@Override
	public List<Message> getMessageByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessageByFollower() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
