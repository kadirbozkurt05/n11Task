package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {

    @After
    public void teardown(Scenario scenario){
        byte[] array = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(array,"image/png","ScreenShot");
    }
    @AfterAll
    public static void before_or_after_all(){
        Driver.close();
    }

}
