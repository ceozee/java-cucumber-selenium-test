package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;


    By contactButton = By.id("nav-contact");
    By cartButton = By.id("nav-cart");
    By shopButton = By.id("nav-shop");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactPage() {
        driver.findElement(contactButton).click();
    }

    public void clickCartPage() {
        driver.findElement(cartButton).click();
    }

    public void clickShopPage() {
        driver.findElement(shopButton).click();
    }

    public void visitHomePage(){
        driver.get("https://jupiter.cloud.planittesting.com/");
    }

    public void waitElementToBeVisible(By element){
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitElementToDisappear(By element){
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitElement.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
