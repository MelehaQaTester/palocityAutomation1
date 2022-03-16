package paylocity.step_defination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import paylocity.utlities.Driver;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver().get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }

}
