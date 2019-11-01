import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

  static WebDriver driver;

  public static void main(String[] args) throws IOException {

    //Set ChomeDriver as we are using Chrome Browser in our Example.
    //Either set the ChromeDriver using traditional way by setting it using system property with hardcoded location like below
    //System.setProperty("webdriver.chrome.driver","C://driver/chromedriver.exe");

    //Or Use WebDriverManager to setup the chromedriver like below
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");
    driver = new ChromeDriver(options);

    //Specify the targetted URL
    String testURL = "https://timetable-ubtuit.herokuapp.com/map/1-floor";

    //Access the targetted URL
    driver.get(testURL);
    try {
      Thread.sleep(4000);
      //Capture screenshot of the web page using TakesScreenshot method
      final File screenShotOutputFile = new File("screenshot.png").getAbsoluteFile();
      File scrFile = ((TakesScreenshot) driver.findElement(By.id("html-page"))).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, screenShotOutputFile);
      System.out.println("Took Screenshot for " + testURL + " saved at " + screenShotOutputFile);

      //Quit the driver
      driver.quit();
    }
    catch(InterruptedException e)
    {
      // this part is executed when an exception (in this example InterruptedException) occurs
    }
  }
}