package UIElements.TSIExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    @Test
    public void testEmptyConstructor(){
        Film film = new Film();
        Assertions.assertNotNull(film);
    }

    @Test
    public void testFilmType(){
        Film film = new Film();
        Assertions.assertInstanceOf(Film.class,film);
    }

    @Test
    public void setterGetterFilmID(){
        Film film = new Film();
        film.setFilmID(1);
        Assertions.assertEquals(1,film.getFilmID());
    }

    @Test
    public void setterGetterFilmTitle(){
        Film film = new Film();
        film.setTitle("title");
        Assertions.assertEquals("title",film.getTitle());
    }

    @Test
    public void setterGetterFilmDescription(){
        Film film = new Film();
        film.setDescription("description");
        Assertions.assertEquals("description",film.getDescription());
    }

    @Test
    public void setterGetterFilmLength(){
        Film film = new Film();
        film.setFilmLength(1);
        Assertions.assertEquals(1,film.getFilmLength());
    }


}
