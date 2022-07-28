package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactPage {
    WebDriver driver;
    By forenameField = By.id("forename");
    By surnameField = By.id("surname");
    By emailField = By.id("email");
    By telephoneField = By.id("telephone");
    By messageField = By.id("message");
    By forenameError = By.id("forename-err");
    By emailError = By.id("email-err");
    By messageError = By.id("message-err");
    By headerMessage = By.id("header-message");
    By submitButton = By.linkText("Submit");
    By backButton = By.partialLinkText("Back");
    By submitSuccessHeader = By.className("alert-success");
    By sendingFeedbackModal = By.className("in");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }


//    public void enterForename(String forename){
//        driver.findElement(forenameField).sendKeys(forename);
//    }
//
//    public void enterSurname(String forename){
//        driver.findElement(surnameField).sendKeys(forename);
//    }
//
//    public void enterEmail(String email){
//        driver.findElement(emailField).sendKeys(email);
//    }
//
//    public void enterTelephone(String telephone){
//        driver.findElement(telephoneField).sendKeys(telephone);
//    }
//
//    public void enterMessage(String message){
//        driver.findElement(messageField).sendKeys(message);
//    }

    public void clickSubmitButton(){
        driver.findElement(By.linkText("Submit")).click();
    }

//    public String getErrorMessage(String id){
//        return driver.findElement(By.id(id)).getText();
//    }
//
//    public String getHeaderMessage(){
//        return driver.findElement(headerMessage).getText();
//    }
//
//    public String getHeaderSuccessfulMessage(){
//        return driver.findElement(submitSuccessHeader).getText();
//    }
//
//    public List<WebElement> checkFieldErrorExists(String id){
//        return driver.findElements(By.id(id));
//    }
//
//    public void waitSendingFeedbackToDisappear(int duration){
//        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(duration));
//        waitElement.until(ExpectedConditions.invisibilityOfElementLocated(sendingFeedbackModal));
//    }

}