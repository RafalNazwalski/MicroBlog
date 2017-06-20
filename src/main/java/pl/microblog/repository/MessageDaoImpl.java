package pl.microblog.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.microblog.model.Message;
import pl.microblog.model.User;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	private NamedParameterJdbcTemplate template;
	private static final String CREATE_MESSAGE = "INSERT INTO wpis(author_id, wpis_date, text) "
					+ "values (:author_id, :wpis_date, :text)";
	private static final String GET_MESSAGE_BY_ID = "SELECT * FROM wpis LEFT JOIN uzytkownik "
			+ "ON wpis.author_id = uzytkownik.uzytkownik_id WHERE author_id = :id";
	private static final String REMOVE_MESSAGE_BY_WPIS_ID = "DELETE * FROM wpis WHERE wpis_id = :wpis_id";
			
	private static final String GET_MESSAGES = "select * from uzytkownik u"
 + "where u.uzytkownik_id = :id"
 + "join follower f on u.uzytkownik_id = f.userid"
 +"join wpis w on f.followee_id = w.author_id";
	
	public MessageDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}
	
	@Override
	public void addMessage(Message message) {
		Map<String,Object> params = new HashMap<>();
		
		String text = message.getText();
		Integer author = message.getAuthor();
		Date date = message.getDate();
		
		params.put("text", text);
		params.put("author", author);
		params.put("date", date);
		
		template.update(CREATE_MESSAGE, params);
	}
	
	@Override
	public void removeMessage(User user) {
		Map<String,Object> params = new HashMap<>();
		
		
		
	}

	@Override
	public List<Message> getMessageByUser(User user) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", user.getId());
		
		List<Message> query = template.query(GET_MESSAGE_BY_ID, params, messageMapper);
		
		return query;
	}

	@Override
	public List<Message> getMessageByFollower(User user) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", user.getId());
		
		List<Message> query = template.query(GET_MESSAGE_BY_ID, params, messageMapper);
		return query;
	}

	private RowMapper<Message> messageMapper = (resultSet, rowNum) -> {
		
		Message message = new Message();
		
		message.setAuthor(resultSet.getInt("author_id"));
		message.setDate(resultSet.getDate("wpis_date"));
		message.setId(resultSet.getInt("wpis_id"));
		message.setText(resultSet.getString("text"));
		
		return message;
	};

}
