package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ContactPage {

    WebDriver driver;

    By submitButton = By.linkText("Submit");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }
}
