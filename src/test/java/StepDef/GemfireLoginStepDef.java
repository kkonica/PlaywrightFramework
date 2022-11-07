package StepDef;

import PageObjects.GemfireLoginPage;
import io.cucumber.java.en.*;
import utils.DriverUtils;

public class GemfireLoginStepDef {

    GemfireLoginPage login = new GemfireLoginPage(DriverUtils.getPage());
    @Given("the user visits gemfire app url")
    public void the_user_visits_gemfire_app_url() {
        login.visitURL();
    }
    @When("the user enables developer mode")
    public void the_user_enables_developer_mode() {
        login.enableDevMode();
    }
    @Then("verify if the user is logged in")
    public void verify_if_the_user_is_logged_in() {
        login.verifyLocatorIsVisible();
    }

    @Then("cluster members and regions are visible")
    public void clusterMembersAndRegionsAreVisible() {
        login.verifyClusterMembersAndRegionsAreVisible();
    }

    @When("the user connects the locator")
    public void theUserConnectsTheLocator() {
        login.connectToCluster();
    }

    @Then("cluster members and regions are not visible")
    public void clusterMembersAndRegionsAreNotVisible() {
        login.verifyClusterMembersAndRegionsAreNotVisible();
    }
}
