import org.example.Helper;
import org.example.Models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlotTests {
public static WebDriver driver;

@Test
public void PositiveTest(){
    Plot plot = new Plot("","","","","Parduodu nama","Milka (155 of 160).jpg","https://www.youtube.com/watch?v=mjofV8-UaxU","www.maps.lt", "150000","68909256","saulyte123@gmail.com","55","5555-5555-5555","40","Namų valda, Daugiabučių statyba, Žemės ūkio, Sklypas soduose, Miškų ūkio, Pramonės, Sandėliavimo, Komercinė, Rekreacinė, Kita");
    plot.fillReg();
    Assert.assertEquals("","");
    //Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[8]/td[2]/span")).getText(),"Pakartotinai neįvedėte slaptažodžio.");
}

@BeforeClass
public void beforeClass() {
    Helper.driverInit();
    driver = Helper.driver;

}
public void acceptCookies(){
     driver.get("https://www.aruodas.lt/");
     driver.findElement(By.id("onetrust-accept-btn-handler")).click();
}
@AfterClass
public void afterClass(){
//      driver.quit();
}

}
