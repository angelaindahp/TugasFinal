package stepdefinitions;

import config.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;

public class WebStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @Before("@web")
    public void setup() {
        driver = WebDriverConfig.getDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @After("@web")
    public void teardown() {
        WebDriverConfig.closeDriver();
    }

    @Given("Saya berada di halaman login")
    public void openLoginPage() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("Saya memasukkan username {string}")
    public void enterUsername(String username) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
    }

    @When("Saya memasukkan password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("Saya mengklik tombol login")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("Saya berhasil login dan melihat tombol logout")
    public void verifyLoginSuccess() {
        Assert.assertTrue(loginPage.isLogoutDisplayed());
    }

    @Given("Saya menambahkan produk ke dalam keranjang")
    public void addToCart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.addToCart();
    }

    @When("Saya membuka halaman keranjang")
    public void openCartPage() {
        checkoutPage.openCart();
    }

    @Then("Saya melihat halaman pembayaran")
    public void verifyCheckoutPage() {
        Assert.assertTrue(checkoutPage.isCheckoutButtonDisplayed());
    }
}
