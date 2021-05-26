package service;

import dao.AuthRepository;
import entities.Auth;
import entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    public SessionFactory factory;
    AuthRepository authRepository;

    public AuthService() {
        factory = new Configuration().configure().buildSessionFactory();
        authRepository = new AuthRepository(factory);
    }

    public Boolean tryAuth(String login, String password) throws SQLException {
        Auth auth = authRepository.getByLogin(login);
        CryptWorker cryptWorker = new CryptWorker();

        //String CheckPassword = cryptWorker.Crypt(password);
        if(auth.password.equals(password)){
            return true;
        }
        return false;
    }

//    public Boolean TryAuth(String login, String password) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        String sql = "SELECT id FROM AuthServiceUnused WHERE login=(?) AND password=(?)";
//        Boolean check = null;
//
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if(resultSet.next()){
//                check = true;
//            }
//            else {
//                check = false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (preparedStatement != null){
//                preparedStatement.close();
//            }
//            if (connection != null){
//                closeConnection();
//            }
//        }
//        return check;
//    }
}
