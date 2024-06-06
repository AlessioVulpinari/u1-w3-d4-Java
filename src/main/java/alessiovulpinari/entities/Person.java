package alessiovulpinari.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue
    private UUID person_id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Email")
    private String email;

    @Column(name = "Day of birth")
    private LocalDate birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "person")
    private List<Invite> inviteList;

    public Person() {
    }

    public Person(Gender gender, LocalDate birthday, String email, String surname, String name) {
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.surname = surname;
        this.name = name;
    }

    public UUID getPerson_id() {
        return person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}
