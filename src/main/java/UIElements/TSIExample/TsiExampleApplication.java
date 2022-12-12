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

	//STANDARD REQUESTS

	@GetMapping("/allactors")
	public @ResponseBody Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}


	@GetMapping("/actors/{id}")
	public @ResponseBody Actor getActorFromId(@PathVariable Integer id){

		return actorRepository.findById(id)
				.orElseThrow(()-> new ResourceAccessException("actor not found"));

	}

	@PutMapping("/putactor/{id}")
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

	@PostMapping("/newActor")
	public Actor newActor(@RequestBody Actor newActor) {
		return actorRepository.save(newActor);

	}

	@DeleteMapping("/deleteactor/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorRepository.deleteById(id);
	}

	//FILMS

	@GetMapping("/allfilms")
	public @ResponseBody Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}


	@GetMapping("/film/{id}")
	public @ResponseBody Film getFilm(@PathVariable Integer id){
		return filmRepository.findById(id)
				.orElseThrow(()-> new ResourceAccessException("film not found"));
	}

	@GetMapping("/actorsfilms/{id}")
	public @ResponseBody Iterable<Film> getActorsFilm(@PathVariable int id){

		return filmRepository.findActorsFilms(id)
				.orElseThrow(()-> new ResourceAccessException("Actor not found"));
	}

	@GetMapping("actorsfilms/name/{name}")
	public @ResponseBody Iterable<Film> getActorsFilmfromName(@PathVariable String name){

		if(name.contains("-")) {
			String[] namearr = name.split("-");
			String firstname = namearr[0];
			String lastname = namearr[1];

			return filmRepository.findActorsFilmsfromName(firstname, lastname)
					.orElseThrow(() -> new ResourceAccessException("Actor not found"));
		}
		return null;
	}

	//ACTORS
	@GetMapping("/filmsactors/{id}")
	public @ResponseBody Iterable<Actor> getFilmsActors(@PathVariable int id){

		return actorRepository.findFilmsActors(id)
				.orElseThrow(()-> new ResourceAccessException("Film not found"));
	}

	@GetMapping("/actorsearchfirstname/{firstname}")
	public @ResponseBody Iterable<Actor> getActorByFirstName(@PathVariable String firstname){

		return actorRepository.findByFirstName(firstname)
				.orElseThrow(()-> new ResourceAccessException("Actor not found"));

	}

	@GetMapping("/filmsactors/title/{title}")
	public @ResponseBody Iterable<Actor>  getFilmsActorsFromFilmTitle(@PathVariable String title){

		if(title.contains("-")) {
			String ftitle = title.replace("-", " ");
			return actorRepository.findFilmsActorsFromFilmTitle(ftitle)
					.orElseThrow(() -> new ResourceAccessException("Film not found"));
		}
		return null;
	}



}
