package StepDefinitions;

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
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver=null;
    loginPage login;
    Common setCommon;
    @Given("User is in Home page")
    public void user_is_in_home_page() {
        setCommon = new Common(driver);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String linkito = setCommon.set_Environment();
        driver.get(linkito);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }


    @And("Press Login link")
    public void press_login_link() {
        //driver.findElement(By.xpath("//ul[@class='menu user-menu']//a[.='Login']")).click();
        login = new loginPage(driver);
        login.click_Login_button();
    }
    @When("Guide enters his valid credentials username and password")
    public void guide_enters_his_valid_credentials_username_and_password() {
        //driver.findElement(By.id("loginform-email")).sendKeys("manurex@manu.com");
        //driver.findElement(By.id("loginform-password")).sendKeys("perrodelmal");
        login = new loginPage(driver);
        login.enterCredentials("manurex@manu.com", "perrodelmal");
    }

    @And("Press Login button")
    public void press_login_button() {
        //driver.findElement(By.name("login-button")).click();
        login = new loginPage(driver);
        login.Select_Signin_Button();
    }

    @Then("Guide is redirected to his Dashboard")
    public void guide_is_redirected_to_his_dashboard() {
        String sucess = driver.findElement(By.cssSelector(".uname")).getText();
        Assert.assertEquals(sucess, "Hi, manu rex");
    }
    @And("Press Logout link")
    public void pressLogoutLink() {
        //driver.findElement(By.cssSelector(".uname")).click();
        //driver.findElement( By.xpath("//button[@class='btn logout']")).click();
        login = new loginPage(driver);
        setCommon = new Common(driver);
        login.perform_Logout();
        setCommon.close_Browser();
    }
    @Then("User is redirected to Home page")
    public void userIsRedirectedToHomePage() {
    }

    @When("Seeker enters his valid credentials username and password")
    public void seekerEntersHisValidCredentialsUsernameAndPassword() {
        //driver.findElement(By.id("loginform-email")).sendKeys("horcosio@gmail.com");
       // driver.findElement(By.id("loginform-password")).sendKeys("perrodelmal");
        loginPage login = new loginPage(driver);
        login.enterCredentials("horcosio@gmail.com", "perrodelmal");
    }

    @Then("Seeker is redirected to his Dashboard")
    public void seekerIsRedirectedToHisDashboard() {
        //driver.getPageSource().contains("Hi, manu rex");
    }
}
