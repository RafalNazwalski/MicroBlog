package pl.microblog.repository;

import java.util.List;

import pl.microblog.model.Message;
//TODO dodaæ parametry do metod
public interface MessageDao {
	
	public List<Message> getMessageByUser();
	
	public List<Message> getMessageByFollower();
	
	public List<Message> getAllMessage();
	
	public void addMessage(Message message);

}
