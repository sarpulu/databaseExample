package UIElements.TSIExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorTest {

    @Test
    public void testEmptyConstructor(){
        FilmActor filmActor = new FilmActor();
        Assertions.assertNotNull(filmActor);
    }

    @Test
    public void setterGetterFilmActorFilmID(){
        FilmActor filmActor = new FilmActor();
        Film film = new Film();
        filmActor.setFilmID(film);
        Assertions.assertInstanceOf(Film.class,filmActor.getFilmID());
    }

    @Test
    public void setterGetterFilmActorActorID(){
        FilmActor filmActor = new FilmActor();
        Actor actor = new Actor();
        filmActor.setActorID(actor);
        Assertions.assertInstanceOf(Actor.class,filmActor.getActorID());
    }
}
