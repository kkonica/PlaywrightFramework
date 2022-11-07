package PageObjects;

import com.microsoft.playwright.Page;

public class GemfireLoginPage {

    private Page page;

    String enableDevModeButton = "id=loginBtnId";

    String locator1="xpath=//a[contains(text(),'locator1')]";

    String membersTab = "xpath=//button[contains(text(),'Members')]";

    String membersTabInvalid = "xpath=//button[contains(text(),'a')]";

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
    }

    public void verifyClusterMembersAndRegionsAreNotVisible(){
        page.locator(membersTabInvalid).isVisible();
    }
}
