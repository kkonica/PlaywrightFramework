package PageObjects;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	String searchInputBox = "id=twotabsearchtextbox";
	String searchButton = "id=nav-search-submit-button";

	public HomePage(Page page){

	this.page= page;
	}
	
	public void openUrl(){
		page.navigate("https://www.amazon.in/");
		System.out.println(page.title());
	  }

	  public void clickOnSearch(){
		  page.locator(searchInputBox).click();
	  }
	public void searchForItem(){
		page.fill(searchInputBox,"coffee mug");
		page.locator(searchButton).click();
	}
}
