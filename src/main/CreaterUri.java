package main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreaterUri {
	public static final String BASEURI = "https://tr.wikipedia.org/wiki/";

	public	String encodeUrl(String suffix) {
		String encodedURL = "";
		try {
			encodedURL = URLEncoder.encode(suffix, "UTF-8");
			// System.out.println("https://tr.wikipedia.org/wiki/" +
			// encodedURL);

		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(CreaterUri.class.getName()).log(Level.SEVERE, null, ex);
		}

		return BASEURI+encodedURL;
	}
}