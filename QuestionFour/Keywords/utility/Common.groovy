package utility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.eclipse.persistence.jpa.jpql.Assert.AssertException

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import internal.GlobalVariable

public class Common {

	protected void shortDelay() {
		Mobile.delay(GlobalVariable.shortDelay)
	}

	protected void mediumDelay() {
		Mobile.delay(GlobalVariable.mediumDelay)
	}

	protected void longDelay() {
		Mobile.delay(GlobalVariable.longDelay)
	}
	
	protected void swipe(int x1, int y1, int x2, int y2) {
		Mobile.swipe(x1, y1, x2, y2)
	}
	
	protected void tapOnElement(TestObject object) { 
		Mobile.tap(object, 0)
	}
	
	protected void setElementText (TestObject object, String text) {
		Mobile.setText(object, text, 0)
	}
	
	protected void getElementText (TestObject object) {
		String getText = Mobile.getText(object, 0)
	}
	
	protected verifyEqual(TestObject object, String text) {
		String getText = Mobile.getText(object, 0)
		if (Mobile.verifyEqual(getText, text)) {
			return true
		}else {
			return false
		}
	}
	
	protected void verifyElementExistWithFailure(TestObject object, FailureHandling flowControl) {
		switch(flowControl){
			case FailureHandling.STOP_ON_FAILURE:
				Mobile.verifyElementExist(object, GlobalVariable.shortDelay, FailureHandling.STOP_ON_FAILURE)
				break
			case FailureHandling.CONTINUE_ON_FAILURE:
				Mobile.verifyElementExist(object, GlobalVariable.shortDelay, FailureHandling.CONTINUE_ON_FAILURE)
				break
			case FailureHandling.OPTIONAL:
				Mobile.verifyElementExist(object, GlobalVariable.shortDelay, OPTIONAL)
				break
			default:
				throw new AssertException("Failure Handling Error")
		}
	}
	
	
	protected void info (String message) {
		KeywordUtil.logInfo(message)
	}

	protected void pass (String message) {
		KeywordUtil.markPassed(message)
	}
	
	protected void handleError (String message, FailureHandling flowControl) {
		switch(flowControl){
			case FailureHandling.STOP_ON_FAILURE:
				KeywordUtil.markFailedAndStop(message)
				break
			case FailureHandling.CONTINUE_ON_FAILURE:
				KeywordUtil.markFailed(message)
				break
			case FailureHandling.OPTIONAL:
				KeywordUtil.markWarning (message)
				break
			default:
				throw new AssertException(message)
		}
	}

	protected void handleErrorException (Exception ex, FailureHandling flowControl) {
		handleError(ex.message, flowControl)
	}
	
	protected void hideKeyboard () {
		Mobile.hideKeyboard()
	}

	
}
