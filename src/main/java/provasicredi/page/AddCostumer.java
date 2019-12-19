package provasicredi.page;

import org.openqa.selenium.WebDriver;

import provasicredi.dsl.DSL;

public class AddCostumer {
	
	private static DSL dsl; 
	
	public AddCostumer(WebDriver driver) {
		dsl = new DSL(driver);
	}
	public void setName(String text) {
		dsl.escreveNoCampoById("field-customerName", text);		
	}
	public void setLastName(String text) {
		dsl.escreveNoCampoById("field-contactLastName", text);		
	}
	public void setContactFirstName(String text) {
		dsl.escreveNoCampoById("field-contactFirstName", text);		
	}
	public void setPhone(String text) {
		dsl.escreveNoCampoById("field-phone", text);		
	}
	public void setAddressLine1(String text) {
		dsl.escreveNoCampoById("field-addressLine1", text);		
	}
	public void setAddressLine2(String text) {
		dsl.escreveNoCampoById("field-addressLine2", text);		
	}
	public void setCity(String text) {
		dsl.escreveNoCampoById("field-city", text);		
	}
	public void setState(String text) {
		dsl.escreveNoCampoById("field-state", text);		
	}
	public void setPostalCode(String text) {
		dsl.escreveNoCampoById("field-postalCode", text);		
	}
	public void setCountry(String text) {
		dsl.escreveNoCampoById("field-country", text);		
	}
	public void abreComboFromEmployeer() {
		dsl.clicaElementoByXpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span");		
	}
	public void selecionaFromEmployeerFixter() {
		dsl.clicaElementoByXpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li[8]");		
	}
	
	public void setCreditLimit(String text) {
		dsl.escreveNoCampoById("field-creditLimit", text);		
	}
	public void salvaCustomer() {
		dsl.clicaElementoById("form-button-save");
	}
	public String mensagemSucessoGravacao() {
		return dsl.aguardaVisibilidadeDoElementoByXpath("//*[@id=\"report-success\"]/p");		
	}
	public void retornaParaListaDeCustomer() {
		dsl.clicaElementoBylinkText("Go back to list");		
	}

}
