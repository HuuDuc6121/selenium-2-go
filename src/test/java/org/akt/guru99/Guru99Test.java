/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.akt.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Admin
 */
public class Guru99Test {
    
    //cần cái trình duyệt
    private static WebDriver myBrowser;
    
    
    @BeforeAll //hàm này sẽ chạy 1 lần duy nhất
                //dùng để khởi động các biến cần dùng trong quá trình kiểm thử
                //dùng cho các hàm có @Test
                //hàm này chuẩn bị data - mở connection
    public static void setUpClass() {
        //khởi động trình duyệt để xài cho mọi hàm @Test
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        myBrowser = new ChromeDriver();
    }
    
    @Test
    //Test case: đưa 2 acc ngon lành, login thành công
    public void testGuru99LoginGivenRightAccountLoginSuccessfully() throws InterruptedException{
        myBrowser.get("https://demo.guru99.com/v4/");
        
        String username = "mngr451576";
        String pass = "pYmYpyp";
        
        
        //có trang login rồi, bắt được các tag: user/pass, login button
        WebElement txtUsername = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtUsername.sendKeys(username);
        
        WebElement txtPass = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPass.sendKeys(pass);
        
        WebElement loginBtn = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        loginBtn.click();
        
        //ta đi tìm cái thẻ Hello username nếu login thành công
        //xem thẻ đó text của nó có chữ Manager: <user-name-login> hay
        WebElement helloMsg = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        
        //CÀO DATA VỀ NÈ:
        String helloString = helloMsg.getText();
        //System.out.println("Hello Message: " + helloString);
        assertEquals("Manger Id : " + username, helloString);
        //so sánh giữa cụm từ mày phải chào
        //manger: <user đưa vào> và thực tế bắt đc ở trên trang sau login
        
        Thread.sleep(5000);
    }
    
    @AfterAll //hàm này sẽ chạy 1 lần duy nhất
                //dùng để dọn dẹp những thứ đã bày ra ở bên trong @Test
                //hàm này dọn dẹp data - đóng connection, xóa data lỡ chèn vào db
    public static void tearDownClass() {
        myBrowser.quit();
    }
    
}
