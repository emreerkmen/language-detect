package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.CreaterUri;

public class CreaterUriTest {

	@Test
	public void enCodeUrl() {

		String expected = "https://tr.wikipedia.org/wiki/T%C3%BCrkiye";
		String actual = new CreaterUri().encodeUrl("Tukiye");
		System.out.println(expected);
		System.out.println(actual);
		assertTrue("New uri couldn!t created.", expected.equals(actual));

	}

}
