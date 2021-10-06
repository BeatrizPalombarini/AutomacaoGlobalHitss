package steps;

import org.junit.Assert;

import PageObject.SimulacaoCompraPO;
import Utils.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class SimulacaoCompraSteps extends BaseTest {

	String endpoint = "";
	String endereco = "";
	Response response;
	String baseUrl = "";
	String cep = "";

	// Page Objects
	SimulacaoCompraPO simulacao = new SimulacaoCompraPO();

	@Dado("que eu acesse o site")
	public void que_eu_acesse_o_site() {
		irPara("https://www.submarino.com.br/");
	}

	@Entao("sera validado o acesso")
	public void sera_validado_o_acesso() {
		Assert.assertTrue("Falha ao tentar visualizar o título da página.", simulacao.checkLogoPagina());
	}

	@Dado("que tenha um endpoint {string}")
	public void que_tenha_um_endpoint(String _endpoint) {
		endpoint = _endpoint;
	}

	@Dado("tenha o endereco da rua {string}")
	public void tenha_o_endereço(String _endereco) {
		endereco = _endereco;
	}

	@Quando("for realizada uma requisicao {string}")
	public void for_realizada_uma_requisicao(String _baseUrl) {
		baseUrl = _baseUrl;

		// Definindo o endereço Final para a requisição
		String EnderecoFinal = _baseUrl + endpoint + endereco + "/json/";

		RestAssured.baseURI = EnderecoFinal;

		response = given().when().get("/").then().extract().response();

	}

	@Entao("devera retornar o status {string}")
	public void devera_retornar_o_status(String statuscode) {
		// Comparando retorno de status com status desejado na automacao.
		Assert.assertEquals(Integer.parseInt(statuscode), response.statusCode());
	}

	@Entao("devera retornar um CEP valido")
	public void devera_retornar_um_cep_valido() {
		String cepVerificacao = response.jsonPath().getString("cep[0]");
	}

	@Dado("que eu pesquise um produto {string}")
	public void que_eu_pesquise_um_produto(String produto) throws InterruptedException {
		Assert.assertTrue("Falha ao tentar pesquisar o Produto.", simulacao.pesquisarProdutoCheck(produto));
		simulacao.pesquisarProduto(produto);
	}

	@Quando("escolher o produto desejado {string}")
	public void escolher_o_produto_desejado(String produtoDesejado) {
		simulacao.escolherProduto(produtoDesejado);
	}

	@Quando("validar a página do produto")
	public void validar_a_página_do_produto() {
		Assert.assertTrue("Falha ao tentar visualizar a página do Produto.", simulacao.paginaProdutoCheck());
	}

	@Quando("adicionar o produto ao carrinho")
	public void adicionar_o_produto_ao_carrinho() {
		Assert.assertTrue("Falha ao tentar visualizar a página do Produto.", simulacao.comprarProdutoCheck());
		simulacao.comprarProduto();
		Assert.assertTrue("Falha ao tentar visualizar o Produto no carrinho.", simulacao.produtoNoCarrinhoCheck());
	}

	@Quando("realizar a busca de cep pelo endereco {string}")
	public void realizar_a_busca_de_cep_pelo_endereco(String endereco) {
		String EnderecoFinal = baseUrl + endpoint + endereco + "/json/";

		RestAssured.baseURI = EnderecoFinal;

		response = given().when().get("/").then().extract().response();
		cep = response.jsonPath().getString("cep[0]");
	}

	@Quando("inserir o CEP")
	public void inserir_o_cep() {
		Assert.assertTrue("Falha ao tentar visualizar o Produto no carrinho.", simulacao.cepCheck());
		simulacao.cep(cep);
	}

	@Entao("sera exibido o valor do frete")
	public void sera_exibido_o_valor_do_frete() {
		Assert.assertTrue("Falha ao tentar visualizar o Produto no carrinho.", simulacao.valorFreteCheck());
	}

	@Entao("devera dar erro ao escolher o produto pelo {string}")
	public void devera_dar_erro_ao_escolher_o_produto(String produtoDesejado) {
		Assert.assertFalse("Falha ao tentar visualizar o Produto.", simulacao.escolherProdutocheck(produtoDesejado));
	}

	@Entao("devera dar erro ao buscar o cep")
	public void devera_dar_erro_ao_buscar_pelo_cep() {
		Assert.assertNotEquals(200, response.statusCode());
	}
}
