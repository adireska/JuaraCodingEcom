package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.providers.DataTestProvider;

public class AuthenticationTest {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password) throws InterruptedException{
        // Case Positive Login 
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys(username);

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);

        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        Thread.sleep(1000);

        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login gagal karena tidak masuk ke halaman inventory");

        Thread.sleep(1000);

        driver.quit();
    }

    @Test(enabled = false)
    public void loginWithInvalidUsername() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_userpdsf");

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = errorValidation.getText();
        Assert.assertEquals(actual, expected);

        Thread.sleep(1000);

        driver.quit();
    }

    @Test(enabled = false)
    public void loginWithInvalidPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce123");

        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = errorValidation.getText();
        Assert.assertEquals(actual, expected);

        Thread.sleep(1000);

        driver.quit();
    }

    @Test(enabled = false)
    public void loginWithoutdUsername() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("");

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement errorValidation = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));

        String expected = "Epic sadface: Username is required";
        String actual = errorValidation.getText();
        Assert.assertEquals(actual, expected);

        Thread.sleep(1000);

        driver.quit();
    }

    @Test(enabled = false)
    public void loginWithoutPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("");

        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement errorValidation = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));

        String expected = "Epic sadface: Password is required";
        String actual = errorValidation.getText();
        Assert.assertEquals(actual, expected);

        Thread.sleep(1000);

        driver.quit();
    }


}
