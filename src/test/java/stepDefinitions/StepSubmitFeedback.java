package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

import pages.BasePage;
import pages.ContactPage;

public class StepSubmitFeedback {

    public static WebDriver driver;
    public static DataTable errorFieldAndMessage;
    public static BasePage basePage = new BasePage(null);
    public static ContactPage contactPage = new ContactPage(null);

    @Before
    public void before_tests(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
        driver = new FirefoxDriver();
        basePage = new BasePage(driver);
        contactPage = new ContactPage(driver);

        basePage.visitHomePage();
    }

    @Given("customer access contact page")
    public void customer_access_contact_page() {
        basePage.clickContactPage();
    }

    @When("following fields are entered")
    public void following_fields_are_entered(DataTable dataTable){
       basePage.waitElementToBeVisible(By.id("forename"));

       int dataEntry = dataTable.cells().size();

       for(int rowEntry = 1; rowEntry < dataEntry; rowEntry++){
           String field = dataTable.cell(rowEntry, 0);
           String value = dataTable.cell(rowEntry, 1);
           driver.findElement(By.id(field)).sendKeys(value);
       }
    }

    @Then("error in the field is displayed")
    public void error_in_the_field_is_displayed(DataTable dataTable){
        errorFieldAndMessage = dataTable;
        int dataEntry = dataTable.cells().size();

        for(int rowEntry = 1; rowEntry < dataEntry; rowEntry++){
            String field = dataTable.cell(rowEntry, 0);
            String value = dataTable.cell(rowEntry, 1);
            String emailFieldError = driver.findElement(By.id(field)).getText();
            Assert.assertNotNull(emailFieldError, value);
        }

    }
    @When("submit button is clicked")
    public void submit_button_is_clicked() {
        basePage.waitElementToBeVisible(By.linkText("Submit"));
        contactPage.clickSubmitButton();
    }

    @Then("errors will disappear in contact page")
    public void errors_will_disappear_in_contact_page(){
        DataTable dataTable = errorFieldAndMessage;
        int dataEntry = dataTable.cells().size();
        for(int rowEntry = 1; rowEntry < dataEntry; rowEntry++) {
            String field = dataTable.cell(rowEntry, 0);

//            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(field)));
            basePage.waitElementToDisappear(By.id(field));

            List<WebElement> fieldVisibility = driver.findElements(By.id(field));
            Assert.assertEquals(Collections.emptyList(), fieldVisibility);
        }

    }

    @When("customer submits feedback form with the following values")
    public void customer_submits_feedback_form_with_the_following_values(DataTable dataTable){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        basePage.waitElementToBeVisible(By.id("forename"));


        int dataEntry = dataTable.cells().size();

        for(int rowEntry = 1; rowEntry < dataEntry; rowEntry++) {
            String field = dataTable.cell(rowEntry, 0);
            String value = dataTable.cell(rowEntry, 1);
            driver.findElement(By.id(field)).sendKeys(value);
            driver.findElement(By.linkText("Submit")).click();
        }

//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("in")));
        basePage.waitElementToDisappear(By.className("in"));

    }

    @Then("it should display that feedback submission is successful for \"([^\"]*)\"$")
    public void it_should_display_that_feedback_submission_is_successful(String forename){
        String successResponse = driver.findElement(By.className("alert-success")).getText();
        String expectedSuccessResponse = "Thanks " + forename + ", we appreciate your feedback.";
        Assert.assertEquals(expectedSuccessResponse, successResponse);
    }

    @After
    public void after_test(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
