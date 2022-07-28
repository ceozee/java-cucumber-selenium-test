package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;

    By itemName = By.cssSelector("td:nth-child(1)");
    By itemPrice = By.cssSelector("td:nth-child(2)");
    By itemQuantity = By.cssSelector("td:nth-child(3)>input");
    By subtotal = By.cssSelector("td:nth-child(4)");
    By total = By.className("total");
    By checkoutButton = By.linkText("Check Out");
    By emptyCartButton = By.linkText("Empty Cart");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public JSONArray getAllPurchases(){
        List<WebElement> rows = driver.findElements(By.className("cart-item"));
        int purchaseId = 0;

        JSONArray purchasesList = new JSONArray();

        for (WebElement row: rows){

            JSONObject purchaseObject = new JSONObject();

            String purchaseItemName = row.findElement(itemName).getText();
            String purchaseItemPrice = row.findElement(itemPrice).getText();
            String purchaseItemQuantity = row.findElement(itemQuantity).getAttribute("value");
            String purchaseItemSubtotal = row.findElement(subtotal).getText();

            purchaseObject.put("name", purchaseItemName);
            purchaseObject.put("price", purchaseItemPrice);
            purchaseObject.put("quantity", purchaseItemQuantity);
            purchaseObject.put("subtotal", purchaseItemSubtotal);

            purchasesList.add(purchaseObject);

            purchaseId ++;

        }
        return purchasesList;
    }

    public String getTotal(){
        return driver.findElement(total).getText();
    }

    public void waitTotalToBeVisible(){
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(total));
    }
}