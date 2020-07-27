package StepDefinitions;

import Pages.classPage;
import Pages.dashboardPage;
import io.cucumber.java.en.*;
import Commons.Common;
import Pages.loginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CreateEventsSteps {

    WebDriver driver=null;
    loginPage login;
    Common setCommon;

    @Given("The Guide is in the Dashboard")
    public void the_guide_is_in_the_dashboard() throws InterruptedException {
        setCommon = new Common(driver);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String environmentLink = setCommon.set_Environment();
        driver.get(environmentLink);
        driver.manage().window().maximize();
        login = new loginPage(driver);
        login.click_Login_button();
        login.enterCredentials("manurex@manu.com", "perrodelmal");
        login.Select_Signin_Button();
        Thread.sleep(3000);
    }

    @And("Guide press Add NEw Event button")
    public void guide_press_add_n_ew_event_button() {
        dashboardPage dashboardElements = new dashboardPage(driver);
        dashboardElements.click_Add_Event();
    }

    @And("Guide select Add Class")
    public void guide_select_add_class() throws InterruptedException {
        dashboardPage dashboardElements = new dashboardPage(driver);
        dashboardElements.open_Class();

    }

    @When("Guide fill all the mandatory fields")
    public void guide_fill_all_the_mandatory_fields() throws InterruptedException {
        classPage classEvent = new classPage(driver);
        classEvent.create_Class();
    }

    @And("Guide press Add button")
    public void guide_press_add_button() {
        classPage classEvent = new classPage(driver);
        classEvent.click_Add_Button();

    }

    @Then("Guide is redirected to His dashboard in order to see the created Event")
    public void guide_is_redirected_to_his_dashboard_in_order_to_see_the_created_event() throws InterruptedException {
        Thread.sleep(2000);
        String sucess = driver.findElement(By.cssSelector("#w0-success-0")).getText();
        Assert.assertEquals(sucess, "×\n" + "Events have been created.");
        //System.out.println(sucess);
    }

    @And("Guide is able to Cancel the Event and the Event is not displayed")
    public void guideIsAbleToCancelTheEventAndTheEventIsNotDisplayed() throws InterruptedException {
        dashboardPage dashboardElements = new dashboardPage(driver);
        dashboardElements.cancel_Event();
        String sucess = driver.findElement(By.cssSelector("#w0-success-0")).getText();
        Assert.assertEquals(sucess, "×\n" + "Event has been canceled.");
    }

}
