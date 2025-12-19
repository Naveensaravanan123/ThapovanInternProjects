package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By btn_search = By.xpath("//button[@class=\"kV1UjG\"]");
	By text_search = By.xpath("//input[@name=\"q\"]");
	
	By txt_MoveToProduct = By.xpath("//div[text()=\"Apple iPhone 17 Pro (Cosmic Orange, 1 TB)\"]");
	
//	By txt_HighlightsOfProduct = By.className("//li[@class=\\\"LS5qY1\\\"]");
	
	By btn_addToCart = By.xpath("//button[text()=\"Add to cart\"]");
	
	
	
	
	
	public void search_btn(){
		driver.findElement(btn_search).click();
	}
	public void search_TextField(String product_search){
		driver.findElement(text_search).sendKeys(product_search);
	}
	public void select_product(){
		driver.findElement(txt_MoveToProduct).click();
	}
	
	public void cart_btn(){
		driver.findElement(btn_addToCart).click();
	}


}
