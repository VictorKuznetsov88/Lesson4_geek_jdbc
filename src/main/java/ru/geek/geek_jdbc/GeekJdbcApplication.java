package ru.geek.geek_jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class GeekJdbcApplication {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement inststatement = null;
        PreparedStatement statement = null;

        ResultSet resultSet = null;
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            inststatement = connection.createStatement();
            inststatement.execute("INSERT INTO user (name,age,email) VALUE ('Natasha',43,'step32@mail.ru')");
            statement = connection.prepareStatement("SELECT * FROM user ");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge((int) resultSet.getLong("age"));
                user.setEmail(resultSet.getString ("email"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println(users);

    }


    private static DataSource createDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root2020");
        dataSource.setUrl("jdbc:mysql://localhost:3306/geek");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }
    }

