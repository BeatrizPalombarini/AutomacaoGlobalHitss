package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	@Before
	public void beforeScenario() {
		// Antes de iniciar a execução dos cenários
		inicializarDriver();
	}

	@After
	public void afterScenario() {
		// Depois da execução dos cenários
		finalizarDriver();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		// Ao finalizar cada step, será obtido um screenshoot da tela.
		File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", "screenshot");

	}

}
