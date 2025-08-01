package com.mvc.board.vo;

public class BoardVO {
	private int num;	// 글 번호
	private String author;	// 글 작성자
	private String title;	// 글제목
	private String content;	// 글내용
	private int readcnt;	//글 조회수
	private String writeday;	// 글 작성일
	private String passwd;	// 비밀번호
	
	// 조건검색시 사용할 속송
	private String search;	// 검색대상
	private String keyword;	// 검색어
	
	public BoardVO() {	}

	public BoardVO(int num, String author, String title, String content, int readcnt, String writeday, String passwd) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
		this.passwd = passwd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", author=" + author + ", title=" + title + ", content=" + content + ", readcnt="
				+ readcnt + ", writeday=" + writeday + ", passwd=" + passwd + "]";
	}
}
