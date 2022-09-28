package StepDef;

import PageObjects.HomePage;
import io.cucumber.java.en.*;
import utils.DriverUtils;

public class HomeStepDef {

    HomePage homePage = new HomePage(DriverUtils.getPage());
    @Given("I open the URL")
    public void i_open_the_url() {
       homePage.openUrl();
    }
    @When("I click on Search input box")
    public void i_click_on_search_input_box() {
        homePage.clickOnSearch();
    }
    @When("I search for item")
    public void i_search_for_item() {
        homePage.searchForItem();
    }

}
