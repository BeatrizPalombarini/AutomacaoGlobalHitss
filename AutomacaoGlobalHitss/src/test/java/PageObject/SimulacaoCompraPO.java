package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Helper;

public class SimulacaoCompraPO extends Helper {

	// Elementos da pagina

	@FindBy(xpath = "//div[@id='header-middle']")
	@CacheLookup
	private WebElement logooPagina;
	
	@FindBy(xpath = "//div[@class='src__ProductInfo-sc-1gt98wm-5 fEnHYp']")
	@CacheLookup
	private WebElement paginaProduto;
	
	@FindBy(xpath = "//input[@id='h_search-input']")
	@CacheLookup
	private WebElement barraPesquisa;
	
	@FindBy(xpath = "//div//a[@class='src__ButtonUI-sc-1cpjf6b-3 fGAKbL']")
	@CacheLookup
	private WebElement btnComprar;
	
	@FindBy(xpath = "//div//input[@name='zipCode']")
	@CacheLookup
	private WebElement inputCEP;
	
	@FindBy(xpath = "//div//button[@class='sc-eggNIi sc-cTkwdZ JiLrb cxSJdc sc-dxeGpQ jQwnGb sc-dxeGpQ jQwnGb']")
	@CacheLookup
	private WebElement btnOkCEP;
	
	@FindBy(xpath = "//div[@class='sc-kVmgbL llQhLd']")
	@CacheLookup
	private WebElement boxValorEFrete;
	
	@FindBy(xpath = "//div//article[@class='sc-dcwrBW product-list-basketcontainer__BasketLineWrapper-sc-1jorwx1-0 vDTBn fPViZd']")
	@CacheLookup
	private WebElement produtoNoCarrinho;
	
	@FindBy(xpath = "//label[contains(text(),'Frete')]")
	@CacheLookup
	private WebElement nomeFrete;
	
	@FindBy(xpath = "(//span[@class='sc-hWRnYy hAnkOI'])[2]")
	@CacheLookup
	private WebElement valorFrete;
	
	@FindBy(xpath = "//label[contains(text(),'Produto')]")
	@CacheLookup
	private WebElement nomeProduto;
	
	@FindBy(xpath = "(//span[@class='sc-hWRnYy hAnkOI'])[1]")
	@CacheLookup
	private WebElement valorProduto;
	
	@FindBy(xpath = "//span//b[@class='--ignore-case']")
	@CacheLookup
	private WebElement valorTotal;
			
	private WebDriver driver;

	public SimulacaoCompraPO() {
		//Inicializar elementos através do driver
		driver = getDriver();
		PageFactory.initElements(driver, this);
	}

	
	public boolean checkLogoPagina() {
		waitForElement(logooPagina);
		return logooPagina.isDisplayed();
	}
	
	public void escolherProduto(String numero) {
		int numero1 = Integer.parseInt(numero);
		WebElement elemento = driver.findElement(By.xpath("//div[@class='col__StyledCol-sc-1snw5v3-0 epVkvq src__ColGridItem-cyp7mw-0 bOuwzj']["+numero1+"]"));
		waitForElement(elemento);
		elemento.click();
	}
	
	public boolean escolherProdutocheck(String numero) {
		int numero1 = Integer.parseInt(numero);
		WebElement elemento = driver.findElement(By.xpath("//div[@class='col__StyledCol-sc-1snw5v3-0 epVkvq src__ColGridItem-cyp7mw-0 bOuwzj']["+ numero1 +"]"));
		waitForElement(elemento);
		return elemento.isDisplayed();
	}
	
	public void pesquisarProduto(String produto) throws InterruptedException {
		waitForElement(barraPesquisa);
		barraPesquisa.click();
		barraPesquisa.clear();
		barraPesquisa.sendKeys(produto);
		wait(1000,1);
	}
	
	public boolean pesquisarProdutoCheck(String produto) {
		waitForElement(barraPesquisa);
		return barraPesquisa.isDisplayed();
	}
	
	public boolean paginaProdutoCheck() {
		waitForElement(paginaProduto);
		return paginaProduto.isDisplayed();
	}
	
	
	public boolean comprarProdutoCheck() {
		waitForElement(btnComprar);
		return btnComprar.isDisplayed();
	}
	
	public void comprarProduto() {
		waitForElement(btnComprar);
		btnComprar.click();
	}
	
	public boolean produtoNoCarrinhoCheck() {
		waitForElement(produtoNoCarrinho);
		return produtoNoCarrinho.isDisplayed();
	}
	
	public boolean valorFreteCheck() {
		waitForElement(valorFrete);
		return valorFrete.isDisplayed();
	}
	
	public boolean cepCheck() {
		waitForElement(inputCEP);
		return inputCEP.isDisplayed();
	}
	
	public void cep(String cep) {
		waitForElement(inputCEP);
		inputCEP.click();
		inputCEP.clear();
		inputCEP.sendKeys(cep);
	}
}
