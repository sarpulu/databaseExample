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
    public void testFilmType(){
        Film film = new Film();
        Assertions.assertInstanceOf(Film.class,film);
    }

}
