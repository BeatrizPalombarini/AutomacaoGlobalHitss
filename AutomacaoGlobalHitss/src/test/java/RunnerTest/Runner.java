package RunnerTest;

import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", // Pasta onde est�o localizadas as features
		glue = { "steps", "Utils" }, // Package onde est�o localizados os steps
		tags = "", // Para inserir apenas a tag que deseja testar
		plugin = { "pretty", "html:target/cucumber-html-report.html" }, 
		dryRun = false // Habilitar ou desabilitar Execu��o de testes
)

public class Runner {
	/* 
	 * Desenvolvido por Beatriz Palombarini
	 * Automação Tricentis
	 * 
	 */
	// Classe utilizada para executar os testes

}
