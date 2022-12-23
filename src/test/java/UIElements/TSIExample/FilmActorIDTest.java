package UIElements.TSIExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorIDTest {

    @Test
    public void testEmptyConstructor(){
        FilmActorId filmActorId = new FilmActorId();
        Assertions.assertNotNull(filmActorId);
    }

    @Test
    public void testConstructor(){
        FilmActorId filmActorId = new FilmActorId(1,1);
        Assertions.assertNotNull(filmActorId);

    }

}
