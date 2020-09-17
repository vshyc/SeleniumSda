package sda.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPageElement {
    private final String searchInputFieldXpath = "//*[@id=\"app-TopBar\"]/div/header/div[1]/div[3]/div/div/div/div/div[1]/input";
    private final String loopButtonXpath = "//*[@id=\"app-TopBar\"]/div/header/div[1]/div[3]/div/div/div/div/button[3]";


    public String getSearchInputFieldXpath() {
        return searchInputFieldXpath;
    }

    public String getLoopButtonXpath() {
        return loopButtonXpath;
    }

    public void typeIntoSearchInputField(WebDriver driver, String input){
        driver.findElement(By.xpath(searchInputFieldXpath)).sendKeys(input);
    }

    public void clickOnLoopIcon(WebDriver driver){
        driver.findElement(By.xpath(loopButtonXpath)).click();
    }
}

