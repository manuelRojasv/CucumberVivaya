package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage {
    WebDriver driver;
    By add_New_Event = By.cssSelector(".show-modal-btn");
    By add_Workshop = By.cssSelector("div.add-event-buttons > a.btn.btn-primary");
    By add_Session = By.xpath("//a[contains(text(),'Add Session')]");
    By add_Class = By.xpath("//a[contains(text(),'Add Class')]");
    By cancel_Event = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/p[5]/a[2]");
    By yes_Delete_Event = By.cssSelector("button.btn.btn-success");

    public dashboardPage(WebDriver driver){
        this.driver= driver;
    }


    public void click_Add_Event(){
        driver.findElement(add_New_Event).click();
    }
    public void open_Class() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(add_Class).click();
    }

    public void cancel_Event() throws InterruptedException {
        /*WebDriverWait wait1 = new WebDriverWait(driver, 5);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Cancel Event")));
        element1.click();
        Thread.sleep(2000);*/
        Thread.sleep(2000);
        driver.findElement(By.linkText("Cancel Event")).click();
        Thread.sleep(2000);
        driver.findElement(yes_Delete_Event).click();
    }
}
