package paylocity.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "paylocity/step_defination",
        dryRun = false
)

public class CukesRunner {
}
