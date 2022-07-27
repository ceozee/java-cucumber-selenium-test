package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import java.util.Collection;
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
        System.out.print("Test");
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
