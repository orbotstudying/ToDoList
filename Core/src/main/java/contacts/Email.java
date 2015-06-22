package contacts;

import javax.persistence.*;

/**
 * Адрес электронной почты
 */
@Entity
@Table(name = "emails")
public class Email {
    /**
     * Сам адрес
     */
    @Column(name = "email_address")
    private String address;

    /**
     * Основной ли это e-mail?
     */
    @Column(name = "email_isprimary")
    private boolean primary;
    @Id @GeneratedValue
    @Column(name = "email_id")
    private long id;

    /**
     * Тип e-mail'а
     */
    @Enumerated(EnumType.STRING)
    private ContactType type;

    public Email() {
    }

    public Email(String address) {
        this.address = address;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return String.format("<a href=\"mailto:%s\">%s</a>", address, address);
    }
}
