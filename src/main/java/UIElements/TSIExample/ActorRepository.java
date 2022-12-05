package UIElements.TSIExample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    @Query(value = "SELECT * FROM actor WHERE first_name = ?1", nativeQuery = true)
    Iterable<Actor> findByFirstName(String firstName);


}
