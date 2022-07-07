import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.Before;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class search_case {


    ////CASE-1
    /*

    Search alanında iphone 13 pro max yazılır
    sonuçlardan ilk sıradaki ürün seçilir
    ürün detayından görsel swipe yapılır
    Sepete ekle buton tıklanır
    sepete eklenen ürün doğrulanır


     */

    private AndroidDriver driver;
    public WebDriverWait wait;
    String PREFIX="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/";

    String product="iphone 13 pro max";
    private final By search = By.id("com.pozitron.hepsiburada:id/textViewSearchBox") ;
    private final By searchBox_txt= By.id("com.pozitron.hepsiburada:id/etACBSearchBox");
    private final By first_product_click = By.xpath(PREFIX+"android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView") ;
    private final By box_add_btn= By.xpath("(//*[contains(@text,'SEPETE EKLE')])[1]");
    private final By modal_box_add = By.id("com.pozitron.hepsiburada:id/atcb_product_variant");
    private final By box_detail= By.id("com.pozitron.hepsiburada:id/nav_graph_cart");
    private final By value_box_product= By.xpath(PREFIX+"android.view.ViewGroup[1]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View");



    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appium:platformVersion", "10.0");
        desiredCapabilities.setCapability("appium:deviceName", "PixelPixel 2 XL API 29");
        desiredCapabilities.setCapability("appium:app", "/Users/mobven/Desktop/apk_ipa_file/Hepsiburada Online Shopping_v5.2.6_apkpure.com.apk");
        desiredCapabilities.setCapability("appium:fullReset", false);
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver,15);
    }

    @Test
    public void sampleTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_txt)).sendKeys(product);
        wait.until(ExpectedConditions.visibilityOfElementLocated(first_product_click)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(box_add_btn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal_box_add)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(box_add_btn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal_box_add)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(box_detail)).click();

        /*String value=wait.until(ExpectedConditions.visibilityOfElementLocated(value_box_product)).getAttribute("text");
        System.out.println("Ürün value"+value);*7

        //Assert.assertEquals(value1,value,"");*/

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
