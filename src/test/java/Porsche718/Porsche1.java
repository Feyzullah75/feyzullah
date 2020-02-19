package Porsche718;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Porsche1 {

    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void firstEight() throws InterruptedException {

        //2

        driver.manage().window().maximize();
        driver.get("https://www.porsche.com/usa/modelstart/");

        WebElement selectModel=driver.findElement(By.xpath("//img[@alt='Porsche - 718']"));
        selectModel.click();

        WebElement priceCayman=driver.findElement(By.xpath("//div[.='From $ 57,500.00*']"));

        double caymanFirstPrice = Double.parseDouble(PorscheMethodClass.turnStringToDouble(priceCayman));

        // Click on Build & Price under 718 Cayman

        WebElement buttonForCar=driver.findElement(By.xpath("//div[@id='m982120']"));
        buttonForCar.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iterater = set.iterator();
        while (iterater.hasNext()) {
            String childWindow = iterater.next();
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }


    }
}