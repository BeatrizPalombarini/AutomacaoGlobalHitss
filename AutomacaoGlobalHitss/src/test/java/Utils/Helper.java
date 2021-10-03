package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Helper é uma classe utilizada para criação de funções personalidads com apoio do selenium
public class Helper extends BaseTest {

	// Função utilizada para esperar o elemento ficar 'visivel' verificando o click
	public void waitForElement(WebElement el) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(el));
		} catch (Exception e) {
			return;
		}
		try {
			scrollToElement(el);
			Thread.sleep(500); // Para visualizar completamente (Screenshoot)
		} catch (Exception e) {

		}
	}

	// Esperar por um Elemento com inserção de tempo através do parametro
	public void waitForElement(WebElement el, int tempo) {

		WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(el));
		} catch (Exception e) {
			return;
		}
		try {
			Thread.sleep(1000); // Para visualizar completamente (Screenshoot)
		} catch (Exception e) {

		}
	}

	// Esperar um Elemento desaparecer da tela
	public void waitForElementIsInvisible(WebElement el) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		try {
			wait.until(ExpectedConditions.invisibilityOf(el));
		} catch (Exception e) {
			return;
		}
	}

	// Função que executa Javascript no driver
	public void executorJS_Click(WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", el);
		js.executeScript("arguments[0].click();");

	}

	// Função que move o scroll da página até o elemento
	public void scrollToElement(WebElement el) {
		Actions act = new Actions(getDriver());
		act.moveToElement(el);
		act.perform();
	}

}
