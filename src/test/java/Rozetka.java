import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static java.time.Duration.ofSeconds;


public class Rozetka {

    // Инициализируем WebDriver при помощи модификатора доступа public Static и создания нового поля,
    // для автоматического использования в других классах
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Установка веб драйвера
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Устанавливается не явная задержка
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        // Разворачивание страницы
        driver.manage().window().maximize();

        driver.get("https://rozetka.ua");

        Thread.sleep(4000);
        WebElement closeBtn = driver.findElement(By.xpath("//span[@class='exponea-close-cross']"));
        closeBtn.click();

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Iphone 13");

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException m) {
            System.out.println("<<<<<No alert>>>>>");
        }

        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),' Знайти ')]"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement forthPhone = driver.findElement(By.xpath("(//span[@class=\"goods-tile__title\"])[4]"));
        forthPhone.click();

        Thread.sleep(2000);
        WebElement buyBtn = driver.findElement(By.xpath("//span[@class=\"buy-button__label ng-star-inserted\"]"));
        buyBtn.click();

        Thread.sleep(4000);
        driver.quit();

    }
}
