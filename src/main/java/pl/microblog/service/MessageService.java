package pl.microblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.model.Message;
import pl.microblog.model.User;
import pl.microblog.repository.MessageDao;

@Service
public class MessageService {
	
	private MessageDao messageDao;

	@Autowired
	public MessageService(MessageDao messagaDao) {
		this.messageDao = messagaDao;
	}
	
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}
	
	public List<Message> getMessageByUser(User user) {
		List<Message> messageByUser = messageDao.getMessageByUser(user);
		return messageByUser;
	}
	
	public List<Message> getMessageByFollower(User user) {
		List<Message> messageByFollower = messageDao.getMessageByFollower(user);
		return messageByFollower;
	}

}
