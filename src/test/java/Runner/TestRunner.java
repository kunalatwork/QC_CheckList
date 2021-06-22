package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features=".//Features/QC_CheckList.feature",
                  glue="Steps",
                  dryRun = false,
                  monochrome = true,
                  plugin = {"html:Reports/QC_CheckList-Report",
                		  "rerun:failedTest/FailedCase.txt",
                		  "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
                  tags= {"@step1"}
		        )

public class TestRunner {
	  @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
}
}
