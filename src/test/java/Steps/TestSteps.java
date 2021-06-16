package Steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class TestSteps {

	public WebDriver driver;
	public Properties prop;

	@Before
	public void setup() throws IOException {
		prop=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\lakhan\\SiA-Digital\\Kiverno\\TestData\\Config.properties");
		prop.load(fis);

		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakhan\\SiA-Digital\\Kiverno\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lakhan\\SiA-Digital\\Kiverno\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\lakhan\\SiA-Digital\\Kiverno\\Drivers\\msedhedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get("https://testingadvance.advancesfe.com/");
		driver.manage().window().maximize();
	}

	@Then("^SSL Certificate Expiry$")
	public void ssl_Certificate_Expiry() throws Throwable {

		java.util.Date firstDate=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM", Locale.ENGLISH);
		Date secondDate = sdf.parse("2022-08-01");

		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if(diff>=1) {
			System.out.println("Your SSL Certificate Expiring in : " +diff + " Days");
		}

		else {
			System.out.println("Your SSL certificate has Expired.");
		}
	}

	@Then("^Forgot Password module for email functioning related\\.$")
	public void forgot_Password_module_for_email_functioning_related() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//u[@onclick='forgotPassword();']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=' ']")).sendKeys("kunal.rawat@sia-digital.com");
		driver.findElement(By.xpath("//input[@id='forgotSubmit']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(3000);
		driver.navigate().to("https://testingadvance.advancesfe.com/Home/Login");
	}



	@Then("^Login through multiple users like REP/FLSM/SLSM/ADMIN$")
	public void login_through_multiple_users_like_REP_FLSM_SLSM_ADMIN() throws Throwable {

		// SLSM 

		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("SalesManager@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		System.out.println(driver.getTitle() + " & User is on SLSM Dashboard");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		// FLSM 

		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("AnalyticManager@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();	
		Thread.sleep(3000);
		JavascriptExecutor jsa = (JavascriptExecutor)driver; 
		WebElement aa=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		jsa.executeScript("arguments[0].scrollIntoView();",aa );
		aa.click();

//		WebDriverWait wait = new WebDriverWait(driver, 15);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='FormTypeIdModal0']//p[contains(text(),'All Data')]"))).click();

		Thread.sleep(2000);
		System.out.println(driver.getTitle() + " & User is on FLSM Dashboard");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Rep

		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("QASales@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();	
		Thread.sleep(3000);
		JavascriptExecutor jsb = (JavascriptExecutor)driver; 

		WebElement ab=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		jsb.executeScript("arguments[0].scrollIntoView();",ab );
		ab.click();
		System.out.println(driver.getTitle() + " & User is on Rep Dashboard");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^UI/UX wise proper testing$")
	public void ui_UX_wise_proper_testing() throws Throwable {
		System.out.println("Have to check Manually");
	}

	@Then("^Scores colour should change according to the CMS functioning$")
	public void scores_colour_should_change_according_to_the_CMS_functioning() throws Throwable {
		System.out.println("Have to check Manually");
	}

	@Then("^Scores count should be there as per logic$")
	public void scores_count_should_be_there_as_per_logic() throws Throwable {
		System.out.println("Have to check Manually");
	}

	@Then("^Language change should work perfectly$")
	public void language_change_should_work_perfectly() throws Throwable {
		System.out.println("Have to check Manually");
	}
	@Then("^Forms icon and colour should be test$")
	public void forms_icon_and_colour_should_be_test() throws Throwable {
		System.out.println("Have to check Manually");
	}

	@Then("^Regular QC of active clients$")
	public void regular_QC_of_active_clients() throws Throwable {

	}

	@Then("^Data Dump quality check \\(Data that we download from export button\\)$")
	public void data_Dump_quality_check_Data_that_we_download_from_export_button() throws Throwable {
		System.out.println("Have to check Manually");
	}

	@Then("^The Dashboard icons/buttons should redirect properly\\.$")
	public void the_Dashboard_icons_buttons_should_redirect_properly() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^Redirect MAT button\\.$")
	public void redirect_MAT_button() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^Redirect YTD button$")
	public void redirect_YTD_button() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^Form Icons - on click should go to related form whether it's scoring or coaching form\\.$")
	public void form_Icons_on_click_should_go_to_related_form_whether_it_s_scoring_or_coaching_form() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^Export Buttons should download the data accordingly\\.$")
	public void export_Buttons_should_download_the_data_accordingly() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^NEXT and PREVIOUS buttons in standard report\\.$")
	public void next_and_PREVIOUS_buttons_in_standard_report() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	@Then("^Managers/Coach Names should appear according to filter on SLSM\\.$")
	public void managers_Coach_Names_should_appear_according_to_filter_on_SLSM() throws Throwable {
		System.out.println("Checking in SLSM/FLSM Steps");
	}

	// Menu Item: Tabs/Modules for SLSM

	@Then("^To check menu items-Tabs for SLSM\\. It should work properly\\.$")
	public void to_check_menu_items_Tabs_for_SLSM_It_should_work_properly() throws Throwable {
		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("SalesManager@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@class='menu-toggle']")).click();

	}

	@Then("^check new coaching form of SLSM$")
	public void check_new_coaching_form_of_SLSM() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='new_coachin_form_gray_icon']")).click();
		Thread.sleep(2000);

	}

	@Then("^check Scoring form of SLSM$")
	public void check_Scoring_form_of_SLSM() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_scoring_form_gray_icon']")).click();

	}

	@Then("^check standard report tab of SLSM with all graph & Sales Call type options and MAT & YTD$")
	public void check_standard_report_tab_of_SLSM_with_all_graph_Sales_Call_type_options_and_MAT_YTD() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='StandardReport_gray_icon']")).click();
		Thread.sleep(2000);

		///----- next
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(3000);

		// --- previous
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnPreStandardReport']")).click();
		Thread.sleep(2000);


		// YTD

		driver.findElement(By.xpath("//button[@class='NewData_Dwdbtn2 mt--2 btnColor1']")).click();
		Thread.sleep(2000);

		//		 ///----- next
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(3000);
		//		
		//		
		//		// --- previous
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);

	}

	@Then("^check standard report tab of SLSM with all graph & Transactional Call type options and MAT & YTD$")
	public void check_standard_report_tab_of_SLSM_with_all_graph_Transactional_Call_type_options_and_MAT_YTD() throws Throwable {
		//		Thread.sleep(3000);
		//		driver.findElement(By.linkText("//a[normalize-space()='FLSM Report']")).click();
		//		Thread.sleep(2000);
		//
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		//		Thread.sleep(3000);
		//	
		//		
		//		// --- previous
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		//		Thread.sleep(2000);

	}

	@Then("^check Graph ploter and generate report of SLSM$")
	public void check_Graph_ploter_and_generate_report_of_SLSM() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_analytics_gray_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
	}

	@Then("^check LRC and downloadable and user guide of SLSM$")
	public void check_LRC_and_downloadable_and_user_guide_of_SLSM() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_lrc_gray_icon']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//a[normalize-space()='Downloadable Content']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='User Guide']")).click();
	}


	@Then("^Check Field Visit Tab\\.$")
	public void check_Field_Visit_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='dashboard_gray_icon']")).click();
		Thread.sleep(2000);
		driver.findElement( By.xpath("//a[@data-bind='click: $root.FieldVisitClick']")).click();
		Thread.sleep(2000);
		WebElement b=driver.findElement(By.xpath("//select[@id='selectCall']"));
		Select c = new Select(b);
		c.selectByIndex(0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
		WebElement bb=driver.findElement(By.xpath("//select[@id='selectCall']"));
		Select cc = new Select(bb);
		cc.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='DATA']")).click();
	}

	@Then("^Check Calls coached Tab\\.$")
	public void check_Calls_coached_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Calls Coached']")).click();
	}

	@Then("^Check Call Rate Tab\\.$")
	public void check_Call_Rate_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Call Rate']")).click();
	}

	@Then("^Check Skill Performance Tab\\.$")
	public void check_Skill_Performance_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Skill Performance']")).click();
	}

	@Then("^Check NS FV Tab\\.$")
	public void check_NS_FV_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='NS Field Visits']")).click();
	}

	@Then("^Check Telephone Tab\\.$")
	public void check_Telephone_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Telephone']")).click();

	}

	@Then("^Check CFC Tab\\.$")
	public void check_CFC_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Current Focus']")).click();
	}

	@Then("^Check WOW Tab\\.$")
	public void check_WOW_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Ways of Working']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout"))).click();

	}

	@Then("^To check menu items-Tabs for FLSM\\. It should work properly\\.$")
	public void to_check_menu_items_Tabs_for_FLSM_It_should_work_properly() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("AnalyticManager@gmail.com");	
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");		
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		WebElement a=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		js.executeScript("arguments[0].scrollIntoView();",a );
		a.click();
		Thread.sleep(4000);
//	
//
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='FormTypeIdModal0']//p[contains(text(),'All Data')]"))).click();
//
//		Thread.sleep(2000);


		driver.findElement(By.xpath("//img[@id='new_coachin_form_gray_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='new_scoring_form_gray_icon']")).click();
		Thread.sleep(2000);
	}
	@Then("^check new coaching form$")
	public void check_new_coaching_form() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_coachin_form_gray_icon']")).click();
		Thread.sleep(2000);

	}

	@Then("^check Scoring form$")
	public void check_Scoring_form() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_scoring_form_gray_icon']")).click();
		Thread.sleep(2000);
	}

	@Then("^check standard report tab with all graph & Sales Call type options and MAT & YTD$")
	public void check_standard_report_tab_with_all_graph_Sales_Call_type_options_and_MAT_YTD() throws Throwable {

		driver.findElement(By.xpath("//img[@id='StandardReport_gray_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='MAT']")).click();
		Thread.sleep(2000);

		///----- next
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);

		// --- previous
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);


		// YTD

		driver.findElement(By.xpath("//button[normalize-space()='YTD']")).click();
		Thread.sleep(2000);

		///----- next
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);

		// --- previous
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
	}

	@Then("^check standard report tab with all graph & Transactional Call type options and MAT & YTD$")
	public void check_standard_report_tab_with_all_graph_Transactional_Call_type_options_and_MAT_YTD() throws Throwable {
		WebElement choose = driver.findElement(By.xpath("//select[@id='callTypeFLSM']"));
		Select select = new Select(choose);
		select.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'pl-0 mt-4')]//span[2]")).click();
		///----- next
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);

		// --- previous
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);


		// YTD

		driver.findElement(By.xpath("//main[@id='main']//span[3]")).click();
		Thread.sleep(2000);

		///----- next
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);

		// --- previous
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Previous']")).click();
		Thread.sleep(2000);
	}

	@Then("^check Graph ploter and generate report$")
	public void check_Graph_ploter_and_generate_report() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_analytics_gray_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
	}

	@Then("^check LRC and downloadable and user guide$")
	public void check_LRC_and_downloadable_and_user_guide() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_lrc_gray_icon']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//a[normalize-space()='Downloadable Content']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='User Guide']")).click();
	}


	@Then("^Check Sales Rep Performance Tab\\.$")
	public void check_Sales_Rep_Performance_Tab() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#']//div[@id='img']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Scoring Coaching Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Self Assessment Form']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@title='Compliance Form']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Account Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Remote Coaching Form']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@title='Remote Self Assessment Form']")).click();



		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@title,'Coaching Form Key Icons')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@class='container']/main[@id='main']/div[@id='myModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button[1]")).click();



	}

	@Then("^Check Manager/Coach Summary Tab\\.$")
	public void check_Manager_Coach_Summary_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Manager / Coach Summary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
	}

	@Then("^Check Sales Team Performance Tab\\.$")
	public void check_Sales_Team_Performance_Tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Sales Team Performance']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Scoring Coaching Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Self Assessment Form']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@title='Compliance Form']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Account Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Remote Coaching Form']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@title='Remote Self Assessment Form']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Archive']")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("logout")).click();

	}

	@Then("^To check menu items-Modules for Rep\\. It should work properly\\.$")
	public void to_check_menu_items_Modules_for_Rep_It_should_work_properly() throws Throwable {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userImage']")).sendKeys("QASales@gmail.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='passwordImage']")).sendKeys("123456789");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginSubmit']")).click();	
		Thread.sleep(3000);
		JavascriptExecutor jsa = (JavascriptExecutor)driver; 
		WebElement aa=driver.findElement(By.xpath("//img[starts-with(@id,'SelectedDiv') and contains(@src,'sia_logo.png')]"));

		jsa.executeScript("arguments[0].scrollIntoView();",aa );
		aa.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='new_scoring_form_gray_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='new_analytics_gray_icon']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//img[@id='new_lrc_gray_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='20']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='dashboard_gray_icon']")).click();
		Thread.sleep(2000);
	}

	@Then("^Check Dashboard Module\\.$")
	public void check_Dashboard_Module() throws Throwable {

	}
	@Then("^check change password$")
	public void check_change_password() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@data-bind='click: $root.ChangePasswordclick']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.OldPassword']")).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.NewPassword']")).sendKeys("123456789");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-bind='value: $root.ConNewPassword']")).sendKeys("123456789");
		//	Thread.sleep(2000);
		//		driver.findElement(By.xpath("//button[@class='btn btn-default'][normalize-space()='Submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@id='dashboard_gray_icon']")).click();
		Thread.sleep(2000);
	}

	@Then("^check all tabs scoring/Non-scoring tabs$")
	public void check_all_tabs_scoring_Non_scoring_tabs() throws Throwable {
		driver.findElement(By.xpath("//a[@href='#javascriptvoid()']//img[@title='Self Assessment Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Account Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Remote Coaching Form']")).click();
		Thread.sleep(2000);
	}

	@Then("^Export Excel sheet and click on form key icon$")
	public void export_Excel_sheet_and_click_on_form_key_icon() throws Throwable {
		driver.findElement(By.xpath("//button[normalize-space()='EXL']")).click();
		Thread.sleep(3000);
	}

	@Then("^Check Self Assessement form & fill the form And Add comment$")
	public void check_Self_Assessement_form_fill_the_form_And_Add_comment() throws Throwable {
		driver.findElement(By.xpath("//img[@id='new_scoring_form_gray_icon']")).click();
		Thread.sleep(2000);
		//		java.util.Date todayDate= new java.util.Date();
		//		Instant instant=todayDate.toInstant();
		//		String date =instant.toString();
		//		driver.findElement(By.xpath("//input[@id='txtdateSelfAssessmentform']")).sendKeys(date);
		//		Thread.sleep(1000);

		driver.findElement(By.xpath("//tr[@id='2577']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2578']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2579']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2580']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2581']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2582']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[@id='2583']//div[@title='Option_Test_4']")).click();
		Thread.sleep(2000);

		WebElement ChooseOption1 = driver.findElement(By.xpath("//tr[@id='2684']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select1 = new Select(ChooseOption1);
		select1.selectByVisibleText("Option_Test_3");
		Thread.sleep(1000);

		WebElement ChooseOption2 = driver.findElement(By.xpath("//tr[@id='2685']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select2 = new Select(ChooseOption2);
		select2.selectByVisibleText("Option_Test_3");
		Thread.sleep(1000);

		WebElement ChooseOption3 = driver.findElement(By.xpath("//tr[@id='2686']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select3 = new Select(ChooseOption3);
		select3.selectByVisibleText("Option_Test_3");
		Thread.sleep(1000);

		WebElement ChooseOption4 = driver.findElement(By.xpath("//tr[@id='2689']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select4 = new Select(ChooseOption4);
		select4.selectByIndex(3);
		Thread.sleep(1000);

		WebElement ChooseOption5 = driver.findElement(By.xpath("//tr[@id='2688']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select5 = new Select(ChooseOption5);
		select5.selectByVisibleText("Option_Test_4");
		Thread.sleep(1000);

		WebElement ChooseOption6 = driver.findElement(By.xpath("//tr[@id='2687']//select[contains(@data-bind,'value: $data.DropDownSelectedVal')]"));
		Select select6 = new Select(ChooseOption6);
		select6.selectByVisibleText("Option_Test_3");

		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2790']/td[4]/div[1]/input[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2791']/td[4]/div[1]/input[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2792']/td[4]/div[1]/input[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2793']/td[4]/div[1]/input[1]")).click();
		//		Thread.sleep(2000);
		//		
		//		driver.findElement(By.xpath("//tbody/tr[@id='2894']/td[4]/label[1]/div[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2895']/td[4]/label[1]/div[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2896']/td[4]/label[1]/div[1]")).click();
		//		Thread.sleep(2000);
		//		driver.findElement(By.xpath("//tbody/tr[@id='2897']/td[4]/label[1]/div[1]")).click();
		//		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@class='pull-right submit marginTop-1']")).click();

		//driver.findElements(By.xpath("//span[@id='notificationBox']"));
	}

	@Then("^Check Graph ploter and click on download excel icon$")
	public void check_Graph_ploter_and_click_on_download_excel_icon() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='new_analytics_gray_icon']")).click();
	}

	@Then("^Check LRC$")
	public void check_LRC() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//img[@id='new_lrc_gray_icon']")).click();

	}

	@Then("^click on homebutton and add feedback$")
	public void click_on_homebutton_and_add_feedback() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Feedback Form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Feed4']//i[@class='far fa-smile feed_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Feed10']//i[@class='far fa-grin-squint feed_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Feed15']//i[@class='far fa-grin-squint feed_icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='mytextarea']")).sendKeys("Nice Development");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
