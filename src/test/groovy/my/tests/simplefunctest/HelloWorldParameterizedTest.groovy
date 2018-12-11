package my.tests.simplefunctest

import geb.junit4.GebTest

import java.util.Collection

import org.junit.AfterClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.chrome.ChromeDriver

@RunWith(Parameterized)
class HelloWorldParameterizedTest extends GebTest {
	@Parameters
	public static Collection<Object[]> parameters() {

		WebDriver firefoxDriver = new FirefoxDriver()
		WebDriver internetExplorerDriver = new InternetExplorerDriver()
		WebDriver htmlUnitDriver = new HtmlUnitDriver()
		WebDriver chromeDriver = new ChromeDriver()

		drivers.add(firefoxDriver)
		drivers.add(internetExplorerDriver)
		drivers.add(htmlUnitDriver)
		drivers.add(chromeDriver)

		return [
				[firefoxDriver, "http://www.google.fr/", "en", "Google Images"] as Object[],
				[internetExplorerDriver, "http://www.google.co.uk/", "fi", "Google-kuvat"] as Object[],
				[htmlUnitDriver, "http://www.google.de/", "sv", "Google Bilder"] as Object[],
				[chromeDriver, "http://www.google.ch/", "ru", "Картинки Google"] as Object[],
		]
	}

	String getBaseUrl() {
		return baseUrl
	}

	WebDriver createDriver() {
		return webDriver
	}

	def static drivers = []

	String baseUrl;
	String language;
	String title;
	WebDriver webDriver;

	public HelloWorldParameterizedTest(WebDriver webDriver, String baseUrl, String language, String title) {
		this.webDriver = webDriver
		this.baseUrl = baseUrl
		this.language = language
		this.title = title
	}

	@Test
	void testGoogleImageLink() {
		go "imghp?hl=" + language + "&tab=wi"
		assert $ ("title").text () == title
	}

	@AfterClass
	public static void closeDrivers() {
		for (WebDriver driver: drivers) {
			driver.close()
		}
	}
}
