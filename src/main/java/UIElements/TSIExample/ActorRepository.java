package UIElements.TSIExample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    @Query(value = "SELECT * FROM actor WHERE first_name = ?1", nativeQuery = true)
    Optional<Iterable<Actor>> findByFirstName(@Param("firstname") String firstName);



    @Query (value = "SELECT actor.first_name, actor.last_name, actor.actor_id FROM actor "
            + "INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id "
            + "INNER JOIN film ON film_actor.film_id = film.film_id "
            + "WHERE film.film_id = :id "
            , nativeQuery = true)
    Optional<Iterable<Actor>> findFilmsActors(@Param("id") int id);

    @Query (value = "SELECT actor.first_name, actor.last_name, actor.actor_id FROM actor "
            + "INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id "
            + "INNER JOIN film ON film_actor.film_id = film.film_id "
            + "WHERE film.title = :filmTitle "
            , nativeQuery = true)
    Optional<Iterable<Actor>> findFilmsActorsFromFilmTitle(@Param("filmTitle") String filmTitle);



}
