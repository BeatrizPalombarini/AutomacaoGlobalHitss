package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	// Variaveis onde vou armazenar a instancia do driver
	private static WebDriver _driver;

	// Inicializando o Driver
	public static WebDriver getDriver() {
		// Passando via parametro onde está localizado o Driver de navegador que vou
		// utilizar, no caso ChromeDriver
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		// Verificando se o driver já foi instanciado.
		if (_driver == null) {
			// caso não, vai instanciar um novo objeto de driver
			_driver = new ChromeDriver();
			_driver.manage().window().setPosition(new Point(0, 0));
			_driver.manage().window().setSize(new Dimension(1900, 1080));
		}
		// caso tenha, ele apenas retorna
		return _driver;
	}

	//Função para inicializar a instancia driver
	public void inicializarDriver() {
		if (_driver == null)
			_driver = getDriver();
		return;
	}

	// Função utilizada para acessar endereços
	public static void irPara(String url) {
		_driver.get(url);
	}

	//Função para finalizar a instancia do driver
	public static void finalizarDriver() {
		_driver.close();
		_driver.quit();
		_driver = null;
	}

}
