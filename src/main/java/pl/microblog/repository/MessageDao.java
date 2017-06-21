package pl.microblog.repository;

import java.util.List;

import pl.microblog.model.Message;
import pl.microblog.model.User;

public interface MessageDao {
	
	public List<Message> getMessageByUser(User user);
	
	public List<Message> getMessageByFollower(User user);
	
//	public List<Message> getAllMessage();
	
	public void addMessage(Message message);
	
	public void removeMessage(Message message);

}
