package org.example.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class RealEstate {
    public String region;
    public String settlement;
    public String microdistrict;
    public String street;
    public String description;
    public String photo;
    public String youtubeLink;
    public String tour3D;
    public String price;
    public String phone;
    public String email;

    public static WebDriver driver;
    public static WebDriverWait wait;


    public RealEstate(String region, String settlement, String microdistrict, String street, String description, String photo, String youtubeLink, String tour3D, String price, String phone, String email) {
        this.region = region;
        this.settlement = settlement;
        this.microdistrict = microdistrict;
        this.street = street;
        this.description = description;
        this.photo = photo;
        this.youtubeLink = youtubeLink;
        this.tour3D = tour3D;
        this.price = price;
        this.phone = phone;
        this.email = email;
    }

    public void fillReg() {
        // driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        setLocation();
        setDescription();
        uploadPhoto();
        setYoutubeLink();
        setTour3D();
        setPrice();
        setPhone();
        setEmail();
        clickCheckboxes();
    }

    public void clickCheckboxes() {
        // driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        List<WebElement> rows = driver.findElement(By.id("newObjectForm")).findElements(By.tagName("li"));
        rows.get(rows.size() - 3).findElements(By.tagName("span")).get(1).click();
        rows.get(rows.size() - 4).findElement(By.tagName("span")).click();
        rows.get(rows.size() - 5).findElement(By.tagName("span")).click();
    }

    public void setLocation() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"district\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"districts_461\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[2]")).click();
    }

    public void setDescription() {
        driver.findElement(By.name("notes_lt")).sendKeys(this.description);
    }

    public void uploadPhoto() {
        File resourceFile = new File("photo/" + this.photo);
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(resourceFile.getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fancybox")));
    }

    public void setYoutubeLink() {
        driver.findElement(By.name("Video")).sendKeys(this.youtubeLink);
    }

    public void setTour3D() {
        driver.findElement(By.name("tour_3d")).sendKeys(this.tour3D);
    }

    public void setPrice() {
        driver.findElement(By.name("price")).sendKeys(this.price);
    }

    public void setPhone() {
        driver.findElement(By.name("phone")).sendKeys(this.phone);
    }

    public void setEmail() {
        driver.findElement(By.name("email")).sendKeys(this.email);
    }
}
