package com.example.tests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class FHA1100 {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*iehta", "http://uamcepic.integra.integra-online.com/LOPortal/default.aspx");
		selenium.start();
	}

	@Test
	public void testRun() throws Exception {
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
		selenium.type("id=PrimaryBorrowerInfo_SocialSecurityNumberWebMaskEdit", "213211322");
		selenium.type("id=PrimaryBorrowerInfo_BorrowerName_FirstWebTextEdit", "Regression");
		String Date = selenium.getEval("var currentDate = new Date();var day = currentDate.getDate(); if (day < 10) { day = \"0\" + day }; var month = currentDate.getMonth() + 1; if (month < 10) { month = \"0\" + month };var year = currentDate.getFullYear(); curentDate=(day + \"/\" + month + \"/\" + year);");
		selenium.type("id=PrimaryBorrowerInfo_BorrowerName_LastWebTextEdit", "FHA" + Date);
		selenium.select("id=SubjectPropertyInfo_LoanPurposeWebDropDown", "label=Purchase Home");
		selenium.type("id=SubjectPropertyInfo_Address_ZipCodeWebMaskEdit", "97223");
		selenium.select("id=SubjectPropertyInfo_OccupancyWebDropDown", "label=Owner Occupied Property");
		selenium.select("id=SubjectPropertyInfo_PropertyTypeWebDropDown", "label=1 Family Dwelling");
		selenium.type("id=SubjectPropertyInfo_SalesPriceWebCurrencyEdit", "300000");
		selenium.type("id=BaseLoanAmountWebCurrencyEdit", "285000");
		selenium.click("id=CreditScoreCheckBox");
		selenium.type("id=CreditScoreWebNumericEdit", "750");
		selenium.click("id=EscrowsWaivedRadioButtonList_0");
		selenium.select("id=IntendedLoanTypeWebDropDown", "label=FHA");
		selenium.click("link=Underwriting Qualify");
		selenium.click("id=ProductLink");
		selenium.selectWindow("name=ProductSelection");
		selenium.click("id=ProductFilterAccordionPane_header");
		selenium.click("id=CategorizeProductsCheckBox");
		selenium.click("id=ProductListLabel");
		selenium.click("css=#ProductRow100-1100AApply > a");
		assertTrue(selenium.getConfirmation().matches("^Are you sure you want to assign this product to your loan[\\s\\S]$"));
		selenium.selectWindow("null");
		selenium.click("id=btnCancel");
		selenium.type("id=SalesPriceWebCurrencyEditor", "300000");
		selenium.type("id=AppraisedValueWebCurrencyEditor", "300000");
		selenium.type("id=BaseLoanWebCurrencyEditor", "285000");
		selenium.type("id=NoteRateWebPercentEditor", "4.2500");
		selenium.type("id=OriginationWPE", "0.75000");
		selenium.type("id=DiscountPointsWPE", "0.50000");
		verifyEquals("$1,426.57", selenium.getValue("id=FirstMortgageWebCurrencyEditor"));
		verifyEquals("$306.38", selenium.getValue("id=MortgageInsuranceWebCurrencyEditor"));
		verifyEquals("$375.00", selenium.getValue("id=RealEstateWebCurrencyEditor"));
		verifyEquals("$2,149.20", selenium.getValue("id=TotalAllMonthlyPaymentsWebCurrencyEditor"));
		verifyEquals("$-24,218.67", selenium.getValue("id=ReservesWebCurrencyEditor"));
		selenium.click("id=ClosingCostsButton");
		selenium.selectWindow("name=GoodFaithEstimate");
		verifyEquals("5.853%", selenium.getValue("id=CurrentAPREditor"));
		selenium.selectWindow("null");
		selenium.click("id=btnOkay");
		selenium.click("link=Exit Loan");
	}

	private void verifyEquals(String string, String value) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
