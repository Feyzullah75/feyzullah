package Porsche718;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class PorscheMethodClass {

    public static String turnStringToDouble(WebElement element) {
        StringBuilder priceCaymanText = new StringBuilder(element.getText());  //--->  now we converted to String
        for (int i = priceCaymanText.length() - 1; i >= 0; i--) {
            if ((priceCaymanText.charAt(i) >= '0' & priceCaymanText.charAt(i) <= '9') || priceCaymanText.charAt(i) == '.') {
            }
            else {
                priceCaymanText.deleteCharAt(i);
            }
        }
        return priceCaymanText.toString();
    }
}



