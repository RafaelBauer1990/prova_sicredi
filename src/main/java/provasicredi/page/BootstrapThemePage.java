package provasicredi.page;

import org.openqa.selenium.WebDriver;

import provasicredi.dsl.DSL;

public class BootstrapThemePage {

	private static DSL dsl;
	
	
	public BootstrapThemePage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	public void acessaPagina(String url) {
		dsl.acessaUrl(url);	
	}
	public void maximizaPagina() {
		dsl.maximizaPagina();
	}
	public void selecionaCombo(String text) {
		dsl.selecionaComboByVisibleText("switch-version-select", text);
	}

	
}
