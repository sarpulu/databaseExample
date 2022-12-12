package UIElements.TSIExample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer>{

    @Query(value= "SELECT film.title,film.description,film.length,film.film_id FROM film "
            + "INNER JOIN film_actor ON film_actor.film_id = film.film_id "
            +"INNER JOIN actor ON actor.actor_id = film_actor.actor_id "
            +"WHERE actor.actor_id= :id",nativeQuery = true)
    Optional<Iterable<Film>> findActorsFilms(@Param("id") int id);

    @Query(value= "SELECT film.title,film.description,film.length,film.film_id FROM film "
            + "INNER JOIN film_actor ON film_actor.film_id = film.film_id "
            +"INNER JOIN actor ON actor.actor_id = film_actor.actor_id "
            +"WHERE actor.first_name = :firstname AND actor.last_name = :lastname ",nativeQuery = true)
    Optional<Iterable<Film>> findActorsFilmsfromName(@Param("firstname")String firstname,@Param("lastname") String lastname);
}
