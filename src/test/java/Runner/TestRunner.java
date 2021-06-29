package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features=".//Features/QC_CheckList.feature",
glue="Steps",
dryRun = true,
monochrome = true,
plugin = {"rerun:failedTest/FailedCase.txt",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)

public class TestRunner {

}
