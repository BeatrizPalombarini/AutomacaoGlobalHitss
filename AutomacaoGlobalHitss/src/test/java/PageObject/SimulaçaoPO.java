package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Helper;

public class SimulaçaoPO extends Helper {

	// Elementos da pagina

	@FindBy(xpath = "//div[@class='container']//a[@id='branding']")
	@CacheLookup
	private WebElement topoPagina;
		
	private WebDriver driver;

	public SimulaçaoPO() {
		//Inicializar elementos através do driver
		driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	//Checagem dos elementos
	public boolean checkLogoPagina() {
		waitForElement(topoPagina);
		return topoPagina.isDisplayed();
	}
	
}
