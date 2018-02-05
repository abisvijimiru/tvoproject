package com.tvo.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtils {
	private static Workbook ExcelWBook;
    private static Sheet ExcelWSheet;
	public static String sTestCaseID;
	public static String sTestCaseName;
	public static String sTestRunMode;
	public static String sTestCaseDes;
	public static String sBrowserName;
	public static String sUserName;
	public static String sPassword;
	public static String sExpResult;
	public static String sTestResult;
	static File inputWorkBook;
	public static Logger logger = Logger.getLogger("ExcelUtils");
	
	public static void setExcelFile(String inputfile) throws Exception {
		logger.info("Test Input File - "+inputfile);		
		PropertyConfigurator.configure("log4j.properties");
	    inputWorkBook = new File(inputfile);
		ExcelWBook = Workbook.getWorkbook(inputWorkBook);
		logger.info("Test Input Excel is Opened");
	}

	// This method is to read the test data from the Excel cell
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		Cell cell = null;
		ExcelWSheet = ExcelWBook.getSheet(0);
		try {

			cell = ExcelWSheet.getCell(ColNum, RowNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (cell.getContents());
	}

	public static void extractTestCaseInputs(int iTestcase) throws Exception {

			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.TestCaseId);
			sTestCaseName = ExcelUtils.getCellData(iTestcase, Constants.TestCaseName);
			sTestRunMode=ExcelUtils.getCellData(iTestcase, Constants.RunMode);
			sTestCaseDes = ExcelUtils.getCellData(iTestcase, Constants.TestCaseDes);
			sBrowserName = ExcelUtils.getCellData(iTestcase, Constants.Browser);
			sUserName = ExcelUtils.getCellData(iTestcase, Constants.UserName);
			sPassword = ExcelUtils.getCellData(iTestcase, Constants.Password); 
			sExpResult = ExcelUtils.getCellData(iTestcase, Constants.ExpResult); 
			sTestResult = ExcelUtils.getCellData(iTestcase, Constants.TestResult); 
			/* logger.info(sTestCaseID);
			logger.info(sTestCaseName);
			logger.info(sTestRunMode);
			logger.info(sTestCaseDes);
			logger.info(sBrowserName);
			logger.info(sUserName);
			logger.info(sPassword);
			logger.info(sExpResult); */			
	}
}
