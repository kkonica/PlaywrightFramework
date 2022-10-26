package StepDef;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverUtils;

import java.nio.file.Paths;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        DriverUtils.createPage();
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot;
            screenshot= DriverUtils.getPage().screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("screenshot.png"))
                    .setFullPage(true));


            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverUtils.getPage().context().browser().close();
    }

    }


