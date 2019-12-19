package provasicredi.test;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import provasicredi.dsl.DSL;
import provasicredi.page.AddCostumer;
import provasicredi.page.BootstrapThemePage;
import provasicredi.page.BootstrapThemeV4Page;


public class ProvaSicredi {

	private static DSL dsl; 
	private static BootstrapThemePage bootstrapTheme;
	private static BootstrapThemeV4Page bootstrapThemeV4;
	private static AddCostumer addCostumer;
	private static String url = "https://www.grocerycrud.com/demo/bootstrap_theme";
	
	@BeforeAll
	public static void setup() {

		chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		dsl = new DSL(driver);
		bootstrapTheme = new BootstrapThemePage(driver);
		bootstrapThemeV4 = new BootstrapThemeV4Page(driver);
		addCostumer = new AddCostumer(driver);

	}

	@AfterEach
	public void driverQuit() {
		dsl.driverQuit();

	}

	@Test
	public void validaInclusaoExclusaoDeCliente() throws InterruptedException{
		
		//Acesse a p�gina https://www.grocerycrud.com/demo/bootstrap_theme
		bootstrapTheme.maximizaPagina();
		bootstrapTheme.acessaPagina(url);
		
		//Mude o valor da combo Select version para "Bootstrap V4 Theme"
		bootstrapTheme.selecionaCombo("Bootstrap V4 Theme" );
		
		//Clique no bot�o Add Customer
		bootstrapThemeV4.clicaAddCustomer();

		// Preencha os campos do formul�rio com as seguintes informa��es
		addCostumer.setName("Teste Sicredi");
		addCostumer.setLastName("Teste");
		addCostumer.setContactFirstName("seu nome");
		addCostumer.setPhone("51 9999-9999");
		addCostumer.setAddressLine1("Av Assis Brasil, 3970");
		addCostumer.setAddressLine2("Torre D");
		addCostumer.setCity("Porto Alegre");
		addCostumer.setState("RS");
		addCostumer.setPostalCode("91000-000");
		addCostumer.setCountry("Brasil");
		addCostumer.abreComboFromEmployeer();
		addCostumer.selecionaFromEmployeerFixter();
		addCostumer.setCreditLimit("200");
		
		//Clique no bot�o Save
		addCostumer.salvaCustomer();

		// Validar a mensagem "Your data has been successfully stored into the database." atrav�s de uma asser��o
		Assertions.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", addCostumer.mensagemSucessoGravacao());

		//		Desafio 2
		// Clique no link Go back to list
		addCostumer.retornaParaListaDeCustomer();

		// Clique no �cone da lupa (pesquisa) e digite o conte�do do Name (Teste Sicredi)
		bootstrapThemeV4.pesquisaPelaLupa("Teste Sicredi");

		// Clicar no checkbox abaixo da palavra Actions
		bootstrapThemeV4.selecionaTodoResultadoPesquisa();

		// Clicar no bot�o Delete
		bootstrapThemeV4.deletaRegistrosSelecionados();

		// Validar o texto "Are you sure that you want to delete this 1 item?" atrav�s de uma asser��o para a popup que ser� apresentada (Elemento n�o � do tipo alert)
		Assertions.assertEquals("Are you sure that you want to delete this 1 item?", bootstrapThemeV4.mensagemConfirmaDelete());
		
		//Clicar no bot�o Delete da popup
		bootstrapThemeV4.confirmaDelete();
		
		//Aparecer� uma mensagem dentro de um box verde na parte superior direito da tela. Adicione uma asser��o na mensagem "Your data has been successfully deleted from the database."
		Assertions.assertEquals("Your data has been successfully deleted from the database.", bootstrapThemeV4.mensagemSucessoDelete());
	}
}
