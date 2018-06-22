package dao;

import model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import utils.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private final String CREATE = "INSERT INTO user(username, password, email, question) " +
            "VALUES (:username, :password, :email, :question);";
    private final String GET_USER_BY_USERNAME = "SELECT * FROM user WHERE username = :username";

    private final String SET_PRIVIGILES = "INSERT INTO user_role (username)VALUES (:username)";

    private NamedParameterJdbcTemplate template;

    public UserDAO() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    public void create(User user){

        User resultUser = new User(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int update = template.update(CREATE, parameterSource, keyHolder);
        if (update > 0){
            setPrivigiles(user);
        }
    }
    public User getUserByUsername(String username){

        User user = new User();
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", username);
        user = template.queryForObject(GET_USER_BY_USERNAME, parameterSource, new UserRowMapper());
        return user;
    }
    private void setPrivigiles(User user){
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(SET_PRIVIGILES, parameterSource);
    }
    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setQuestion(resultSet.getString("question"));
            return user;
        }
    }

}
