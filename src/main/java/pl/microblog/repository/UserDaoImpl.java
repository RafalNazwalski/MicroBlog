package pl.microblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.microblog.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate template;
	private static final String GET_USER_BY_LOGIN = "SELECT * FROM uzytkownik WHERE login = :login";
	private static final String CREATE_USER = "INSERT INTO uzytkownik(firstname, lastname, login, password) "
			+ "values (:firstname, :lastname, :login,:password)";
	
	@Autowired
	public UserDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
		
	}

	@Override
	public User getUserBylogin(String login) {
		Map<String, String> params = new HashMap<>();
		params.put("login",login);
		List<User> query = template.query(GET_USER_BY_LOGIN, params,userMapper);
		
		 User resultUser = null;
	        if(query != null && !query.isEmpty()) {
	        	resultUser = query.get(0);
	        }
			return resultUser;
	}

	@Override
	public void createUser(User user) {
		Map<String,String> params = new HashMap<>();
		params.put("firstname", user.getFirstName());
		params.put("lastname", user.getLastName());
		params.put("login", user.getLogin());
		params.put("password", user.getPassword());
		template.update(CREATE_USER, params);
	}
	
	
	private RowMapper<User> userMapper = (resultSet, rowNum) -> {
		User user = new User();
		
		user.setId(resultSet.getInt("uzytkownik_id"));
		user.setFirstName(resultSet.getString("firstname"));
		user.setLastName(resultSet.getString("lastname"));
		user.setLogin(resultSet.getString("login"));
		user.setPassword(resultSet.getString("password"));
		
		return user;
	};
}
