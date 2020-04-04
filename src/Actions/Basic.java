package Actions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic {
 public static WebDriver w;
   public void getDriver()
   {
       String driverPath=System.getProperty("user.dir")+"\\jars\\"+"IEDriverServer.exe";
       System.setProperty("webdriver.ie.driver", driverPath);
       w=new InternetExplorerDriver();
   }
   public void WaitForElement(WebElement web)
   {
       WebDriverWait wait=new WebDriverWait(w,50);
       wait.until(ExpectedConditions.visibilityOf(web));
   }
   public void sendKeysToElement(Map<String, String> map,String txt)
   {
       WebElement web;
       if(map.containsKey("xpath"))
           web=w.findElement(By.xpath(map.get("xpath")));
       else
	   web=w.findElement(By.id(map.get("id")));  
       WaitForElement(web);
       web.sendKeys(txt);
   }
   public void clickOnElement(Map<String, String> map)
   {
       WebElement web;
       if(map.containsKey("xpath"))
           web=w.findElement(By.xpath(map.get("xpath")));
       else
	   web=w.findElement(By.id(map.get("id")));  
       WaitForElement(web);
       web.click(); 
   }
   public void SelectItemFromElements(Map<String, String> map,String text)
   {
       Select sel ;
       if(map.containsKey("xpath"))
           sel=new Select(w.findElement(By.xpath(map.get("xpath"))));
       else
	   sel=new Select(w.findElement(By.xpath(map.get("id"))));
       sel.selectByVisibleText(text);
   }
   public void SwitchToFrame(String frame)
   {
       w.switchTo().frame(frame);
   }
   public void closeHandles()
   {
       WebDriverWait wait=new WebDriverWait(w,50);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	//String s=driver.getWindowHandle();
	ArrayList<String> tabs = new ArrayList<String> (w.getWindowHandles());
	//System.out.println(s);
	w.switchTo().window(tabs.get(1));
	w.close();
	w.switchTo().defaultContent();
   }
   public void performDragDrop(Map<String, String> map1,Map<String, String> map2)
   {
       WebElement web1,web2;
       if(map1.containsKey("xpath") && map2.containsKey("xpath"))
       {
           web1=w.findElement(By.xpath(map1.get("xpath")));
           web2=w.findElement(By.xpath(map2.get("xpath")));
       }else{
	   web1=w.findElement(By.xpath(map1.get("id")));
           web2=w.findElement(By.xpath(map2.get("id")));
	   }  
       //Using Action class for drag and drop.		
       Actions act=new Actions(w);					
	//Dragged and dropped.		
       act.dragAndDrop(web1, web2).build().perform();
   }
}
