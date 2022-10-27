package StepDef;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        DriverUtils.createPage();
    }

    public static String captureScreenshot(){
        String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
        byte[] screenshot;
        screenshot= DriverUtils.getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));

        String base64Path= "data:image/png;base64"+ Base64.getEncoder().encodeToString(screenshot);
        return base64Path;
    }
    @After
    public void afterScenario(Scenario scenario) throws IOException {

        if(scenario.isFailed()) {

            scenario.attach(captureScreenshot(), "image/png", "image");
        }
        DriverUtils.getPage().context().browser().close();
    }

    }


