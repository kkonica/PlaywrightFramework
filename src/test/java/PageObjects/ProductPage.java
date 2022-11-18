package PageObjects;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.Assert;
import utils.PlaywrightFactory;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ProductPage {
    private Page page;
    private Page popup;
    String searchResult = "div[data-component-type=s-search-result] h2 > a >> nth=1";
    String productTitle = "id=productTitle";

    String cartButton = "input#add-to-cart-button";
    String cartItemText = "span:has-text('Added to Cart')";
    String title = "id=titleSection";
    public ProductPage(Page page) {
        this.page= page;
    }

    public void switchToIndividualProductpage(){
        String productTextOnSearchPage = page.locator(searchResult).textContent();

        BrowserContext bx = PlaywrightFactory.browser.newContext();

        popup = page.waitForPopup(() ->{
            page.locator(searchResult).click();
        });

        Assert.assertEquals(productTextOnSearchPage.trim(), popup.locator(productTitle).textContent().trim());


    }

    public void clickCartButton(){
        popup.waitForSelector(title).isVisible();
        popup.locator(cartButton).click();
    }

    public void verifyIfItemIsAddedInCart(){
        System.out.println(popup.locator(cartItemText).textContent());
        Locator d = popup.locator(cartItemText);
        Assert.assertTrue(d.isVisible());

    }

    public void verifyIfItemIsAddedInCartInvalid(){
        System.out.println(popup.locator(cartItemText).textContent());
        Locator d = popup.locator(cartItemText);
        Assert.assertFalse(d.isVisible());

    }
}
