package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HealthUnify {
    WebDriver driver;

    //Тест на недостаточный индекс массы тела по международной системе мер
    @Test
    public void InsufficientBodyMassIndexAaccordingISTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("45");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("170");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Underweight");
    }

    //Тест на нормальный индекс массы тела по международной системе мер
    @Test
    public void NormalBodyMassIndexAccordingISTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("55");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("170");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Normal");
   }

    //Тест на избыточный индекс массы тела по международной системе мер
    @Test
    public void OverweightBodyMassIndexAccordingISTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("75");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("170");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Overweight");
    }

    //Тест на недостаточный индекс массы тела по американской системе мер
    @Test
    public void InsufficientBodyMassIndexAaccordingUSTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='pounds']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("99");
        driver.findElement(By.xpath("//select[@onchange='conv(1)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[1]/option[5]")).click();
        driver.findElement(By.xpath("//select[@onchange='conv(2)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[2]/option[8]")).click();
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Underweight");
    }

    //Тест на нормальный индекс массы тела по американской системе мер
    @Test
    public void NormalBodyMassIndexAccordingUSTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='pounds']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("121");
        driver.findElement(By.xpath("//select[@onchange='conv(1)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[1]/option[5]")).click();
        driver.findElement(By.xpath("//select[@onchange='conv(2)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[2]/option[8]")).click();
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Normal");
    }

    //Тест на избыточный индекс массы тела по американской системе мер
    @Test
    public void OverweightBodyMassIndexAccordingUSTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='pounds']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("165");
        driver.findElement(By.xpath("//select[@onchange='conv(1)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[1]/option[5]")).click();
        driver.findElement(By.xpath("//select[@onchange='conv(2)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[2]/option[8]")).click();
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Overweight");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}


