package main;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProcessorLeader {
	private static final String TURCE = "TURCE";
	private static final String DEUTSCH = "Deutsch";
	private static final String ENGLISH = "English";
	List<String> suffixTurkce = new ArrayList<String>();
	List<String> suffixEnglish = new ArrayList<String>();
	List<String> suffixDeutsch = new ArrayList<String>();
	ContentProcess processorTurkce;
	ContentProcess processorEnglish;
	ContentProcess processorDeutsch;
	List<Word> TurkceList = null;
	List<Word> EnglishList = null;
	List<Word> DeutschList = null;

	public ProcessorLeader() {
		processorTurkce = new ContentProcess(this, TURCE);
		processorDeutsch = new ContentProcess(this, DEUTSCH);
		processorEnglish = new ContentProcess(this, ENGLISH);
	}

	public void accesable(List<Word> languageList, String language) {
		{
			if (language.equals(TURCE)) {
				this.TurkceList = languageList;
			} else if (language.equals(ENGLISH)) {
				this.EnglishList = languageList;
			} else {
				this.DeutschList = languageList;
			}
		}
	}

	public void execute() {
		startExtracter(suffixTurkce, processorTurkce);
		startExtracter(suffixEnglish, processorEnglish);
		startExtracter(suffixDeutsch, processorDeutsch);
	}

	private void startExtracter(List<String> uriSuffixList, ContentProcess languageProcessor) {
		for (String string : uriSuffixList) {
			Extractor extractorEmployee = new Extractor(string, languageProcessor);
			Thread worker = new Thread(extractorEmployee);
			worker.start();
		}
	}

	@Test
	public void testName() throws Exception {
		try {
			suffixTurkce.add("TURCE");
			startExtracter(suffixTurkce, processorTurkce);
			System.out.println(TurkceList.size());
			System.out.println(new CreaterUri().encodeUrl("Türkçe"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
