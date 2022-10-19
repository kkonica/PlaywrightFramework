package StepDef;

import PageObjects.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverUtils;

public class ProductStepDef {
    ProductPage product = new ProductPage(DriverUtils.getPage());
    @When("I click on second item link")
    public void i_click_on_second_item_link() {
        product.switchToIndividualProductpage();
    }

    @When("I click on Add to Cart button")
    public void i_click_on_add_to_cart_button() {
        product.clickCartButton();
    }

    @Then("TV should be added in the cart")
    public void tv_should_be_added_in_the_cart() {
        product.verifyIfItemIsAddedInCart();
    }

    @Then("TV should be added in the cart invalid")
    public void tv_should_be_added_in_the_cart_invalid() {
        product.verifyIfItemIsAddedInCartInvalid();
    }
}
