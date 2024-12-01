package tests.frontend;

import org.testng.annotations.Test;


public class UserTest extends TestBase {

    @Test
    public void testFirst() {
        driver.get("http://www.google.com");
    }
}
