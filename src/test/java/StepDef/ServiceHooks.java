package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverUtils;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        DriverUtils.createPage();
    }

    @After
    public void afterScenario(){
        //DriverUtils.getPage().context().browser().close();
    }

}
