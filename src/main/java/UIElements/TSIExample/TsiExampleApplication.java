package UIElements.TSIExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class TsiExampleApplication {

	@Autowired
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;

	@Autowired
	public TsiExampleApplication(ActorRepository ar,FilmRepository fr){
		actorRepository = ar;
		filmRepository = fr;

	}

	public static void main(String[] args) {
		SpringApplication.run(TsiExampleApplication.class, args);
	}

	@GetMapping("/allactors")
	public @ResponseBody Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/actorsByName/{firstname}")
	public @ResponseBody Iterable<Actor> getActorByName(@PathVariable String firstname){

		return actorRepository.findByFirstName(firstname);
	}

	@GetMapping("/actors/{id}")
	public @ResponseBody Actor getActorFromId(@PathVariable Integer id){

		return actorRepository.findById(id)
				.orElseThrow(()-> new ResourceAccessException("actor not found"));

	}

	@PutMapping("/actors/{id}")
	public Actor updateActor(@RequestBody Actor newActor, @PathVariable Integer id){

		return actorRepository.findById(id)
				.map(actor -> {
					actor.setFirstname(newActor.getFirstname());
					actor.setLastname(newActor.getLastname());
					return actorRepository.save(actor);
				})
				.orElseGet(()->{
					newActor.setActorID(id);
					return actorRepository.save(newActor);
				});

	}

	@PostMapping("/actors")
	public Actor newActor(@RequestBody Actor newActor) {
		return actorRepository.save(newActor);

	}

	@DeleteMapping("/actors/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorRepository.deleteById(id);
	}

	//FILMS

	@GetMapping("/allfilms")
	public @ResponseBody Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}




}
