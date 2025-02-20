package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By addToCartButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    By cartButton = By.id("cartur");
    By checkoutButton = By.xpath("//button[contains(text(), 'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isCheckoutButtonDisplayed() {
        return driver.findElement(checkoutButton).isDisplayed();
    }
}
