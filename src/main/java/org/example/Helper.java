package org.example;
import org.example.Models.RealEstate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void driverInit() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        RealEstate.driver = driver;
        RealEstate.wait = wait;
        acceptCookies();
    }

    public static void acceptCookies() {
        driver.get("https://www.aruodas.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

    }
}

