import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class NegativeScenario {

	private String baseUrl = 'https://dashboard.midtrans.com/login'

	public void launchApp () {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver")
		WebDriver driver = new ChromeDriver()
		driver.get(this.baseUrl)
		DriverFactory.changeWebDriver(driver)
	}

	public validateLogin (String scenario) {
		if (scenario == 'emailNotValid') {
			WebUI.setText(findTestObject('Login Page/Page_MAP  Midtrans/input_Email Address_useremail'), '1123345@12345')
			WebUI.setText(findTestObject('Login Page/Page_MAP  Midtrans/input_Password_userpassword'), 'iGDxf8hSRT4=')
			WebUI.click(findTestObject('Login Page/Page_MAP  Midtrans/button_Log me in'))

			if (WebUI.verifyElementText(findTestObject('Object Repository/Login Page/Page_MAP  Midtrans/h1_Log In'), 'Log In') == true) {
				KeywordUtil.markPassed("Validate Email Not Valid Passed")
			}else {
				KeywordUtil.markFailedAndStop("Validate Email Not Valid Failed")
			}
		} else  if (scenario == 'userUnregistered'){
			WebUI.setText(findTestObject('Login Page/Page_MAP  Midtrans/input_Email Address_useremail'), 'unregisteredUser@gmail.com')
			WebUI.setText(findTestObject('Login Page/Page_MAP  Midtrans/input_Password_userpassword'), '12345')
			WebUI.click(findTestObject('Login Page/Page_MAP  Midtrans/button_Log me in'))

			if (WebUI.verifyElementText(findTestObject('Object Repository/Login Page/Page_MAP  Midtrans/h1_Log In'), 'Log In') == true) {
				KeywordUtil.markPassed("Validate User Unregistered Passed")
			}else {
				KeywordUtil.markFailedAndStop("Validate User Unregistered Failed")
			}
		}
	}
}
