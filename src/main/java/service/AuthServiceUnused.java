package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthServiceUnused extends ConnectionObject {
    Connection connection = getConnection();

    public AuthServiceUnused() { }

    public Boolean TryAuth(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id FROM AuthServiceUnused WHERE login=(?) AND password=(?)";
        Boolean check = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                check = true;
            }
            else {
                check = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                closeConnection();
            }
        }
        return check;
    }
}
