import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertEquals

import org.assertj.core.api.Assert
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

import groovy.json.JsonSlurper
import groovy.swing.impl.DefaultAction
import internal.GlobalVariable
import javassist.expr.Instanceof



public class TotalTransactionAssert extends Common {

	/*
	 * Get value of total transaction
	 * @param String json the file json extension
	 * @param description is the verification info
	 *
	 */
	@Keyword
	public getValueDataOfTotal (String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		Map m = slurper.parseText(json)

		info(description)
		try {
			def valueOfTotal = m.get("total")

			if (valueOfTotal == null) {
				handleError('Value of field total is null', flowControl)
			} else {
				//				System.out.println("valus is : " + valueOfTotal)
				pass("Get value of field total passed")
				return valueOfTotal
			}
		}catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}


	/*
	 * Sum total price product in transaction 
	 * @param String json the file json extension
	 * @param description is the verification info
	 */
	@Keyword
	public getTotalAmountPrice (String json, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		JsonSlurper slurper = new JsonSlurper()
		Map m = slurper.parseText(json)

		info(description)
		try {
			def sumTotalPrice = 0;
			def objPrice = m.get("product").getAt("price")

			System.out.println(objPrice)

			if (objPrice == null) {
				handleError("Data on object product is null", flowControl)
			} else {
				for (def totalPrice : objPrice) {
					sumTotalPrice += totalPrice
				}

				pass("Get value of sum total price passed")
				//			    System.out.println("total sum : " + sumTotalPrice)
				return sumTotalPrice
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}


	/*
	 * @param actual the value to be tested
	 * @param expected the value to be compared
	 * @param description is the verification info
	 */
	@Keyword
	public void isEqual (Integer actual, Integer expected, String description, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE) {
		info (description)

		try {
			if (actual != expected) {
				handleError("Value of actual : $actual is not equals with value of expected : $expected", flowControl)
			}else {
				pass("The Value $actual is same with $expected")
			}
		} catch (ex) {
			handleErrorException(ex, flowControl)
		}
	}
}
