package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    WebDriver driver;

    By itemPrice = By.className("product-price");
    By itemButton = By.className("btn");

    By shopContainer = By.className("container-fluid");


    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductCard(String item){
        return driver.findElement(By.xpath("//*[contains(text(), '"+ item + "')]/following-sibling::p"));
    }

    public String getProductPriceByName(String item){
        WebElement productCard = getProductCard(item);
        return productCard.findElement(itemPrice).getText();
    }

    public void buyProductsByNameAndQuantity(String item, int quantity){
        WebElement productCard = getProductCard(item);
        WebElement button = productCard.findElement(itemButton);
        int purchase = 0;
        while (purchase < quantity){
            button.click();
            purchase++;
        }

    }

    public void waitShopContainerToBeVisible(){
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(shopContainer));
    }

}