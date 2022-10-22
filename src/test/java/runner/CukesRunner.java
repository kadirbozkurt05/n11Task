package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        glue = "step_defs",
        features = "src/test/resources",
        plugin = "html:target/cucumberReport.html",
        tags = ""
)

public class CukesRunner {
}
