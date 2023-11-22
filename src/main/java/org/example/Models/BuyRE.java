package org.example.Models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyRE extends RealEstate {


    public String objectType;

   // public static WebDriver driver;
   // public static WebDriverWait wait;

    public BuyRE(String region, String settlement, String microdistrict, String street, String description, String photo, String youtubeLink, String tour3D, String price, String phone, String email, String objectType) {
        super(region, settlement, microdistrict, street, description, photo, youtubeLink, tour3D, price, phone, email);
        this.objectType = objectType.toLowerCase();
    }
    @Override
    public void fillReg(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10&offer_type=1");
        super.fillReg();
        setObjectType();
        //driver.findElement(By.xpath("//*[@id=\"submitFormButton\"]")).click();
    }

  public void setObjectType(){
       driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
    List<WebElement> objectTypes = driver.findElement(By.className("dropdown-input-values")).findElements(By.tagName("li"));
      for (WebElement objectType: objectTypes){
          if (objectType.getText().toLowerCase().equals(this.objectType)){
              objectType.click();
              break;
      }
      }
   }
    }



