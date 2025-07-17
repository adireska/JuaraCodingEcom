package com.juaracoding.ecom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.pages.CartPage;
import com.juaracoding.ecom.utils.DriverUtil;

public class InventoryTest extends BaseTest {

    private CartPage cartPage;

    @Test()
    public void testAddItems() {
        cartPage = new CartPage(DriverUtil.getDriver());

        int total = cartPage.getTotalProductDisplayed();
        Assert.assertEquals(total, 6, "Jumlah produk tidak sesuai!");

        cartPage.addItemToCart();

        String itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(itemCount, "1", "Jumlah item di cart tidak sesuai!");

        cartPage.openCart();
    }


    @Test()
    public void testAdd3Items() {
        cartPage = new CartPage(DriverUtil.getDriver());

        int total = cartPage.getTotalProductDisplayed();
        Assert.assertEquals(total, 6, "Jumlah produk tidak sesuai!");

        cartPage.addMultipleItemsToCart(3);

        String itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(itemCount, "3", "Jumlah item di cart tidak sesuai!");

        cartPage.openCart();
    }


    @Test()
    public void productSortFeatureTest() throws InterruptedException {
        Select select = new Select(DriverUtil.getDriver().findElement(CartPage.productSortContainer));

         select.selectByValue("az");

         Thread.sleep(2000);

        List<WebElement> productNames = DriverUtil.getDriver().findElements(By.className("inventory_item_name"));

        List<String> uiProductNames = new ArrayList<>();
        for (WebElement product : productNames) {
        uiProductNames.add(product.getText().trim());
        }

        List<String> expectedSortedNames = new ArrayList<>(uiProductNames);
        Collections.sort(expectedSortedNames);

        Assert.assertEquals(uiProductNames, expectedSortedNames, "Produk TIDAK urut A-Z!");
         
    }

}
