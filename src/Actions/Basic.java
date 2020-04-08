package Actions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       WebDriverWait wait=new WebDriverWait(w,50);
       wait.until(ExpectedConditions.visibilityOf(web));
   }
   public void sendKeysToElement(String map,String txt)
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       WebElement web;
       System.out.println(map);
       if(map.contains("/"))
           web=w.findElement(By.xpath(map));
       else
	   web=w.findElement(By.id(map));  
       WaitForElement(web);
       web.sendKeys(txt);
   }
   public void clickOnElement(String map)
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       WebElement web;
       System.out.println(map);
       if(map.contains("/"))
           web=w.findElement(By.xpath(map));
       else
	   web=w.findElement(By.id(map));  
       WaitForElement(web);
       web.click(); 
   }
   public void SelectItemFromElements(String entry,String text)
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       Select sel ;
       w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       if(entry.contains("/"))
           sel=new Select(w.findElement(By.xpath(entry)));
       else	   
	      sel=new Select(w.findElement(By.id(entry)));
       sel.selectByVisibleText(text);
   }
   public void SwitchToFrame(String frame)
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
	   WebDriverWait wait=new WebDriverWait(w,60);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
       //w.switchTo().frame(frame);
   }
   public void closeHandles()
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       WebDriverWait wait=new WebDriverWait(w,50);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	//String s=driver.getWindowHandle();
	ArrayList<String> tabs = new ArrayList<String> (w.getWindowHandles());
	//System.out.println(s);
	w.switchTo().window(tabs.get(1));
	w.close();
	w.switchTo().defaultContent();
   }
   public void performDragDrop(String map1,String map2)
   {
	   JavascriptExecutor js = (JavascriptExecutor) w;  
	   js.executeScript("window.focus();");
       WebElement web1,web2;
       if(map1.contains("/") && map2.contains("/"))
       {
           web1=w.findElement(By.xpath(map1));
           web2=w.findElement(By.xpath(map2));
       }else{
	   web1=w.findElement(By.xpath(map1));
           web2=w.findElement(By.xpath(map2));
	   }  
       //Using Action class for drag and drop.		
       Actions act=new Actions(w);					
	//Dragged and dropped.		
       act.dragAndDrop(web1, web2).build().perform();
   }
}
