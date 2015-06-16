package authorize;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
