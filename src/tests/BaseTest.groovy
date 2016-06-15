import geb.junit4.GebReportingTest
import org.openqa.selenium.Dimension

class BaseTest extends GebReportingTest {
    static int numberOfTrials = 5
    static int waitTime = 10
    int count

    static final boolean DEFAULT_DEBUG_PRINT = false
    static final int DEFAULT_WINDOW_WIDTH = 1500
    static final int DEFAULT_WINDOW_HEIGHT = 1000

    def setupSpec() {

        def winSize = driver.manage().window().size
        driver.manage().window().setSize(new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT))

    }
}



