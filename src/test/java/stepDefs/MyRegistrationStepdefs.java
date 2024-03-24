package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class MyRegistrationStepdefs {
    private WebDriver driver;

    @Given("Navigate to basketball page")
    public void navigateToBasketballPage() {
        driver = new FirefoxDriver();
        driver.get("https://membership.basketballengland.co.uk/newsupporteraccount");

    }

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String DateOfBirth) {
        driver.findElement(By.id("dp")).sendKeys(DateOfBirth);
    }

    @Given("Enter first name {string}")
    public void enterFirstName(String firstname) {

        driver.findElement(By.id("member_firstname")).sendKeys(firstname);
    }

    @Given("Enter last name {string}")
    public void enterLastName(String lastname) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastname);
    }

    @Given("Enter email {string}")
    public void enterEmail(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
    }

    @Given("Repeat email {string}")
    public void repeatEmail(String email) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
    }

    @Given("Enter password {string}")
    public void enterPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    @Given("Repeat password {string}")
    public void repeatPassword(String password) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);
    }

    @Given("Click terms and condition")
    public void clickTermsAndCondition() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    @Given("Click in over {int}")
    public void clickInOver(int arg0) {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();

    }

    @And("Click in code of ehics")
    public void clickInCodeOfEhics() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @When("Click on registrationbutton")
    public void clickOnRegistrationbutton() throws InterruptedException{
        driver.findElement(By.name("join")).click();
        Thread.sleep(5000);
    }

    @Then("Verify {string} on side")
    public void verifyOnSide(String text) {

        String actual =   driver.getTitle();
        assertThat(actual, is(text));

       driver.close();
    }

    @Then("Verify fail message {string} on side")
    public void verifyFailMessageOnSide(String text) {

        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span")).getText();
         assertThat(actual, is(text));
        driver.close();
    }



    @Then("Verify fail password message {string} on side")
    public void verifyFailPasswordMessageOnSide(String text) {
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[8]/div/div[2]/div[2]/div/span/span")).getText();
        assertThat(actual, is(text));
        driver.close();
    }


    @Then("Verify fail TaC message {string} on side")
    public void verifyFailTaCMessageOnSide(String text) {
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span")).getText();
        assertThat(actual, is(text));
        driver.close();
    }
}
