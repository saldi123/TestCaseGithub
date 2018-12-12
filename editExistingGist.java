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


public class editExistingGist {
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

		// click on the profile icon on the upper right corner
		driver.findElement(By.xpath("//img[@class='avatar float-left mr-1']")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

		// click on the button that says "Your gists"
		driver.findElement(By.xpath("//a[contains(text(),'Your gists')]")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

		// click on the button that says "See all of your gists"
		driver.findElement(By.xpath("//a[contains(text(),'See all of your gists')]")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

		
		// click on the gist you would like to edit
		driver.findElement(By.xpath("//strong[@class='css-truncate-target'][contains(text(),'editMePlease.java')]")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});


		// click on the edit button
		driver.findElement(By.xpath("//*[@class='octicon octicon-pencil']")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
		
		 
		// type in the text for description
		WebElement Description = driver.findElement(By.xpath("//input[@name='gist[description]']"));
		Description.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Description.sendKeys("Edited Description");
		
		// type in the text for the title
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']"));
		name.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		name.sendKeys("editedFile.java");	
		
		// type in the text for the text area
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('Edited Text Area')");
		
		//button[contains(text(),'Update public gist')]
		
		// click on the button that says update public gist
		driver.findElement(By.xpath("//button[contains(text(),'Update public gist')]")).click();

		// wait until page is fully loaded
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

	}
	
	

}