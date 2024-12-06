package com.stampfree.core.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.gecko.options.GeckoOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Logger;

import static com.stampfree.core.server.SessionManager.startServer;
import static com.stampfree.core.server.SessionManager.stopServer;

public class AndroidDriverManager {
    private static final String APP_PATH = String.valueOf(
            Path.of(System.getProperty("user.dir"), "/src/java/resources/apps", "app-stampfreeBeta-release.apk"));
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = Logger.getLogger("AndroidDriverManager.class");

    public static void createAndroidDriver() {
        startServer("android");
        try {
            setDriver(new AndroidDriver(new URL("http://localhost/4723"), uiAutomator2OptionsWdio()));
        } catch (final MalformedURLException e) {
            throw new RuntimeException(e);
        }
        setupDriverTimeouts();
    }

    public static AndroidDriver getDriver() {
        return AndroidDriverManager.DRIVER.get();
    }

    public static void quitSession() {
        if (null != DRIVER.get()) {
            LOG.info("Closing the driver...");
            getDriver().quit();
            DRIVER.remove();
            stopServer();
        }
    }

    private static GeckoOptions geckoOptionsFirefox() {
        final HashMap<String, Object> firefoxOptions = new HashMap<>();
        firefoxOptions.put("androidPackage", "org.mozilla.firefox");
        //firefoxOptions.put ("androidDeviceSerial", "EMULATOR32X1X12X0");
        final GeckoOptions geckoOptions;
        geckoOptions = new GeckoOptions().setPlatformName("mac")
                .setAutomationName(AutomationName.GECKO)
                .setMozFirefoxOptions(firefoxOptions)
                .setAndroidStorage("app")
                .setAcceptInsecureCerts(true)
                .setNoReset(false);
        return geckoOptions;
    }

    private static void setDriver(final AndroidDriver driver) {
        AndroidDriverManager.DRIVER.set(driver);
    }

    private static void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:udid", "RZCW605RKWH");
        capabilities.setCapability("appium:noReset", "false");
        capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", "50000");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "src/main/resources/apps/app-stampfreeBeta-release.apk");
        capabilities.setCapability("appium:appWaitForLaunch", "false");
        return capabilities;
    }

    private static UiAutomator2Options uiAutomator2OptionsChrome() {

        final UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options().setAvd("Pixel_6_API_34")
                .setAvdLaunchTimeout(Duration.ofSeconds(300))
                .setAvdReadyTimeout(Duration.ofSeconds(100))
                .setDeviceName("Pixel_6_API_34")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .withBrowserName("chrome")
                .setAutoGrantPermissions(true)
                .setNoReset(false);

        return uiAutomator2Options;
    }

    private static UiAutomator2Options uiAutomator2OptionsProverbial() {

        final UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options().setAvd("Pixel_XL_API_33")
                .setAvdLaunchTimeout(Duration.ofSeconds(300))
                .setAvdReadyTimeout(Duration.ofSeconds(100))
                .setDeviceName("Pixel_XL_API_33")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(APP_PATH)
                .setAutoGrantPermissions(true)
                .setAppPackage("com.lambdatest.proverbial")
                .setAppActivity("com.lambdatest.proverbial.MainActivity")
                .setNoReset(false);
        return uiAutomator2Options;
    }

    private static UiAutomator2Options uiAutomator2OptionsWdio() {
        final UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options().setAvd("Pixel_6_Pro_API_34")
                .setAvdLaunchTimeout(Duration.ofSeconds(300))
                .setAvdReadyTimeout(Duration.ofSeconds(100))
                .setDeviceName("Pixel_6_Pro_API_34")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(APP_PATH)
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                .setNoReset(false);
        return uiAutomator2Options;
    }

}