package btk.gov.restapitest.entities;

import jakarta.persistence.*;

@Entity(name = "ogrenci")
public class Ogrenci {

    @Id   //primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ogrenci_generator")
    @SequenceGenerator(name="ogrenci_generator",sequenceName = "ogrenci_id_sequence")
    private int id; //primary key

    private String name;

    private String surname;

    public Ogrenci(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Ogrenci(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Ogrenci() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

