package com.example.tests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class ConvLoan {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*iehta", "http://uamcepic.integra.integra-online.com/LOPortal/default.aspx");
		selenium.start();
	}

	@Test
	public void testConv() throws Exception {
		selenium.open("/LOPortal/");
		assertEquals("Destiny Web", selenium.getTitle());
		selenium.type("id=UserName", "hla01");
		selenium.type("id=Password", "hla01");
		selenium.click("id=LoginButton");
		selenium.waitForPageToLoad("30000");
		selenium.setSpeed("7000");
		selenium.setMouseSpeed("0");
		selenium.click("CreateLoanButton");
		selenium.click("id=btnOkay");
		selenium.type("id=PrimaryBorrowerInfo_SocialSecurityNumberWebMaskEdit", "434234342");
		selenium.type("id=PrimaryBorrowerInfo_BorrowerName_FirstWebTextEdit", "Conv");
		String Date = selenium.getEval("var currentDate = new Date();var day = currentDate.getDate(); if (day < 10) { day = \"0\" + day }; var month = currentDate.getMonth() + 1; if (month < 10) { month = \"0\" + month };var year = currentDate.getFullYear(); curentDate=(day + \"/\" + month + \"/\" + year);");
		selenium.type("id=PrimaryBorrowerInfo_BorrowerName_LastWebTextEdit", "Test " + Date);
		selenium.select("id=SubjectPropertyInfo_LoanPurposeWebDropDown", "label=Purchase Home");
		selenium.type("id=SubjectPropertyInfo_Address_ZipCodeWebMaskEdit", "97223");
		selenium.select("id=SubjectPropertyInfo_OccupancyWebDropDown", "label=Owner Occupied Property");
		selenium.select("id=SubjectPropertyInfo_PropertyTypeWebDropDown", "label=1 Family Dwelling");
		selenium.type("id=SubjectPropertyInfo_SalesPriceWebCurrencyEdit", "300,000");
		selenium.type("id=SubjectPropertyInfo_AppraisedValueWebCurrencyEdit", "300,000");
		selenium.type("id=BaseLoanAmountWebCurrencyEdit", "285,000");
		selenium.click("id=CreditScoreCheckBox");
		selenium.type("id=CreditScoreWebNumericEdit", "750");
		selenium.click("id=EscrowsWaivedRadioButtonList_0");
		selenium.click("link=Underwriting Qualify");
		selenium.click("id=ProductLink");
		selenium.selectWindow("name=ProductSelection");
		selenium.click("id=ProductFilterAccordionPane_header");
		selenium.click("id=CategorizeProductsCheckBox");
		selenium.click("id=ProductListLabel");
		selenium.click("css=#ProductRow1600-2100AApply > a");
		assertTrue(selenium.getConfirmation().matches("^Are you sure you want to assign this product to your loan[\\s\\S]$"));
		selenium.selectWindow("null");
		selenium.click("id=btnCancel");
		selenium.type("id=SalesPriceWebCurrencyEditor", "300000");
		selenium.type("id=AppraisedValueWebCurrencyEditor", "300000");
		selenium.type("id=BaseLoanWebCurrencyEditor", "285000");
		selenium.type("id=NoteRateWebPercentEditor", "4.2500");
		selenium.type("id=OriginationWPE", "0.75000");
		selenium.type("id=DiscountPointsWPE", "0.50000");
		verifyEquals("95.000%", selenium.getValue("id=LTVWebPercentEditor"));
		verifyEquals("$1,402.03", selenium.getValue("id=FirstMortgageWebCurrencyEditor"));
		verifyEquals("$41.25", selenium.getValue("id=HazardInsuranceWebCurrencyEditor"));
		verifyEquals("$375.00", selenium.getValue("id=RealEstateWebCurrencyEditor"));
		verifyEquals("$418.00", selenium.getValue("id=MortgageInsuranceWebCurrencyEditor"));
		verifyEquals("$2,236.28", selenium.getValue("id=TotalPrimaryHousingExpenseWebCurrencyEditor"));
		verifyEquals("$2,236.28", selenium.getValue("id=TotalAllMonthlyPaymentsWebCurrencyEditor"));
		verifyEquals("$23,306.75", selenium.getValue("id=CashToCloseWebCurrencyEditor"));
		selenium.click("id=ClosingCostsButton");
		selenium.selectWindow("name=GoodFaithEstimate");
		selenium.click("id=EstimatedClosingDateWebDatePicker_PopupButton");
		selenium.click("id=EstimatedClosingDateWebDatePicker_CalenderBehaviorID_day_0_1");
		selenium.type("id=EstimatedClosingDateWebDatePicker", "12/01/2014");
		selenium.click("id=RecalculateButton");
		verifyEquals("5.578", selenium.getValue("id=CurrentAPREditor"));
		selenium.selectWindow("null");
		selenium.click("id=btnOkay");
		selenium.click("id=ExitLoan");
	}

	private void verifyEquals(String string, String value) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
