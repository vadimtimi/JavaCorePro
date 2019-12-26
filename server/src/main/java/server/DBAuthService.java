package server;

import org.sqlite.JDBC;

import java.sql.*;

public class DBAuthService implements AuthService {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    ClassLoader classLoader = this.getClass().getClassLoader();

    public DBAuthService() {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        //connection = DriverManager.getConnection(JDBC.PREFIX + classLoader.getResource("main.db"));
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        //connection = DriverManager.getConnection(JDBC.PREFIX + "E:\\chat\\chat\\server\\src\\main\\resources\\main.db");
        statement = connection.createStatement();
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String pass) {

        System.out.println("getNicknameByLoginAndPassword");

        String result = null;

        try {
            String sql = "SELECT nick FROM users WHERE login = '?' AND password = '?';";
//            ResultSet rs = statement.executeQuery("SELECT nick FROM users WHERE login = '" + login + "' AND password = '" + pass + "';");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getString("nick");
                System.out.println("getNicknameByLoginAndPassword = " + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void changeNick(String currentNick, String newNick) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET nick = '?' WHERE nick = '?';");
            preparedStatement.setString(1, newNick);
            preparedStatement.setString(2, currentNick);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean searchNick(String nick) {

        boolean result = false;

        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(nick) AS count FROM users WHERE nick = '?';");
            preparedStatement.setString(1, nick);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.getInt("count") > 0) result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return true;
    }
}
