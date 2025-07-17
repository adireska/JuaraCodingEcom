package com.juaracoding.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    private By errorMessageXpath = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    public void loginPage() {
        this.driver = driver;
    }

    public void openLoginpage() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
    }

    public void inputsUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButton() {
        driver.findElement(loginButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getErrorMessageByXpath() {
        return driver.findElement(errorMessageXpath).getText();
    }

    public void login(String username, String password) {
        inputPassword(username);
        inputPassword(password);
        clickButton();
    }

    
    

}
