package com.juaracoding.ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.LoginPage;
import com.juaracoding.ecom.providers.DataTestProvider;

public class AuthenticationTest {

  private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password) {
        loginPage.login(username, password);

        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        String actualUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login gagal: URL tidak sesuai");
    }


  @Test(enabled = true)
    public void loginWithInvalidUsername() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        Thread.sleep(500);

        loginPage.login("standard_userss", "secret_sauce");
        Thread.sleep(500);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expected);

        driver.quit();
    }

  @Test()
  public void loginWithInvalidPassword() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        Thread.sleep(500);

        loginPage.login("standard_user", "secret_sauce123");
        Thread.sleep(500);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expected);
  }

  @Test()
  public void loginWithoutPassword() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        Thread.sleep(500);

        loginPage.login("standard_user", "");
        Thread.sleep(500);

        String expected = "Epic sadface: Password is required";
        Assert.assertEquals(loginPage.getErrorMessageByXpath(), expected);
  }

  @Test()
  public void loginWithoutUsername() throws InterruptedException {
     WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        Thread.sleep(500);

        loginPage.login("", "secret_sauce");
        Thread.sleep(500);

        String expected = "Epic sadface: Username is required";
        Assert.assertEquals(loginPage.getErrorMessageByXpath(), expected);
  }
}
