package steps;

import org.junit.Assert;

import PageObject.SimulaçaoPO;
import Utils.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;


public class SimulacaoSteps extends BaseTest{

	// Page Objects
	SimulaçaoPO simulacao = new SimulaçaoPO();

	@Dado("que eu acesse o site")
	public void que_eu_acesse_o_site() {
		irPara("http://sampleapp.tricentis.com/101/app.php");
	}
	
	@Então("sera validado o acesso")
	public void sera_validado_o_acesso() {
		Assert.assertTrue("Falha ao tentar visualizar o título da página.", simulacao.checkLogoPagina());
	}
}
