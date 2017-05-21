package main;

import java.util.ArrayList;
import java.util.List;

public class ContentProcess {
	private String nameOfLanguage;
	private String content;
	private int callCount = 0;
	private ProcessorLeader caller;
	private List<Word> wordList = new ArrayList<Word>();

	public ContentProcess(ProcessorLeader caller, String language) {
		this.caller = caller;
		this.nameOfLanguage = language;
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void parse() {
		String[] contentArray = content.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
		for (String string : contentArray) {
			boolean isFind = false;
			for (Word word : wordList) {
				if (word.getContent().equals(string)) {
					word.setCount(word.getCount() + 1);
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				wordList.add(new Word(string));

			}
		}
	}

	public void contentFetch(String content) {
		this.content += content;
		callCount++;
		if (callCount == 10) {
			parse();
			caller.accesable(wordList, nameOfLanguage);
		}
	}

}
