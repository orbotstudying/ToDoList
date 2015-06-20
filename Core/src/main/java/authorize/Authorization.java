package authorize;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.HibernateUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created by orbot on 14.06.15.
 */
public class Authorization {
    static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    private static StringEncryptor encryptor = (StandardPBEStringEncryptor)ctx.getBean("stringEncrypter");
    public static boolean login(String login, String password) {
        boolean logged = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List users = session.createQuery("from User u where u.userName = '" + login + "'").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
                User loadedUser = (User) iterator.next();
                if (encryptor.decrypt(loadedUser.getPassword())
                        .equals(password)) {
                    logged = true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return logged;
    }

    public static int register(String login, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            String passwordEncrypted = encryptor.encrypt(password);
            User newbie = new User(login, passwordEncrypted);
            session.save(newbie);
            transaction.commit();
            session.close();
        } catch (ConstraintViolationException e) {
            return 1;
        }
        return 0;
    }
}
