package persistence;

import authorize.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tasks.Project;
import tasks.Task;

import java.util.List;


public class ToDoListDAO {

    private SessionFactory sessionFactory;
    private static ToDoListDAO instance = null;
    private Transaction transaction;

    private ToDoListDAO() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void shutDown(){
        //closes caches and connections
        getSessionFactory().close();
    }

    public void save(Object object) {
        Session session = startSessionWithTransaction();
        session.save(object);
        closeSession(session);
    }

    public User getUserByLogin(String login) {
        Session session = startSessionWithTransaction();
        User user = (User)session.createQuery("from User u " +
                "where u.userName = '" + login + "'").uniqueResult();
        closeSession(session);
        return user;
    }

    public List<Task> getTasks() {
        Session session = startSessionWithTransaction();
        List taskList = (List)session.createQuery("from Task t " +
                "order by t.id asc").list();
        closeSession(session);
        return taskList;
    }

    private Session startSessionWithTransaction() {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    private void closeSession(Session session) {
        transaction.commit();
        session.close();
    }

    public static ToDoListDAO getInstance() {
        if(instance == null) {
            instance = new ToDoListDAO();
        }
        return instance;
    }
}