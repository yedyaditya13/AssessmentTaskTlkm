package page

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.Test

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utility.Common

public class OnboardingPage extends Common {
	
	private TestObject onboardPageIndex1 = 	findTestObject('Object Repository/Mobile Android/Onboarding Page/Page Onboard - Clothing')
	private TestObject onboardPageIndex2 = 	findTestObject('Object Repository/Mobile Android/Onboarding Page/Page Onboard - Beauty and Care')
	private TestObject onboardPageIndex3 = 	findTestObject('Object Repository/Mobile Android/Onboarding Page/Page Onboard - Home and Living')
	private TestObject onboardPageIndex4 = 	findTestObject('Object Repository/Mobile Android/Onboarding Page/Page Onboard - Gadgets')
	private TestObject btnLetsGetStarted = 	findTestObject('Object Repository/Mobile Android/Onboarding Page/Btn - Get Started')
	
	private String titlePageIndex1 = 'Clothing'
	private String titlePageIndex2 = 'Beauty & Care'
	private String titlePageIndex3 = 'Home & Living'
	private String titlePageIndex4 = 'Gadgets'


	
	/*
	 * Function for swipe onboarding page to home page logout user 
	 * @Notes : This swipe function for used device size 1080x2340 with density 400
	 */
	@Test
	public void swipeOnboardingPage() {
		// Verify page and swipe then tap button start shop
		verifyEqual(onboardPageIndex1, titlePageIndex1)
		swipe(939,1093,65,1061)
		
		verifyEqual(onboardPageIndex2, titlePageIndex2)
		swipe(939,1093,65,1061)
		
		verifyEqual(onboardPageIndex3, titlePageIndex3)
		swipe(939,1093,65,1061)
		
		verifyEqual(onboardPageIndex4, titlePageIndex4)

		verifyElementExistWithFailure(btnLetsGetStarted, FailureHandling.STOP_ON_FAILURE)
		tapOnElement(btnLetsGetStarted)			
	}
}
