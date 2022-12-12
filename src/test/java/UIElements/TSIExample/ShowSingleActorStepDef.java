package UIElements.TSIExample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleActorStepDef {

    @Autowired
    ActorRepository actorRepository;

    int actorID;
    Actor chosenActor;

    @Given("Actor exists with id {int}")
    public void actor_exists_with_id(int id){
        actorID = id;
        actorRepository.findById(actorID)
                .orElseThrow(()-> new ResourceAccessException("Actor doesn't exist"));

    }

    @When("I request the actors details")
    public void i_request_the_actors_details(){
        chosenActor = actorRepository.findById(actorID)
                .orElseThrow(()-> new ResourceAccessException("Actor doesn't exist"));

        Assertions.assertNotEquals(null,chosenActor,"Actor wasn't retrieved");
    }

    @Then("The web page should show the first name {string} and last name {string}")
    public void the_web_page_should_show_the_first_name_and_last_name(String firstName,String lastName){
        String correctDetails = firstName + " " + lastName;
        String testDetails = chosenActor.getFirstname() + " " + chosenActor.getLastname();
        Assertions.assertEquals(correctDetails,testDetails,"Details are mismatched");
    }


}
