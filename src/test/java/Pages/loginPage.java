package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;
    By login_link = By.xpath("//ul[@class='menu user-menu']//a[.='Login']");
    By user_name = By.id("loginform-email");
    By password_Field = By.id("loginform-password");
    By click_Signin_button = By.name("login-button");
    By select_User_Options = By.cssSelector(".uname");
    By select_Logout = By.xpath("//button[@class='btn logout']");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_Login_button (){
        driver.findElement(login_link).click();

    }
    public void enterCredentials(String username, String password){
        driver.findElement(user_name).sendKeys(username);
        driver.findElement(password_Field).sendKeys(password);
    }

    public void Select_Signin_Button(){
        driver.findElement(click_Signin_button).click();
    }

    public void perform_Logout(){
        driver.findElement(select_User_Options).click();
        driver.findElement(select_Logout).click();
    }


}
