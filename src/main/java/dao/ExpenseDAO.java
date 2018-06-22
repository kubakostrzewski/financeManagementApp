package dao;

import model.Expense;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import utils.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpenseDAO {

    private final String CREATE = "INSERT INTO expense(name, date, value, description, type, user_id) " +
            "values (:name, :date, :value, :description, :type, :userId);";
    private final String READ = "SELECT * FROM expense WHERE expense_id=:expenseId";
    private final String UPDATE = "UPDATE expense SET name=:name, date=:date, description=:description, type=:type, " +
            "value=:value WHERE expense_id=:expenseId";
    private final String DELETE = "DELETE FROM expense WHERE expense_id=:expenseId";
    private final String GET_ALL_EXPENSES = "SELECT * FROM expense " +
            "WHERE user_id=:userId;";

    private NamedParameterJdbcTemplate template;

    public ExpenseDAO(){
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    public void create(Expense expense){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(expense);
        template.update(CREATE, parameterSource, keyHolder);
    }
    public Expense read(int expenseId){
        SqlParameterSource parameterSource = new MapSqlParameterSource("expenseId", expenseId);
        Object expense = template.queryForObject(READ, parameterSource, new ExpenseRowMapper());
        return (Expense) expense;
    }
    public void update(Expense expense){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(expense);
        template.update(UPDATE, parameterSource);
    }
    public void delete(int expenseId){
        SqlParameterSource parameterSource = new MapSqlParameterSource("expenseId", expenseId);
        template.update(DELETE, parameterSource);
    }
    public List<Expense> getAll(int userId){
        Expense expense = new Expense();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userId", userId);
        List<Expense> expenseList = template.query(GET_ALL_EXPENSES, sqlParameterSource, new ExpenseRowMapper());

        return expenseList;
    }
    private class ExpenseRowMapper implements RowMapper{
        @Nullable
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Expense expense = new Expense();
            expense.setExpenseId(resultSet.getInt("expense_id"));
            expense.setUserId(resultSet.getInt("user_id"));
            expense.setName(resultSet.getString("name"));
            expense.setDate(resultSet.getDate("date"));
            expense.setDescription(resultSet.getString("description"));
            expense.setType(resultSet.getString("type"));
            expense.setValue(resultSet.getDouble("value"));
            return expense;

        }
    }
}
