package main;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Extractor implements Runnable {
	private String content;
	private Document doc;
	private String uri;
	private ContentProcess parserListener;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyParser();
	}

	public void attachParser(ContentProcess processorLeader) {
		this.parserListener = processorLeader;
	}

	public void notifyParser() {
		parserListener.contentFetch(content);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Extractor(String uriSuffix, ContentProcess processorLeader) {
		attachParser(processorLeader);
		this.uri = new CreaterUri().encodeUrl(uriSuffix);
	}

	public String getUriContent(String uri) throws IOException {
		doc = Jsoup.connect(uri).get();
		String content = doc.select("mw-content-text").text();
		return content;
	}

	@Before
	public void before() throws Exception {
		uri = "https://tr.wikipedia.org/wiki/T%C3%BCrkler";
	}

	@After
	public void after() throws Exception {

	}

	@Test
	public void getCurrenUrlText() throws Exception {
		uri = "https://tr.wikipedia.org/wiki/T%C3%BCrkler";
		System.out.println(getUriContent(uri));
	}

	@Override
	public void run() {
		try {
			content = getUriContent(uri);
			notifyParser();
		} catch (IOException e) {
			Logger.getLogger(Extractor.class.getName()).log(Level.SEVERE, null, e);

		}
	}

}
