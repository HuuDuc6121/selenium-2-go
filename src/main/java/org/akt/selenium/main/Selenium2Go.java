package org.akt.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Selenium2Go {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Please wait 3s to lauch the Google search...");
        Thread.sleep(3000);
        playWithGoogleSearch();
    }
    
        public static void playWithGoogleSearch() throws InterruptedException{
        WebDriver myBrowser; 
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.drvier", driverPath);
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=en-GB");
        myBrowser = new ChromeDriver(opt);
 
        myBrowser.manage().window().maximize();
        myBrowser.get("https://youtube.com");
        
        //đi tìm thẻ input của pp search, đưa keyword Ca sỹ mặt nạ và nhấn Enter
        //mọi thứ trong browser, OOP đều là object
        //1 thẻ/tag cũng là 1 object, thuộc class WebElement
            WebElement searchBox = myBrowser.findElement(By.xpath("//input[@id='search']"));
            searchBox.sendKeys("Hoa hậu Thiên Ân");
            searchBox.submit();
        
        Thread.sleep(10000);//nghỉ 10 giây
        myBrowser.quit();
    }

    
    //ta se thay suc nguoi, suc com = suc code
    //dieu khien/xai trinh duyet bang code, tahy vi bang com
//    public static void playWithGoogle() throws InterruptedException{
//        WebDriver myBrowser; //khai bao 1 bien object de lát hồi trỏ vào vùng RAM chứa trình duyệt, chứa 1 tab trình duyệt đc tạo ra
//        //myBrowser chính là đại diện cho cái tab trình duyệt sẽ đc new/ mở ra. Mỗi lần Ctrl-T tương đương new mới 1 tab trình duyệt
//        //khai báo đường dẫn trỏ tới file driver
//        String driverPath = "chromedriver.exe";
//        //báo với máy ảo java load toàn bộ các class chứa trong .exe này vào RAM để chuẩn bị tương tác với trình duyệt ~~~ Class.forName() JDBC
//        System.setProperty("webdriver.chrome.drvier", driverPath);
//        
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--incognito");
//        opt.addArguments("--lang=ja-JP");
//        
//        
//        //gọi trình duyệt xuất hiện, new 1 object, tốn RAM
//        myBrowser = new ChromeDriver(opt);
//        //trình duyệt đc đưa vào RAM, hiện lên!!!
//        //myBrowser. tức là gọi các hành động trên trình duyệt
//        
//        //bung full màn hình rồi duyệt web
//        myBrowser.manage().window().maximize();
//        myBrowser.get("https://youtube.com");
//        
//        //nghỉ một chút để xem trang web rồi hãy tắt
//        Thread.sleep(10000);//nghỉ 10 giây
//        myBrowser.quit();
//    }
    
}
