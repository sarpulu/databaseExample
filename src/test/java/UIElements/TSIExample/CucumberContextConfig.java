package UIElements.TSIExample;


import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TsiExampleApplication.class)
public class CucumberContextConfig {

}
