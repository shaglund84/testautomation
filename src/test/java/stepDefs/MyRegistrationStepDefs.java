package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyRegistrationStepDefs {
    private WebDriver driver;

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String birth) {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1918, 1030));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.findElement(By.id("dp")).sendKeys("01/01/1990");
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String first) {
        driver.findElement(By.id("member_firstname")).sendKeys(first);
    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String last) {
        driver.findElement(By.id("member_lastname")).sendKeys(last);
    }

    @And("I have entered and confirmed email {string}")
    public void iHaveEnteredEmail(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);

    }

    @And("I have entered password {string}")
    public void iHaveEnteredPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    @And("I have confirmed password {string}")
    public void iHaveConfirmedPassword(String confPass) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confPass);

    }

    @And("I have checked terms and conditions")
    public void iHaveCheckedTermsAndConditions() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    @And("I have checked Over 18 and code of conduct")
    public void iHaveCheckedOver18AndCodeOfConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @When("I press the join button")
    public void iPressTheJoinButton() {
        driver.findElement(By.name("join")).click();
        driver.findElement(By.cssSelector(".bold:nth-child(1)")).click();
    }

    @Then("I am registered")
    public void iAmRegistered() {
        assertThat(driver.findElement(By.cssSelector(".bold:nth-child(1)")).getText(), is("THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND"));
    }

    @Then("I get a message of error that last name is missing")
    public void iGetAMessageOfErrorThatLastNameIsMissing() {
        assertThat(driver.findElement(By.cssSelector(".warning > span")).getText(), is("Last Name is required"));

    }

    @Then("I get a message of error that password confirmation do not match")
    public void iGetAMessageOfErrorThatPasswordConfirmationDoNotMatch() {
        assertThat(driver.findElement(By.cssSelector(".warning > span")).getText(), is("Password did not match"));
    }

    @Then("I get a message of error that Terms and conditions are not checked")
    public void iGetAMessageOfErrorThatTermsAndConditionsAreNotChecked() {
        assertThat(driver.findElement(By.cssSelector(".warning > span")).getText(), is("You must confirm that you have read and accepted our Terms and Conditions"));

    }
}
