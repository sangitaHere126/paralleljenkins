package managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebDriverManager {
    WebDriver driver;
    Properties prop;
    Properties config1;
    String destinationFilePath;
    public WebDriverManager() {
        // init the properties file
        try {
            prop=new Properties();
            config1=new Properties();
            String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
            //String pathConfig = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
            FileInputStream fs = new FileInputStream(path);
            prop.load(fs);
           /* FileInputStream fs1 = new FileInputStream(pathConfig);
            config1.load(fs1);
            log.info("properties file loaded" + "user.dir");*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        // softAssert = new SoftAssert();
       // reports=ExtentManager.getReports();
        // init(test);
    }

    public void launchApp(String browserName)  {
        if (driver == null) {
            if(browserName.equals("Chrome")) {
                try {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("disable-infobars");
                    chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                   // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//libs//chromedriver.exe");
                   // WebDriverManager.chromedriver().setup()
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    // log.info("Driver launched " + "Android Driver");
                    // log("DRiver launched");
                } catch (Exception e) {
                    // Test Set up Fail
                    e.printStackTrace();
                }
            }
            driver.manage().window().maximize();
        }
    }

    public void navigate(String urlKey) {
        //log("Navigating to "+getProperty(urlKey) );
        //System.out.println("Navigating to "+getProperty(urlKey) );
        driver.get(urlKey);
        System.out.println("Navigating passed " +urlKey );
       // log.info("url opened" );

        //driver.get(getProperty(urlKey));
    }

    public void quit(){
        if(driver!=null)
            driver.quit();
    }

    public WebElement findElement(String locatorKey) {
        By locator = getLocator(locatorKey);
        WebElement e = null;
        try {
            // present and visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            e = driver.findElement(locator);
        }catch(Exception ex) {
            // report failure
         //   logFailure("Object not found "+ locatorKey,true);
        }
        return e;
    }
    public String getProperty(String key) {
        return prop.getProperty(key);
    }
    public By getLocator(String locatorKey) {

        if(locatorKey.endsWith("_id"))
            return By.id(getProperty(locatorKey)); // By.id("login_id")
        else if(locatorKey.endsWith("_name"))
            return By.name(getProperty(locatorKey));
        else if(locatorKey.endsWith("_xp"))
            return By.xpath(getProperty(locatorKey));
        else
            return By.cssSelector(getProperty(locatorKey));
    }

    public void entersText(String textData, String locatorKey) {
        WebElement element = null;
        element = findElement(locatorKey);
        element.sendKeys(textData);
    }
}
