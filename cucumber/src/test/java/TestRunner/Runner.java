package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(features = {"src\\test\\java\\Features" }, 
	glue = {"Step_defination" ,"Hooks"}, 
			plugin = { "pretty", "json:./Reports/reports.json" },monochrome = true )

	public class Runner {	

}
