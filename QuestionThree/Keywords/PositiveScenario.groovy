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

public class PositiveScenario {

	private String baseUrlForgotPass = 'https://dashboard.midtrans.com/password/new'
	private String baseUrlResendConfirm = 'https://dashboard.midtrans.com/confirmation'

	private TestObject titleLinkVerificationForgotPass = findTestObject('Object Repository/Forgot Password/Page_MAP  Midtrans/h1_Verification link sent')

	private TestObject bannerResendConfirmSuccess = findTestObject('Object Repository/Resend Confimation/Page_MAP  Midtrans/div_We will send instructions to confirm yo_5739e8')

	public void launchApp (String scenario) {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver")
		WebDriver driver = new ChromeDriver()

		if (scenario == 'forgotPassword') {
			driver.get(this.baseUrlForgotPass)
			DriverFactory.changeWebDriver(driver)
		} else if (scenario == 'resendConfirmation') {
			driver.get(this.baseUrlResendConfirm)
			DriverFactory.changeWebDriver(driver)
		}
	}

	public void sendEmailVerifyForgotPassword () {
		WebUI.setText(findTestObject('Object Repository/Forgot Password/Page_MAP  Midtrans/input_Email Address_useremail'), 'aku@gmail.com')

		WebUI.click(findTestObject('Object Repository/Forgot Password/Page_MAP  Midtrans/button_Send link'))

		if (WebUI.verifyEqual(WebUI.getText(titleLinkVerificationForgotPass), 'Verification link sent') == true) {
			KeywordUtil.markPassed("Send Email Forgot Password To User Passed")
		} else {
			KeywordUtil.markErrorAndStop("Send Email Forgot Password To User Failed")
		}
	}

	public void sendResendConfirmationEmail () {
		WebUI.setText(findTestObject('Object Repository/Resend Confimation/Page_MAP  Midtrans/input_Email Address_useremail'), 'saya@gmail.com')

		WebUI.click(findTestObject('Object Repository/Resend Confimation/Page_MAP  Midtrans/button_Send Link'))

		if (WebUI.verifyElementVisible(bannerResendConfirmSuccess) == true) {
			KeywordUtil.markPassed("Resend Confirmation Email Passed")
		}else {
			KeywordUtil.markErrorAndStop("Resend Confirmation Email Failed")
		}
	}
}
