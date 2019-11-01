package telegrambot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class TestImage {

  static WebDriver driver;

  public void capturePage(String Url) throws IOException{
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");
    driver = new ChromeDriver(options);

    //Specify the targetted URL
//    String testURL = "http://localhost:9000/map/1-floor";

    //Access the targetted URL
    driver.get(Url);
    try {
      Thread.sleep(100);
      final File screenShotOutputFile = new File("/home/prince/IdeaProjects/timetable_bot/public/images/screenshot.png").getAbsoluteFile();
      File scrFile = ((TakesScreenshot) driver.findElement(By.id("html-page"))).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, screenShotOutputFile);
      System.out.println("Took Screenshot for " + Url + " saved at " + screenShotOutputFile);

      //Quit the driver
      driver.quit();
    } catch (InterruptedException e) {
      // this part is executed when an exception (in this example InterruptedException) occurs
    }
  }
}