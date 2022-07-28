package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.ContactPage;

public class StepPurchaseitem {

    public static WebDriver driver;
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

    @Given("customer access shop page")
    public void customer_access_shop_page() {
        basePage.clickShopPage();
    }

    @When("customer buys the following products")
    public void customer_buys_the_following_products(DataTable dataTable){
//       basePage.waitElementToBeVisible(By.id("forename"));

        int dataEntry = dataTable.cells().size();

        for(int rowEntry = 1; rowEntry < dataEntry; rowEntry++){
            String product = dataTable.cell(rowEntry, 0);
            String quantity = dataTable.cell(rowEntry, 1);
            driver.findElement(By.id(product)).sendKeys(quantity);
        }
    }


//    @After
//    public void after_test(){
//        try{
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }


}
