package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest2 extends BaseTest{

    @Test
    public void validLoginTest() throws IOException, InterruptedException {
        loadProperties();
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


}
