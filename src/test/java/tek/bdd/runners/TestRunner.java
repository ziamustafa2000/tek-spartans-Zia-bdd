package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", // Directory for Feature file
        glue = "tek.bdd.steps", //Package for all the steps
        dryRun = true, //set to true to scan feature for unimplemented steps
        tags = "@Regression",
        plugin = {        "html:target/cucumber_report/index.html",
                "json:target/jsonReport/report.json"}
)
public class TestRunner {
}

//Running multiple tags => tags = "@Smoke or @Regression"