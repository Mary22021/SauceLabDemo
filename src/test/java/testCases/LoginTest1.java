package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTest1 {
    WebDriver driver;
    public Properties objProp ;
    @Test
    public void validLoginTest() throws IOException, InterruptedException {
        objProp = new Properties();
        FileInputStream file = new FileInputStream("config\\config.properties");
        objProp.load(file);
        System.out.println("url === "+ objProp.getProperty("url") );
        System.out.println("username === "+ objProp.getProperty("username") );
        System.out.println("password=== "+ objProp.getProperty("password") );
        String url =objProp.getProperty("url");
        String username =objProp.getProperty("username");
        String password =objProp.getProperty("password");
        String txt_username_id =objProp.getProperty("txt_username_id");
        String txt_password_id  =objProp.getProperty("txt_password_id");
        String btn_login_id  =objProp.getProperty("btn_login_id");
        String txt_logo_class =objProp.getProperty("txt_logo_class");
        driver.get(url);
        Thread.sleep(1000);
        driver.findElement(By.id(txt_username_id)).sendKeys(username);
        driver.findElement(By.id(txt_password_id)).sendKeys(password);
        driver.findElement(By.id(btn_login_id)).click();
        Thread.sleep(1000);
        String logoActuel = driver.findElement(By.className(txt_logo_class)).getText();
        Assert.assertEquals(logoActuel ,"Swag Labs", "text log est different de celui attendue ");
        Thread.sleep(1000);
    }
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
