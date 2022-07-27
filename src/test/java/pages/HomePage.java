package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By startShoppingButton = By.partialLinkText("Start Shopping");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartShopping() {
        driver.findElement(startShoppingButton).click();
    }
}
