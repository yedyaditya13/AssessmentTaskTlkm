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
import javassist.bytecode.stackmap.BasicBlock.Catch
import utility.Common

public class SignUpPage extends Common {
	
	// Object Home Page
	private TestObject titleFashionHome = 	findTestObject('Object Repository/Mobile Android/Home Page/Title - Fashion')
	private TestObject titleStoreHome = 	findTestObject('Object Repository/Mobile Android/Home Page/Title - Store')
	private TestObject menuAccount = 	findTestObject('Object Repository/Mobile Android/Home Page/Menu - Account')
	
	// Object Account Page
	private TestObject titleSignIn = 	findTestObject('Object Repository/Mobile Android/Account Page/Title - Sign In')
	
	// Object Login Form Page
	private TestObject titleLogin = 	findTestObject('Mobile Android/Login Form Page/Title - Login')
	
	// Object Signup Form page
	private TestObject scrollableSignUpForm = 	findTestObject('Mobile Android/Signup Form Page/Scrollable - Signup')
	private TestObject titleSignUp = 	findTestObject('Mobile Android/Signup Form Page/Title - Signup')
	private TestObject inputUsername = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Input - User Name')
	private TestObject inputEmail = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Input - Email')
	private TestObject inputPassword = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Input - Password')
	private TestObject inputConfirmPassword = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Input - Confirm Password')
	private TestObject btnSignup = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Button - Signup')
	private TestObject alertSignupError = 	findTestObject('Object Repository/Mobile Android/Signup Form Page/Alert - Error Signup')
	
	String textSignUp = 'Signup'
	String errorMessageEmailEmpty = 'Please enter email address.';
	String errorMsgConfirmPassNotMatch = 'Password and Confirm password not match.'

	
	/*
	 * The function for verify form signup page 
	 */
	@Test
	public void verifyFormSignupPage (FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		// Verify first on home page use object title Fashion and Store
		verifyElementExistWithFailure(titleFashionHome, flowControl)
		verifyElementExistWithFailure(titleStoreHome, flowControl)
		
		// Tap menu Account
		tapOnElement(menuAccount)
		
		// Verify title signin text exists and tap it
		verifyElementExistWithFailure(titleSignIn, flowControl)
		tapOnElement(titleSignIn)
		
		verifyElementExistWithFailure(titleLogin, flowControl)
		
		// Swipe to form signup
		swipe(978, 833, 55, 898)
		
		try {
			if (verifyEqual(titleSignUp, textSignUp) == true) {
				pass("Verify form Sign Up Page Passed")
			} else {
				handleError("Verify form Sign Up Page Failed", flowControl)
			}
		} catch(ex) {
			handleErrorException(ex, flowControl)
		}
		
	}
	
	/*
	 * The function for validation signup using email cases
	 * @param cases for runing case choosen
	 * @param username for input username
	 * @param email for input email
	 * @param password for input password
	 * @param confirmPassword for input confirm password
	 * */
	@Test
	public void validationEmailSignup (String cases, String username, String email, String password, String confirmPassword, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		
		if (cases == 'emailEmpty') {
			// Input user name
			tapOnElement(inputUsername)
			setElementText(inputUsername, username)
			hideKeyboard()
			
			// Input email
			tapOnElement(inputEmail)
			setElementText(inputEmail, email)
			hideKeyboard()
			
			// Input password
			tapOnElement(inputPassword)
			setElementText(inputPassword, password)
			hideKeyboard()
			
			// Input confirm password
			tapOnElement(inputConfirmPassword)
			setElementText(inputConfirmPassword, confirmPassword)
			hideKeyboard()
			
			tapOnElement(btnSignup)
			
			try {
				if (verifyEqual(alertSignupError, errorMessageEmailEmpty) == true) {
					pass("Validation Negatif Case - Registered Using Email Empty Passed!")
				} else {
					handleError("Validation Negatif Case - Registered Using Email Empty Failed!", flowControl)
				}
			} catch(ex) {
				handleErrorException(ex, flowControl)
			}
			
		// TODO	checked validation email not valid
		} else if (cases == 'emailNotValid') {
			
		// TODO checked validation email has registered
		} else if (cases == 'emailHasRegistered') {
			
		}
	}
	
	/*
	 * The function for validation signup using password cases
	 * */
	@Test
	public void validationPasswordSignup (String cases, String username, String email, String password, String confirmPassword, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		
		// Validation verify password and confirm password is matching
		if (cases == 'passwordAndConfirmpasswordNotMatch') {
			// Input user name
			tapOnElement(inputUsername)
			setElementText(inputUsername, username)
			hideKeyboard()
			
			// Input email
			tapOnElement(inputEmail)
			setElementText(inputEmail, email)
			hideKeyboard()
			
			// Input password
			tapOnElement(inputPassword)
			setElementText(inputPassword, password)
			hideKeyboard()
			
			// Input confirm password
			tapOnElement(inputConfirmPassword)
			setElementText(inputConfirmPassword, confirmPassword)
			hideKeyboard()
			
			tapOnElement(btnSignup)
			
			try {
				if (verifyEqual(alertSignupError, errorMsgConfirmPassNotMatch) == true) {
					pass("Validation Negatif Case - Registered not match password with confirm password Passed!")
				} else {
					handleError("Validation Negatif Case - Registered not match password with confirm password Failed!", flowControl)
				}
			} catch(ex) {
				handleErrorException(ex, flowControl)
			}
		} 
		// TODO checked validation password empty
		else if (cases == 'passwordEmpty') {
			
		// TODO checked validation confirm password empty
		} else if (cases == 'confirmPasswordEmpty') {
			
		}
	}
}
