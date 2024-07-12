package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun=false,
        strict=true,
        monochrome=true,
        features= {"src/test/java/features"},
       // features= {"src/main/resources/Feature/"},
        glue = "stepDefinition",
        plugin= {"pretty",
                "html:target/site/cucumber-html",
                "json:JsonReport/cucumber1.json"}
       // tags= {"@Google"}
      //  tags= {"@Regression"}
)
public class Runner {
//@RunWith(CustomRunner.class)




}


