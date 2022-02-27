package utility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windowsimport
import internal.GlobalVariable


public class Utilities {

	@Keyword
	static void launchApp() {
		if (GlobalVariable.envy == 'dev') {
			launchAppDev()
		}else {
			launchAppProd()
		}
	}

	@Keyword
	static launchAppDev () {

		String startApp = RunConfiguration.getProjectDir() + GlobalVariable.appDev

		Mobile.startApplication(startApp, true, FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(GlobalVariable.shortDelay)
	}


	@Keyword
	static launchAppProd () {
		String startApp = RunConfiguration.getProjectDir() + GlobalVariable.appProd

		Mobile.startApplication(startApp, true, FailureHandling.STOP_ON_FAILURE)
		Mobile.delay(GlobalVariable.shortDelay)
	}
}


