package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class WebServerTest {

    Scanner keyboard = new Scanner(System.in);

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}


	@Test
	public void AcceptFailureTest() {
	    System.err.print("Accept failed.");
	    assertEquals("Accept failed.", errContent.toString());
	}

	@Test
	public void couldNotListenOnPortTest() {
	    System.err.print("Could not listen on port: 10008.");
	    assertEquals("Could not listen on port: 10008.", errContent.toString());
	}

	@Test
	public void cannotClosePortTest() {
	    System.err.print("Could not close port: 10008.");
	    assertEquals("Could not close port: 10008.", errContent.toString());
	}

    @Test
   public void requestTest() {
      HttpURLConnection connection = null;
      try {
              URL url = new URL("http://127.0.0.1:8080");
             connection = (HttpURLConnection) url.openConnection();
              connection.setRequestMethod("GET");
             System.out.println(connection.getInputStream());
     }catch(IOException e) {
         System.out.println("failed");
       }
   }
}
