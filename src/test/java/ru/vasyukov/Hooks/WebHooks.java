package ru.vasyukov.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.vasyukov.Custom.Properties.TestData;
import com.codeborne.selenide.Configuration;
import ru.vasyukov.Custom.Listeners;
import org.openqa.selenium.support.events.WebDriverListener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;

public class WebHooks {
    /**
     * Объект Listeners в зависимости от настройки в проперти или null
     */
    private static final WebDriverListener listener = Listeners.getListener();

    // Настройка опций браузера и листенера первый раз
    static {
        Configuration.timeout = Long.parseLong(TestData.props.defaultTimeoutImplicitMs());
        if (listener != null) addListener(listener);
        if (TestData.props.headlessMode() != null) Configuration.headless = true;
        if (TestData.props.dontCloseBrowser() != null) Configuration.holdBrowserOpen = true;
        if (TestData.props.remoutUrl() != null) Configuration.remote = TestData.props.remoutUrl();

        if ((TestData.props.typeBrowser() == null || TestData.props.typeBrowser().equals("chrome")) &&
                TestData.props.webdriverChromeLocalPath() != null) {
            System.setProperty("webdriver.chrome.driver", TestData.props.webdriverChromeLocalPath());
            WebDriver driver = new ChromeDriver();
            setWebDriver(driver);
        } else if (TestData.props.typeBrowser() != null)
            if (TestData.props.typeBrowser().equals("edge")) {
                System.setProperty("webdriver.edge.driver", TestData.props.webdriverEdgeLocalPath());
                WebDriver driver = new EdgeDriver();
                setWebDriver(driver);
            } else Configuration.browser = TestData.props.typeBrowser();
        else Configuration.browser = "chrome";
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");  // устарел, use  getWebDriver().manage().window().maximize();
//        DesiredCapabilities capabilities = new DesiredCapabilities();  // old
//        MutableCapabilities capabilities = new MutableCapabilities();  // new
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        Configuration.browserCapabilities = capabilities;
    }

    /**
     * Открытие базового url перед каждым тестом
     */
    @Before
    public void setDriverPropsAndOpen() {
        open(TestData.props.baseUrlJira());
        getWebDriver().manage().window().maximize();
    }

    @After
    public void close() {
        //closeWindow();  // holdBrowserOpen с этим не работает
        closeWebDriver();
    }
}
