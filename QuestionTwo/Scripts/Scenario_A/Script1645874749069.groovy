import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


String jsonString = '''
	{
	  "name": "sidik hadiwijaya",
	  "orderNumber": "76542019",
	  "courier": "JNE",
	  "product": [
	    {
	      "item": "laptop asus",
	      "price": 12000000
	    },
	    {
	      "item": "laptop asus",
	      "price": 10000000
	    },
	    {
	      "item": "laptop asus",
	      "price": 30000000
	    }
	  ],
	  "total": 20000000,
	  "code": 200,
	  "success": true
	}
'''

/*
 * Run Question Number One
 */
TotalTransactionAssert ttassert = new TotalTransactionAssert()
Integer total = ttassert.getValueDataOfTotal(jsonString, 'Get First Value Of object total')
Integer sumTotalPrice =  ttassert.getTotalAmountPrice(jsonString, 'Get Sum Total Of Value price In Object product')

// Assert equals value of total with sumTotalPrice
ttassert.isEqual(total, sumTotalPrice, 'Verify If Value Are Equals')


