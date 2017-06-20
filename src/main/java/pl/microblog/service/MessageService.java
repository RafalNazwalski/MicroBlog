package pl.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.repository.MessageDao;

@Service
public class MessageService {
	
	private MessageDao messagaDao;

	@Autowired
	public MessageService(MessageDao messagaDao) {
		this.messagaDao = messagaDao;
	}
	
	

}
