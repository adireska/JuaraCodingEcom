// package com.juaracoding.ecom;

// import java.sql.DriverManager;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
// import org.testng.annotations.Test;

// import com.juaracoding.ecom.pages.JQueryDragDropPage;
// import com.juaracoding.ecom.utils.DriverUtil;

// public class DragDropTest {

//   @Test()
//   public void dragElementTest() throws InterruptedException {
//     DriverManager getDriverss = new getDriverss();
//     WebDriver driver = getDriverss.getDriverss();
//     driver.get("https://jquery-drag-drop-demo.webflow.io/");

//     Actions builder = new Actions(driver);
//     WebElement draggable = driver.findElement(JQueryDragDropPage.draggable);
//     WebElement droppable = driver.findElement(JQueryDragDropPage.droppable);

//     builder.dragAndDrop(draggable, droppable).perform();

//     Thread.sleep(1000);

//     driver.quitDriver();
//   }
// }
