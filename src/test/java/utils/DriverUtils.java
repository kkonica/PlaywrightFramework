package utils;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public abstract class DriverUtils {


	private static PlaywrightFactory pf;
	private static Page page;

	public DriverUtils() {
		pf = new PlaywrightFactory();
	}

	public static Page createPage() {
		page = pf.initBrowser();
		PlaywrightAssertions.setDefaultAssertionTimeout(30000);
		return page;
	}
	public static Page getPage() {
		return page;
	}

}
