package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\RAMARAJU\\Cucumber\\src\\test\\resources\\Feature",
					glue="cucumber",
					dryRun=false,
					tags="@rr")
public class Runner {

}
