package provasicredi.dsl;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private WebDriver driver;
	private WebElement element;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void driverQuit() {
		driver.quit();

	}
	public void acessaUrl(String url) {
		driver.get(url);
	}
	public void maximizaPagina() {
		driver.manage().window().maximize();
	}

	//Seleciona combo
	public void selecionaComboByVisibleText(String id, String text) {
		new Select(driver.findElement(By.id(id))).selectByVisibleText(text);
	}

	// clica no elemento

	public void clicaElementoByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clicaElementoById(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicaElementoBylinkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	public void clicaElementoJavaScriptByCSSselector(String cssSelector) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector( '" + cssSelector + " ').click()");
				
	}
	
	public void espera() throws InterruptedException {
		Thread.sleep(3000);
	}

	//Escreve no campo
	public void escreveNoCampoById(String id, String text) {
		driver.findElement(By.id(id)).sendKeys(text);
	}

	public void escreveNoCampoByXpath(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	public void pesquisaByXpath(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text, Keys.ENTER);
	}


	public String aguardaVisibilidadeDoElementoByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element.getText();

	}
}
