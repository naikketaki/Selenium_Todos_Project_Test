package runner;


import org.junit.runner.RunWith;	
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@Cucumber.Options(features="feature", glue= {"stepDefination"}, monochrome= true)
//@CucumberOptions( glue = {"src/stepDefination"}, features = {"src/features1/tODOApplication.feature"}, monochrome= true)
//features = {"src/main/java/utils"}
public class TestRunner {

}
