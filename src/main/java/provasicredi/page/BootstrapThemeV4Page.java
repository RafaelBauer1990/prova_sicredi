package provasicredi.page;

import org.openqa.selenium.WebDriver;

import provasicredi.dsl.DSL;

public class BootstrapThemeV4Page {

	private static DSL dsl; 
	
	public BootstrapThemeV4Page(WebDriver driver) {
		dsl = new DSL(driver);
	}
	public void clicaAddCustomer() {
		dsl.clicaElementoByXpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a");
	}
	public void pesquisaPelaLupa(String text) {
		dsl.clicaElementoByXpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/i");
		dsl.pesquisaByXpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input", text);	
	}
	public void selecionaTodoResultadoPesquisa() throws InterruptedException {
		dsl.espera();
		dsl.clicaElementoJavaScriptByCSSselector("#gcrud-search-form > div.scroll-if-required > table > thead > tr.filter-row.gc-search-row > td.no-border-right > div > input");
		dsl.espera();
	}
	public void deletaRegistrosSelecionados(){
		dsl.clicaElementoByXpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a/span");
	}
	public String mensagemConfirmaDelete() {
		return dsl.aguardaVisibilidadeDoElementoByXpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]");		
	}
	public void confirmaDelete(){
		dsl.clicaElementoByXpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");
	}
	public String mensagemSucessoDelete() {
		return dsl.aguardaVisibilidadeDoElementoByXpath("/html/body/div[3]/span[3]/p");		
	}
}
