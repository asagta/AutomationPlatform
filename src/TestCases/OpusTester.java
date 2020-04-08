package TestCases;
import Actions.Basic;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
public class OpusTester {
static WebDriver dr;
static String EXCEL_FILE_LOCATION;
static Workbook workbook;
static Sheet sheet;
static Document document;
static HashMap<String, String> map;
static ArrayList<String> inputData;
    @BeforeSuite
    public void initiateDriver() throws BiffException, IOException
    {
	Basic b=new Basic();
	b.getDriver();
	dr=b.w;
	EXCEL_FILE_LOCATION = "H:\\aframe\\Book1.xls";
	workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
	sheet=workbook.getSheet(0);
    }
    @BeforeSuite
    public void initiateHashMap() throws Exception
    {
    	int size=37;int j,k,l;    	int i=2;k=2;l=0;
    	String a,b;
    	System.out.println("THE SIZE:"+size);
    	 map=new HashMap<>();
    	//map.put("A", "A");
    	 inputData=new ArrayList<String>();
    	while(i<size)
    	{
    		System.out.println(sheet.getCell(0,i).getContents()+","+sheet.getCell(1,i).getContents());
    		a=(String)sheet.getCell(0,i).getContents();b=(String)sheet.getCell(1,i).getContents();
    		map.put(a,b);
    		if(!sheet.getCell(2,i).getContents().equals(""))
    		{
    			inputData.add(sheet.getCell(2,i).getContents());
    			l++;
    		}
    		System.out.println(i);
    		i++;  			
    	}
    	String driverPath=System.getProperty("user.dir")+"\\jars\\"+"TestScreens.pdf";
    	document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(driverPath));
       document.open();
    }
    public static void takeSnapShot(WebDriver webdriver) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File(System.getProperty("user.dir")+"\\jars\\"+"TestScreens.png");
                //Copy file at destination
                FileUtils.copyFile(SrcFile, DestFile);
                Image img = Image.getInstance(System.getProperty("user.dir")+"\\jars\\"+"TestScreens.png");
                img.scaleToFit(600f, 600f);
                document.add(img);
               
    }
    @Test
    public void WebsiteTest() throws Exception
    {
     	int i=0;int j=1;
     	//sortbykey();
     	//System.out.println(map);
     	dr.get(sheet.getCell(1, 1).getContents());
     	dr.manage().window().maximize();
     	Basic b=new Basic();
     	b.SelectItemFromElements(map.get(""+j++), inputData.get(i++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	b.sendKeysToElement(map.get(""+j++), inputData.get(i++));
     	b.sendKeysToElement(map.get(""+j++), inputData.get(i++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));b.clickOnElement(map.get(""+j++));
     	b.SwitchToFrame(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	b.sendKeysToElement(map.get(""+j++), inputData.get(i++));
     	b.sendKeysToElement(map.get(""+j++), inputData.get(i++));
     	b.SelectItemFromElements(map.get(""+j++), inputData.get(i++));
     	b.sendKeysToElement(map.get(""+j++), inputData.get(i++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.performDragDrop(map.get(""+j++), map.get(""+j++));
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.SelectItemFromElements(map.get(""+j++), inputData.get(i++));
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
     	b.clickOnElement(map.get(""+j++));
     	takeSnapShot(dr);
    }
    @AfterSuite(alwaysRun = true)
    public void closepdf()
    {
    	document.close();
    }
    
}
