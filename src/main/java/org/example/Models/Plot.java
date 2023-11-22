package org.example.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Plot extends RealEstate {


    public String addressNo;
    public String rcNo;
    public String area;
    public String purposes;

    // public static WebDriver driver;
    // public static WebDriverWait wait;


    public Plot(String region, String settlement, String microdistrict, String street, String description, String photo, String youtubeLink, String tour3D, String price, String phone, String email, String addressNo, String rcNo, String area, String purposes) {
        super(region, settlement, microdistrict, street, description, photo, youtubeLink, tour3D, price, phone, email);
        this.addressNo = addressNo;
        this.rcNo = rcNo;
        this.area = area;
        this.purposes = purposes.toLowerCase().trim().replace(", ", ",");
    }

    @Override
    public void fillReg() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        super.fillReg();
        setAddressNo();
        setRcNo();
        setArea();
        setPurposes();
        //driver.findElement(By.xpath("//*[@id=\"submitFormButton\"]")).click();
    }

    public void setPurposes() {
        String[] purposes = this.purposes.split(",");
        for (int i = 0; i < purposes.length; i++) {

            switch (purposes[i]) {
                case "namų valda":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "daugiabučių statyba":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "žemės ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "sklypas soduose":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "miškų ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label")).click();
                    break;
                case "pramonės":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[6]/label")).click();
                    break;
                case "sandėliavimo":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[7]/label")).click();
                    break;
                case "komercinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[8]/label")).click();
                    break;
                case "rekreacinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[9]/label")).click();
                    break;
                case "kita":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[10]/label/span")).click();
                    break;
            }
        }
    }

    public void setAddressNo() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.addressNo);
    }

    public void setRcNo() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNo);
    }

    public void setArea() {
        driver.findElement(By.name("FAreaOverAll")).sendKeys(this.area);
    }
}



