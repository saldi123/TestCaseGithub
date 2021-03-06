package testCaseGithub;



import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

//import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.JavascriptExecutor;


public class createPublicGist {
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\muham\\Documents\\Java Workspace\\Lib\\chrome driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// go to github.com
		driver.get("https://github.com/login/");

		// input username
		driver.findElement(By.id("login_field")).sendKeys("muhammads06021994@gmail.com");

		// input password
		driver.findElement(By.id("password")).sendKeys("dinsa71adm");

		// click on the sign in button
		driver.findElement(By.xpath("//INPUT[@type='submit']")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

		// go to gist.github.com
		driver.get("https://gist.github.com/");

		// input description
		driver.findElement(By.xpath("//input[@name='gist[description]']")).sendKeys("this is the description of the gist");

		// input filename including extension
		driver.findElement(By.xpath("//input[@name='gist[contents][][name]']")).sendKeys("createPublicGist.java");

		// type in the text into the Text Area
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('Code Goes Here" 
				+ " hello world"
				+ " hello universe" 
				+ " hello people')");

		// click on the button that says create public gist
		driver.findElement(By.name("gist[public]")).click();
		
		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

	}

}