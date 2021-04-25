package com.qa.runner.assessment;

import Bootcamp.PageObjectModel.baseClass.Base_class;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/com/qa/feature/assessment/assessment.feature",
glue="com.qa.stepdef.assessment",
dryRun=false,
monochrome=true)
public class RunnerAssessment extends Base_class 
{

	
	
	
}
