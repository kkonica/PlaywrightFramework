package utils;


import com.microsoft.playwright.Page;

public abstract class DriverUtils {


	private static PlaywrightFactory pf;
	private static Page page;

	public DriverUtils() {
		pf = new PlaywrightFactory();
	}

	public static Page createPage() {
		page = pf.initBrowser();
		return page;
	}
	public static Page getPage() {
		return page;
	}

}
