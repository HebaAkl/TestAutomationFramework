package frontend.drivers;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = null;
                break;
        }
        return driverManager;

    }

    public enum DriverType {
        CHROME,
        FIREFOX,
        IE,
        SAFARI;
    }
}