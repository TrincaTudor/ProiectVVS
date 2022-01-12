package src;

import java.io.File;

public class Configuration {
    private File webRoot = new File("./www");
    private String defaultFile = "index.html";
    private String fileNotFound = "404.html";
    private String methodNotSupported = "not_supported.html";
    private String state;

    private int port = 8080;

    static boolean verbose = true;

    public int getPort(){
        return port;
    }
    
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    public void setPort(int port){
        this.port = port;
    }
    public File getWebRootFile(){
        return webRoot;
    }
    public void setWebRootFile(File webRoot){
        this.webRoot = webRoot;
    }
    public String getDefaultPage(){
        return defaultFile;
    }
    public void setDefaultPage(String defaultFile){
        this.defaultFile = defaultFile;
    }
    public String getNotFoundPage(){
        return fileNotFound;
    }
    public void setFileNotFoundPage(String fileNotFound){
        this.fileNotFound = fileNotFound;
    }
    public String getNotSuportedPage(){
        return methodNotSupported;
    }
    public void setNotSuportedPage(String methodNotSupported){
        this.methodNotSupported = methodNotSupported;
    }
}
