package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;

public class TodoTests {

	WebDriver driver;

	// PropertyFileReader object = new PropertyFileReader();
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Ketaki_264\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Given("^Open Firefox and start application$")
	public void Open_Firefox_and_start_application() throws Throwable {

		driver.manage().window().maximize();
		// driver.get("https://todomvc.com/examples/angular2/");

	}

	@When("^User click on valid link$")
	public void User_click_on_valid_link() throws Throwable {
		// Properties property= object.getProperty();
		// driver.get(property.getProperty("browser.baseURL"));
		driver.get("https://todomvc.com/examples/angular2/");

	}

	@SuppressWarnings("deprecation")
	@Then("^I should be able to get into and see Todos as a header$")
	public void I_should_be_able_to_get_into_and_see_Todos_as_a_header() throws Throwable {
		String title = driver.getCurrentUrl();
		System.out.println("My Url is" + title);
		assertEquals(title, "https://todomvc.com/examples/angular2/");

	}

	@Given("^User on home page$")
	public void User_on_home_page() throws Throwable {
		User_click_on_valid_link();
		Thread.sleep(1000);
	}

	@When("^Enter valid Value on empty text box and Hit Enter button$")
	public void Enter_valid_value_on_empty_text_box_and_Hit_Enter_button() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("Hello");
		Thread.sleep(1000);
	}

	@Then("^Value should get added in the TODO box$")
	public void Value_should_get_added_in_the_TODO_box() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Given("^User on home page and there is a value in todo table$")
	public void User_on_home_page_and_there_is_a_value_in_todo_table() throws Throwable {
		User_click_on_valid_link();
		Thread.sleep(1000);
		Enter_valid_value_on_empty_text_box_and_Hit_Enter_button();
		Thread.sleep(2000);
		Value_should_get_added_in_the_TODO_box();
		System.out.println("Hello, i am inside this");
	}

	@When("^User clicks on radio button$")
	public void User_clicks_on_radio_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/todo-app/section/section/ul/li[1]/div/input")).click();

	}

	@Then("^that particular selected value should get strikeout and we see clear complete$")
	public void that_particular_selected_value_should_get_strikeout() throws Throwable {
		Thread.sleep(1000);
		String value = driver.findElement(By.xpath("//input[@type='checkbox' and @class='toggle']")).getText();
		System.out.println("This is my value---->>>" + value);
		Thread.sleep(1000);
		String Ele = driver.findElement(By.xpath("//button[@class='clear-completed']")).getText();
		System.out.println("hello hello====>>>" + Ele);
		assertEquals(Ele, "Clear completed");
		Thread.sleep(1000);
	}

	
	
	 @When("^User enter more than one values and hit enter$") public void
	 User_enter_more_than_one_values_and_hit_enter(DataTable values) throws
	 Throwable { List<List<String>> data= values.raw();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(data.get(0).toString());
	 driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
	 driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(data.get(1).toString());
	 driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
	 }
	 
	 @Then("^More than one value should get added into table$") 
	 public void More_than_one_value_should_get_added_into_table() throws Throwable {
	 System.out.println("<<<<You have added more than one value succesfully>>>>"); }
	 
//Negative tests from here: 
	 
	 @Given("^User on home page and there is not any value in the textbox$")
	 public void User_on_home_page_and_there_is_not_any_value_in_the_textbox() throws Throwable {
		 User_click_on_valid_link();
		 Thread.sleep(1000);
		 
	 }
	  
	@When("^User enters empty string and try to Hit Enter button$")
	public void User_enters_empty_string_and_try_to_Hit_Enter_button() throws Throwable {
	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).clear();	
	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("");
	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
	String inputBox=driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).getText();
	System.out.println("<<<This is the value>>>" + inputBox);

	// Check whether input field is blank
	Thread.sleep(1000);
	if(inputBox.isEmpty())
	{
	   System.out.println("Input field is empty");
	   assertNotNull("The object you enter return null",inputBox);
	}
	}
	
	@When("^User enters only special chars and Hit Enter button$")
	public void User_enters_only_special_chars_and_Hit_Enter_button() throws Throwable {
		
	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("�$$%$%&()<>");
	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	
	
	}

	@Then("^error message should be shown of entering valid value$")
	public void error_message_should_be_shown_of_entering_valid_value() throws Throwable {
		String special = driver.findElement(By.xpath("/html/body/todo-app/section/section/ul/li/div/label")).getText();
		System.out.println("Seeeee hee" + special);
		
		 if (special.contains("�$$%$%&()<>"))
		 {
		    System.out.println( " ERROR MESSAGE ===>>> Do not only enter special characters");
		 }
		else{
			System.out.println("<<<<<I did not went to IF>>>>>");}
			
		
	}
	
	
	 
	 @After() public void quidBrowser() throws InterruptedException { 
		 Thread.sleep(1000);
		 driver.quit(); }
	 

}
