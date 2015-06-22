package authorize;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.ToDoListDAO;

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

        try {
            User user = ToDoListDAO.getInstance().getUserByLogin(login);
            if (encryptor.decrypt(user.getPassword())
                    .equals(password)) {
                logged = true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return logged;
    }

    public static int register(String login, String password) {
        try {
            User newbie = new User(login, encryptor.encrypt(password));
            ToDoListDAO.getInstance().save(newbie);
        } catch (ConstraintViolationException e) {
            return 1;
        }
        return 0;
    }
}
