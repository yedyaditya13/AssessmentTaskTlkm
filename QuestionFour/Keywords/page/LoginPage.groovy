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

public class LoginPage extends Common {
	
	// Object Home Page
	private TestObject titleFashionHome = 	findTestObject('Object Repository/Mobile Android/Home Page/Title - Fashion')
	private TestObject titleStoreHome = 	findTestObject('Object Repository/Mobile Android/Home Page/Title - Store')
	private TestObject menuAccount = 	findTestObject('Object Repository/Mobile Android/Home Page/Menu - Account')
	
	// Object Account Page
	private TestObject titleSignIn = 	findTestObject('Object Repository/Mobile Android/Account Page/Title - Sign In')
	
	// Object Login Form Page
	private TestObject titleLogin = 	findTestObject('Mobile Android/Login Form Page/Title - Login')
	private TestObject inputEmail = 	findTestObject('Object Repository/Mobile Android/Login Form Page/Input - Email')
	private TestObject inputPassword = 	findTestObject('Object Repository/Mobile Android/Login Form Page/Input - Password')
	private TestObject btnLogin = 	findTestObject('Object Repository/Mobile Android/Login Form Page/Btn - Login')
	
	private TestObject btnSignout = 	findTestObject('Object Repository/Mobile Android/Login Form Page/Title - Sign Out')


	String textLogin = 'Login'
	String textSignout = 'Sign Out'
	String textSignin = 'Sign In'
	
	/*
	 * The function for verify form login page 
	 */
	@Test
	public void verifyFormLoginPage (FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		// Verify first on home page use object title Fashion and Store
		verifyElementExistWithFailure(titleFashionHome, flowControl)
		verifyElementExistWithFailure(titleStoreHome, flowControl)
		
		// Tap menu Account
		tapOnElement(menuAccount)
		
		// Verify title signin text exists and tap it
		verifyElementExistWithFailure(titleSignIn, flowControl)
		tapOnElement(titleSignIn)
		
		verifyElementExistWithFailure(titleLogin, flowControl)
		try {
			if (verifyEqual(titleLogin, textLogin) == true) {
				pass("Verify form Login Page Passed")
			} else {
				handleError("Verify form Login Page Failed", flowControl)
			}
		} catch(ex) {
			handleErrorException(ex, flowControl)
		}
	}
	
	
	/*
	 * The function for login true user
	 * @param email for input email
	 * @param password for input password
	 * */
	@Test
	public void loginTrue (String email, String password, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		tapOnElement(inputEmail)
		setElementText(inputEmail, email)
		hideKeyboard()
		
		tapOnElement(inputPassword)
		setElementText(inputPassword, password)
		hideKeyboard()
		
		tapOnElement(btnLogin)
		try {
			if (verifyEqual(btnSignout, textSignout) == true) {
				pass("Positif Case - Login True User Passed!")
			} else {
				handleError("Positif Case - Login True User Failed!", flowControl)
			}
		} catch(ex) {
			handleErrorException(ex, flowControl)
		}
	}
	
	/*
	 * The function for logout true user
	 * */
	@Test
	public void logoutTrue (FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		// Verify and logout user has login with confirmed Log Out title
		verifyElementExistWithFailure(btnSignout, flowControl)
		
		try {
			tapOnElement(btnSignout)
			if (verifyEqual(titleSignIn, textSignin) == true) {
				pass("Positif Case - Logout True User Passed!")
			} else {
				handleError("Positif Case - Logout True User Failed!", flowControl)
			}
		} catch(ex) {
			handleErrorException(ex, flowControl)
		}
	}
}
