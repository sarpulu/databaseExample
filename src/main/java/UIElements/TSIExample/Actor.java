package UIElements.TSIExample;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;

@Entity
@Table(name="actor")

public class Actor {



    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorID;

    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    public Actor(){

    }

    public Actor(String first,String last){
        lastname = last;
        firstname = first;
    }

    public int getActorID() {return actorID;}

    public void setActorID(int actorID) {this.actorID = actorID;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}


}
