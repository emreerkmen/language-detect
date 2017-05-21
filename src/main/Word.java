package main;

public class Word {

	private String content = null;
	private int count = 1;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Word(String content) {
		this.content = content;
	}

}
