import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class VerifyTypeData extends Common {
	
	/*
	 * @param description is the verification info
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataIsInteger (String value, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def checkType = data.getAt(value)
			if (checkType.getClass() == Integer) {
				pass("True Data $value is Integer")
			} else {
				handleError("False Data $value is Not Integer", flowControl)
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}

	/*
	 * @param description is the verification info
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataIsString (String value, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def checkType = data.getAt(value)
			if (checkType.getClass() == String) {
				pass("True Data $value is String")
			} else {
				handleError("False Data $value is Not String", flowControl)
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}

	/*
	 * @param description is the verification info
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataIsBoolean (String value, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def checkType = data.getAt(value)
			if (checkType.getClass() == Boolean) {
				pass("True Data $value is Boolean")
			} else {
				handleError("False Data $value is Not Boolean", flowControl)
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}

	/*
	 * @param description is the verification info
	 * @param objectArray the object list in data api
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataIsList (String objectArray, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def checkType = data.getAt(objectArray)
			if (checkType.getClass() == ArrayList) {
				pass("True Data $objectArray is List")
			} else {
				handleError("False $objectArray is Not List", flowControl)
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}

	/*
	 * @param description is the verification info
	 * @param objectArray the object list in data api
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataListIsString (String objectArray, String value, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def getValue =  data.getAt(objectArray).getAt(value)
			for (def type : getValue) {
				System.out.println(type)
				System.out.println(type.getClass())

				if (type.getClass() != String) {
					handleError("False $value In List Object $objectArray is Not String", flowControl)
				} else {
					pass("True $value In List Object $objectArray is String")
				}
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}

	/*
	 * @param description is the verification info
	 * @param objectArray the object list in data api
	 * @param String value the value of the key in data api
	 * @param String json the file json extension
	 */
	@Keyword
	public void verifyDataListIsInteger (String objectArray, String value, String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		def data = slurper.parseText(json)

		info (description)
		try {
			def getValue = data.getAt(objectArray).getAt(value)
			for (def type in getValue) {
				System.out.println(type)
				System.out.println(type.getClass())

				if (type.getClass() != Integer) {
					handleError("False $value In List Object $objectArray is Not Integer", flowControl)
				} else {
					pass("True $value In List Object $objectArray is Integer")
				}
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}
}
