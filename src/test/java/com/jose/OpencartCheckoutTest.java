package com.jose;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpencartCheckoutTest {


    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.get("C:/Users/Scont/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
    }

   // @Test
    //public void test_i_open_the_opencart_home_page() {
        // Abrir la página de inicio de Opencart
     //   driver.get("http://opencart.abstracta.us/");

        // Verificar que la página de inicio se haya abierto
       // String pageTitle = driver.getTitle();
    //    assertEquals("Your Store", pageTitle);
    //}

    @Test
    public void test_i_add_an_item_to_the_cart() {

        // Abrir la página de inicio de Opencart
        driver.get("http://opencart.abstracta.us/");

        // Buscar un producto
        WebElement searchInput = driver.findElement(By.cssSelector("#search input"));
        searchInput.sendKeys("iPhone");
        searchInput.submit();

        // Seleccionar un producto
        WebElement productTitle = driver.findElement(By.cssSelector(".product-thumb.product-title a"));
        productTitle.click();

        // Añadir el producto al carrito
        WebElement addCartButton = driver.findElement(By.cssSelector(".button-cart"));
        addCartButton.click();

        // Verificar que el producto se haya añadido al carrito
        String cartItemCount = driver.findElement(By.cssSelector(".cart-total-items .value")).getText();
        assertEquals("1", cartItemCount);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}