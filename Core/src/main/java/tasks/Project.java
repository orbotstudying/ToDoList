package tasks;

import contacts.Contact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Проект: состоит из нескольких задач и/или подпроектов
 */
@Entity
@Table(name="projects")
public class Project {
    /**
     * Подпроекты
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subProjects")
    final public List<Project> subProjects = new ArrayList<>();

    /**
     * Задачи
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    public List<Task> tasks = new ArrayList<>();

    /**
     * Ответственные за проект
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    public List<Contact> responsible = new ArrayList<>();

    /**
     * Название проекта
     */
    @Column(name = "project_name")
    String name;

    /**
     * Ссылка на сайт/страницу проекта (если есть)
     */
    @Column(name = "project_link")
    String link;
    @Id @GeneratedValue
    @Column(name = "project_id")
    long id;
    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
