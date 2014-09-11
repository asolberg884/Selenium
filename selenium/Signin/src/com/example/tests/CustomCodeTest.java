package com.example.tests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class CustomCodeTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*iehta", "http://uamcepic.integra.integra-online.com/LOPortal/default.aspx");
		selenium.start();
	}

	@Test
	public void testCustomCode() throws Exception {
		selenium.captureScreenshotToString();
		selenium.open("/LOPortal/");
		assertEquals("Destiny Web", selenium.getTitle());
		selenium.type("id=UserName", "hla01");
		selenium.type("id=Password", "hla01");
		selenium.click("id=LoginButton");
		selenium.setSpeed("7000");
		selenium.setMouseSpeed("0");
		selenium.click("css=p.verticalText");
		selenium.click("css=#AccordionPane11_header > div");
		selenium.click("link=Custom Code Test");
		selenium.click("id=TestAllButton");
		Thread.sleep(15000);
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module0 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module2 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module1 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module3 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module4 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module5 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module6 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module7 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module8 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module9 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module10 > table > tbody > tr > td"));
		verifyEquals("Source file compiled successfully.", selenium.getText("css=#Module11 > table > tbody > tr > td"));
	}

	private void verifyEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}
	
	
		
    
		@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
		
		
		}

