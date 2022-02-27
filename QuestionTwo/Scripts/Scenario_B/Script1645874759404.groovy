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

VerifyTypeData vtd = new VerifyTypeData()

// Verify Data Type Of Value Is String
vtd.verifyDataIsString("name", jsonString, "Verify Type Value Is String")
vtd.verifyDataIsString("courier", jsonString, "Verify Type Value Is String")

// Verify Data Type Of Value is Integer
vtd.verifyDataIsInteger("orderNumber", jsonString, "Verify Type Value Is Integer")
vtd.verifyDataIsInteger("total", jsonString, "Verify Type Value Is Integer")
vtd.verifyDataIsInteger("code", jsonString, "Verify Type Value Is Integer")

// Verify Data Type Is Object List
vtd.verifyDataIsList("product", jsonString, "Verify Type Of Object Data Is List")

// Verify Data Type In Object List Is String
vtd.verifyDataListIsString("product", "item", jsonString, "Verify Type Value In List Is String")

// Verify Data Type In Object List Is Integer
vtd.verifyDataListIsInteger("product", "price", jsonString, "Verify Type Value In List Is Integer")

// Verify Data Type Of Value is Boolean
vtd.verifyDataIsBoolean("success", jsonString, "Verify Type Value Is Boolean")