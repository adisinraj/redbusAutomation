package com.redbus.listeners;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

public class IReporterImpl implements IReporter{

	static Logger LOGGER = Logger.getLogger(IReporterImpl.class);
	
	 /**
	   * Generate a report for the given suites into the specified output directory.
	   * xmlSuite, which is the list of suites mentioned in the testng XML being executed.

	   * suites, which contains the suite information after the test execution. This object contains all the information about the packages, classes, test methods, and their test execution results.

	   * outputDirectory, which contains the information of the output folder path, where the reports will be generated.
	   */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for(XmlSuite suite: xmlSuites) {
			LOGGER.info("Suite executed : "+suite.getName());
		}
		
		
		for (ISuite iSuite : suites) {
			LOGGER.info("Test Cases Executed : " +iSuite.getAllMethods().size());
		}
	}
}
