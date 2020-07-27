package Commons;

import org.openqa.selenium.WebDriver;

public class Common {
     WebDriver driver;
    public Common(WebDriver driver){
        this.driver = driver;
    }

    public String set_Environment(){
        return new String ("https://stage.vivayalive.com");
    }

    public void close_Browser(){
        driver.close();
        driver.quit();
    }

}
