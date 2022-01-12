package src;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;

import java.io.File;

public class ConfigManager {
	private Configuration config;

	public ConfigManager(Configuration config) {
		this.config = config;
	}

	public File getWebRootFile(){
		return config.getWebRootFile();
	}
	
	
	public void setWebRootFile(String webRootName) throws GivenParameterNotExistingException {

		File tempFile = new File("./www/" + webRootName);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException();
		}
		config.setWebRootFile(tempFile);
	}

	public String getDefaultPage(){
		return config.getDefaultPage();
	}
	public void setDefaultPage(String defaultFile) throws GivenParameterNotExistingException {
		File tempFile = new File("./www/" + defaultFile);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException();
		}
		config.setDefaultPage(defaultFile);
	}
	public String getNotFoundPage(){
		return config.getNotFoundPage();
	}
	public void setFileNotFoundPage(String fileNotFound) throws GivenParameterNotExistingException {
		File tempFile = new File("./www/" + fileNotFound);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException();
		}
		config.setFileNotFoundPage(fileNotFound);
	}
	public String getNotSuportedPage(){
		return config.getNotSuportedPage();
	}
	public void setNotSuportedPage(String methodNotSupported) throws GivenParameterNotExistingException {
		File tempFile = new File("./www/" + methodNotSupported);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException();
		}
		config.setFileNotFoundPage(methodNotSupported);
	}

	public int getPort(){
		return config.getPort();
	}
	
	public String getState() {
		return config.getState();
	}
	
	public void setState(String state) {
		config.setState(state);
	}
	
	public boolean setPort(int portNumber) throws PortOutOfBoundException, UsedPortException {
		if(portNumber < 0 || portNumber > 65535) {
			throw new PortOutOfBoundException();
		}
		config.setPort(portNumber);
		return true;	
	}
}
