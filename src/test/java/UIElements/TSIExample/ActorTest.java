package UIElements.TSIExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testEmptyConstructor(){
        Actor actor = new Actor();
        Assertions.assertNotNull(actor);
    }

    @Test
    public void testConstructor(){
        Actor actor = new Actor("first","last");
        Assertions.assertEquals("first",actor.getFirstname());
        Assertions.assertEquals("last",actor.getLastname());
    }

    @Test
    public void setterGetterFilmID(){
        Actor actor = new Actor();
        actor.setActorID(1);
        Assertions.assertEquals(1,actor.getActorID());
    }

    @Test
    public void setterGetterFirstName(){
        Actor actor = new Actor();
        actor.setFirstname("name");
        Assertions.assertEquals("name",actor.getFirstname());
    }

    @Test
    public void setterGetterLastName(){
        Actor actor = new Actor();
        actor.setLastname("name");
        Assertions.assertEquals("name",actor.getLastname());
    }




}
