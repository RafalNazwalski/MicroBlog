package pl.microblog.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.model.User;
import pl.microblog.repository.UserDao;

@Service
public class UserService {
	
	private UserDao userdao;
	
	@Autowired
	public UserService(UserDao userdao){
		this.userdao = userdao;
	}
	
	
	public User getUserBylogin(String login){
		User userBylogin = userdao.getUserBylogin(login);
		return userBylogin;
	}
	
	public void createUser(User user){
		//user.setPassword(encodePassword(user.getPassword()));
		String encodePassword = encodePassword(user.getPassword());
		user.setPassword(encodePassword);
		System.out.println(encodePassword);
		userdao.createUser(user);
	}
	
	public String encodePassword(String password) {
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		return hashedPassword;
	}
	
	private boolean verifyPassword(String password, String hashedPassword) {
		boolean check = BCrypt.checkpw(password, hashedPassword);
		return check;
	}
	
	public boolean validateUser(User user){
		if(user.getLogin() == null){
			return false;
		}
		 User userBylogin = userdao.getUserBylogin(user.getLogin());
		 boolean correctUser = true;
		 if(userBylogin == null){
			return false;
		 }
		 if(!verifyPassword(user.getPassword(), userBylogin.getPassword())){
			 correctUser = false;
		 }
		 return correctUser;
	}
	
}
