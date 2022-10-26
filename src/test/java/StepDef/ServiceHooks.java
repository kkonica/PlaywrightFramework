package StepDef;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverUtils;

import java.nio.file.Paths;
import java.util.Base64;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        DriverUtils.createPage();
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
            byte[] screenshot;
            screenshot= DriverUtils.getPage().screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(path))
                    .setFullPage(true));

            String base64Path= Base64.getEncoder().encodeToString(screenshot);
            scenario.attach(base64Path, "image/png", scenario.getName());
        }
        DriverUtils.getPage().context().browser().close();
    }

    }


