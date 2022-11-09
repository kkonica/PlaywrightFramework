package PageObjects;

import com.microsoft.playwright.Page;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GemfireLoginPage {

    private Page page;

    String enableDevModeButton = "id=loginBtnId";

    String locator1="xpath=//a[contains(text(),'locator12')]";

    String membersTab = "xpath=//button[contains(text(),'Members')]";

    String memberDetails = "xpath=//section[@id=\"clr-tab-content-0\"]/app-cluster-member-details";

    String regionTab= "xpath=//button[contains(text(),'Regions')]";
    public GemfireLoginPage(Page page){

        this.page= page;
    }

    public void visitURL(){
        page.navigate("http://localhost:8080/login");
        System.out.println(page.title());
    }

    public void enableDevMode(){
       page.locator(enableDevModeButton).click();
    }

    public void verifyLocatorIsVisible(){
        page.locator(locator1).isVisible();
    }

    public void connectToCluster(){
        page.locator(locator1).click();
    }

    public void verifyClusterMembersAndRegionsAreVisible(){
        page.locator(membersTab).isVisible();
        page.locator(regionTab).isVisible();

        page.locator(memberDetails).isVisible();
        assertThat(page.locator(memberDetails)).isVisible();
    }

    public void verifyClusterMembersAndRegionsAreNotVisible(){
        page.locator(memberDetails).isVisible();
        assertThat(page.locator(memberDetails)).isVisible();
        assertThat(page.locator("kk")).isVisible();
    }
}
