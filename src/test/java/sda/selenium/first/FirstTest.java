package sda.selenium.first;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sda.selenium.pageobjects.NavigationPageElement;

public class FirstTest {
    public static NavigationPageElement navigationPageElement;
    private final String deviceName = "Samsung Galaxy S20+ G985F Dual SIM Cosmic Black";
    String title = "Kursy programowania w Software Development Academy";
    String googleTitle = "Google";
    WebDriver driver;
    WebDriverWait wait;
    String pesel;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }
    @Test
    public void firstTest() {
        driver.get("https://sdacademy.pl/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals(title));
    }
    @Test
    public void checkGoogleTitle() {
        driver.get("https://google.pl/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals(googleTitle));
    }
    @Test
    public void testXkomCart() {
        driver.get("https://www.x-kom.pl");
        navigationPageElement.typeIntoSearchInputField(driver,deviceName);
        navigationPageElement.clickOnLoopIcon(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"listing-container\"]/div/div")));
        driver.findElement(By.xpath("//*[@id=\"listing-container\"]/div/div")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Przejdź do koszyka")));
        driver.findElement(By.linkText("Przejdź do koszyka")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div[1]/div[2]")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/ul/li/div/div/div/div[1]/a/h3")).getText());
        Assert.assertEquals("Samsung Galaxy S20+ G985F Dual SIM Cosmic Black",driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div[2]/ul/li/div/div/div/div[1]/a/h3")).getText());

    }
    @After
    public void end(){
        driver.close();
    }
}
