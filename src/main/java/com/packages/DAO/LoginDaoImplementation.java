package com.packages.DAO;

import com.packages.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDaoImplementation implements LoginDaoInterface {

    @Autowired
    DataSource datasource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Login validateLogin(Login login) {
        String sql = "select * from users where username='"+login.getUsername()+"'" ;
        List<Login> users = jdbcTemplate.query(sql, new LoginMapper());
        System.out.println("in DAO ====="+users);
        return users.size() > 0 ? users.get(0) : null;
    }

    public Login registerUser(Login login) {
        String sql = "insert into users values ('"+login.getUsername()+"','"+login.getPassword()+"')";
        jdbcTemplate.execute(sql);
        return validateLogin(login);

    }
}
class LoginMapper implements RowMapper<Login> {
    public Login mapRow(ResultSet rs, int arg1) throws SQLException {
        Login login = new Login();
        login.setUsername(rs.getString("username"));
        login.setPassword(rs.getString("password"));

        return login;
    }
}
