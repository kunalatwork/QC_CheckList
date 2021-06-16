package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features=".//Features/QC_CheckList.feature",
                  glue="Steps",
                  dryRun = false,
                  monochrome = true,
                  plugin = {"html:Reports/QC_CheckList-Report",
                		  "rerun:failedTest/FailedCase.txt"},
                  tags= {"@step5"}
		        )

public class TestRunner {

}
