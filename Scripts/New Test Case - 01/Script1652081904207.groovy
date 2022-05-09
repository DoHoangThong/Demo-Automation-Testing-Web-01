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
// Mở trình duyệt
WebUI.openBrowser('')
// Điều hướng đến đường link
WebUI.navigateToUrl('https://translate.google.com/?hl=vi')
// Tap vào nút Tiếng Việt
WebUI.click(findTestObject('Object Repository/New Folder - 01/Page_Google Dch/span_Vit_VfPpkd-YVzG2b'))
// Vòng lặp tăng dần đến chiều dài trong data của file excel
for (def indexRow = 1; indexRow <= findTestData('New Test Data').getRowNumbers(); indexRow++) {
	// Nhập nội dung vào textbox
    WebUI.setText(findTestObject('Object Repository/New Folder - 01/Page_Google Dch/textarea_Vn bn ngun_er8xn'), findTestData(
            'New Test Data').getValue(1, indexRow))
	// Gáng biến "strActual" = data kểt quả mong đợi trong file excel
    strActual = findTestData('New Test Data').getValue(2, indexRow)
	// Xác thực đối tượng "Actual" có giá trị của "strActual" có bằng với kết quả mong muốn trong file excel không
    WebUI.verifyElementText(findTestObject('New Folder - 01/Page_Google Dch/Actual', [('Actual'):strActual]), findTestData('New Test Data').getValue(
            2, indexRow))
}

WebUI.closeBrowser()

