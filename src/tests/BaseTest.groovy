import geb.junit4.GebReportingTest
import org.openqa.selenium.Dimension

class BaseTest extends GebReportingTest {
    int numberOfTrials = 5
    int waitTime = 10
    int count

    boolean DEFAULT_DEBUG_PRINT = false
    int DEFAULT_WINDOW_WIDTH = 1500
    int DEFAULT_WINDOW_HEIGHT = 1000

    def setupSpec() {
        setSettingsValue()
        def winSize = driver.manage().window().size
        driver.manage().window().setSize(new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT))
    }

    def void setSettingsValue() {
        String csvFile = "src/resources/testSettings.csv"
        BufferedReader br = null
        String line = ""
        String cvsSplitBy = ","

        try {
            br = new BufferedReader(new FileReader(csvFile))
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] settings = line.split(cvsSplitBy)
                println("Country [code= " + settings[0] + " , name=" + settings[1] + "]")

                if(settings[0] == "numberOfTrials") {
                    numberOfTrials = settings[1]
                }
                else if(settings[0] == "count") {
                    count = settings[1]
                }
                else if(settings[0] == "WINDOW_WIDTH") {
                    WINDOW_WIDTH = settings[1]
                }
                else if(settings[0] == "WINDOW_HEIGHT") {
                    WINDOW_HEIGHT = settings[1]
                }
                else {
                    break
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace()
        } catch (IOException e) {
            e.printStackTrace()
        } finally {
            if (br != null) {
                try {
                    br.close()
                } catch (IOException e) {
                    e.printStackTrace()
                }
            }
        }
    }
}



