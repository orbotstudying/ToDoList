package authorize;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.HibernateUtil;

/**
 * Created by orbot on 14.06.15.
 */
public class Authorization {
    static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    private static StringEncryptor encryptor = (StandardPBEStringEncryptor)ctx.getBean("stringEncrypter");
    public static boolean login(String login, String password) {
        boolean logged;
        try {
            logged = login.equals("orbot") && password.equals(encryptor.decrypt("Qq4LF6hLkD82wprIfkWxmw=="));
        } catch (NullPointerException e) {
            return false;
        }
        return logged;
    }

    public static int register(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String passwordEncrypted = encryptor.encrypt(password);
        User newbie = new User(login, passwordEncrypted);
        session.save(newbie);
        transaction.commit();
        session.close();
        return 0;
    }
}
