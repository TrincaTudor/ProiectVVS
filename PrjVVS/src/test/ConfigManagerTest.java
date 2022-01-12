package test;

import exceptions.UsedPortException;
import org.junit.Assert;
import org.junit.Test;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import src.ConfigManager;
import src.Configuration;

import static org.junit.Assert.assertEquals;

public class ConfigManagerTest {

	private ConfigManager configManager = new ConfigManager(new Configuration());

	@Test(expected = PortOutOfBoundException.class)
	public void setPortOutOfRangeTest() throws  PortOutOfBoundException, UsedPortException{
		configManager.setPort(66000);
	}

	@Test
	public void setCorrectPortTest() throws  PortOutOfBoundException, UsedPortException{
		configManager.setPort(80);
		assertEquals(80, configManager.getPort());
	}

	public void checkDefaultPort() throws  PortOutOfBoundException, UsedPortException{
		assertEquals(8080, configManager.getPort());
	}

	@Test(expected = GivenParameterNotExistingException.class)
	public void NotSupportedPageDoesNotExistTest() throws GivenParameterNotExistingException{
		configManager.setNotSuportedPage("not_supportedd.html");
	}
	@Test
	public void NotSupportedPageDoesExistTest() throws GivenParameterNotExistingException{
		configManager.setNotSuportedPage("not_supported.html");
		Assert.assertEquals("not_supported.html", configManager.getNotSuportedPage());
	}

	@Test(expected = GivenParameterNotExistingException.class)
	public void webRootDoesNotExistTest() throws GivenParameterNotExistingException{
		configManager.setWebRootFile("wwww");
	}

	@Test(expected = GivenParameterNotExistingException.class)
	public void indexDoesNotExistTest() throws GivenParameterNotExistingException{
		configManager.setDefaultPage("indexx.html");
	}
	@Test
	public void indexDoesExistTest() throws GivenParameterNotExistingException{
		configManager.setDefaultPage("index.html");
		Assert.assertEquals("index.html", configManager.getDefaultPage());
	}

	@Test(expected = GivenParameterNotExistingException.class)
	public void notFoundPageDoesNotExistTest() throws GivenParameterNotExistingException{
		configManager.setFileNotFoundPage("4044.html");
	}
	@Test
	public void NotFOundPageDoesExistTest() throws GivenParameterNotExistingException{
		configManager.setFileNotFoundPage("404.html");
		Assert.assertEquals("404.html", configManager.getNotFoundPage());
	}

}
