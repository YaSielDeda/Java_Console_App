package dao;

import entities.Auth;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class AuthRepository {

    private final SessionFactory factory;

    public AuthRepository(final SessionFactory factory) {
        this.factory = factory;
    }

    public Auth getByLogin(String login) throws SQLException {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            Auth auth = session.get(Auth.class, login);
            session.getTransaction().commit();
            return auth;
        }
        catch (Exception e){
            return null;
        }
    }
}
