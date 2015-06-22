package contacts;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Контакт
 */
@Entity
@Table(name = "contacts")
public class Contact {
    /**
     * E-mail'ы
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    public List<Email> emails = new ArrayList<>();



    /**
     * Фамилия Имя Отчество
     */
    @Id
    @Column(name = "contact_id")
    @GeneratedValue
    private long id;
    @Column(name = "contact_surname")
    String surname;
    @Column(name = "contact_name")
    String name;
    @Column(name = "contact_patronymic")
    String patronymic;
    /**
     * Дата рождения
     */
    @Column(name = "contact_birth_date")
    Date dateOfBirth;

    public Contact(String fullName, String email) {
        String[] s = fullName.split("\\s+");
        surname = s[0];
        name = s[1];
        patronymic = s[2];

        Email e = new Email(email);
        e.setPrimary(true);
        emails.add(e);
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
