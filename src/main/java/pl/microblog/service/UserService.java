package pl.microblog.service;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.microblog.model.User;
import pl.microblog.repository.UserDao;
import spark.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

	public List<String> getAllUsers(){
		List<String> allUsers = userdao.getAllUsers();
		return allUsers;
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
	
	public Map<String,String> getErrorsWhileRegister(User user){
		HashMap<String, String> errors = new HashMap<>();
		if(StringUtils.isEmpty(user.getFirstName())) errors.put("firstNameInvalid", "Prosz� wype�ni� imi�.");
		if(StringUtils.isEmpty(user.getLastName())) errors.put("lastNameInvalid","Prosz� wype�ni� nazwisko.");
		if(StringUtils.isEmpty(user.getLogin())) errors.put("loginInvalid", "Nie podano loginu");
		if(StringUtils.isEmpty(user.getPassword())) errors.put("passwordInvalid", "Wprowad� has�o");
		return errors;
	}
	
}
