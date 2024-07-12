import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager{
  public static WebDriver driver;
    public static void main(String [] args){
        System.out.println("heo");
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//libs//chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium");
    }
}
