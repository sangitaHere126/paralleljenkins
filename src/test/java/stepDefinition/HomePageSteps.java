package stepDefinition;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageSteps {
    public TestContext context;
    public HomePage homePage;

    public HomePageSteps(TestContext context){
        this.context=context;
        this.homePage=context.getPageObjectManager().getHomePage();
    }

    @Before
    public void before(Scenario scenario){
        context.createScenario(scenario.getName());
        System.out.println("---- starting "+scenario.getName());
    }

    @After
    public void after(Scenario scenario){
        context.endScenario();
       // context.getPageObjectManager().getWebDriverManager().quit();
    }

    @Given("^User opens (.*)$")
    public void openBrowser(String browserName){
        homePage.load_url(browserName);
    }

    @And("^Goes to (.*)$")
    public void navigateToUrl(String url) {
        homePage.navigate(url);

    }
    @And("^Enters (.*) in (.*)$")//<SearchText> in <SearchOR>
    public void entersText(String textData, String oRKey){
        context.entersText(textData, oRKey);

    }

}


