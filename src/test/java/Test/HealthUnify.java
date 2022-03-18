package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class HealthUnify {
    WebDriver driver;

    //Тест на ввод валидных значений по нашей системе мер
    @Test
    public void validInputTest() {
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

    //Тест на ввод валидных значений по американской системе мер
    @Test
    public void validInputAmericanSystemMeasureTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='pounds']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("110");
        driver.findElement(By.xpath("//select[@onchange='conv(1)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[1]/option[5]")).click();
        driver.findElement(By.xpath("//select[@onchange='conv(2)']")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[2]/option[8]")).click();
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Obese");
    }

    //Тест на ввод огромных значений по росту и маленьких значений по весу
    @Test
    public void tallAndLowWeightTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("20");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("1000000000");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String text = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        Assert.assertEquals(text, "Your category is Starvation");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}


