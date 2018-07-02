package models;

import javax.persistence.*;

@Entity
@Table(name="footballers")
public class Footballer {

    private int id;
    private String firstName;
    private String lastName;
    private String team;

    public Footballer(){}

    public Footballer(String firstName, String lastName, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="First_Name")

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="Last_Name")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="Team")

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
