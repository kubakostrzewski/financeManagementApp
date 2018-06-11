package dao;

import model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import utils.ConnectionProvider;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private final String CREATE = "INSERT INTO user(username, password, email, question) " +
            "VALUES (:username, :password, :email, :question);";
    private NamedParameterJdbcTemplate template;

    public UserDAO() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    public int create(User user){

        User resultUser = new User(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("username", user.getUsername());
        parameterMap.put("password", user.getPassword());
        parameterMap.put("email", user.getEmail());
        parameterMap.put("question",user.getQuestion());
        SqlParameterSource parameterSource = new MapSqlParameterSource(parameterMap);
        int key = template.update(CREATE, parameterSource, keyHolder);
        return key;
    }
}
