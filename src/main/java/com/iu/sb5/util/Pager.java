package com.iu.sb5.util;

import lombok.Data;

@Data
public class Pager {
	private long curPage;
	private long perPage; // 한페이지에 보여줄 글의 갯수
	
	private long startRow;
	
	private long startNum;
	private long lastNum;
	private boolean isBefore;
	private boolean isAfter;
	
	private String kind;
	private String search;
	
	public Pager() {
		this.perPage = 10;
	}
	
	public void setCurPage(long curPage) {
		if(curPage == 0) {
			this.curPage=1;
		}else {
			this.curPage=curPage;
		}
	}
	
	public long getCurPage() {
		if(this.curPage==0) {
			this.curPage=1;
		}
		return this.curPage;
	}
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return this.search;
	}
	
	public void makeRow() {
		startRow = ((this.getCurPage()-1) * perPage);
	}
	
	public void makePage(long totalCount) {
		//전체 페이지의 갯수
		long totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		//전체 block 수 구하기
		long perBlock = 5;
		long totalBlock = totalPage / perBlock;
		if(totalCount % perBlock != 0) {
			totalBlock++;
		}
		
		//curPage를 이용해서 curBlock 구하기
		long curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage() % perBlock != 0) {
			curBlock++;
		}
		
		//curBlock를 이용해서 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*perBlock + 1;
		this.lastNum = (curBlock) * perBlock;
		
		
		//curBlock이 마지막Block(totalBlock) 일떄 lastNum 수정
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		if(curBlock > 1) {
			this.isBefore = true;
		}
		
		if(curBlock < totalBlock) {
			this.isAfter = true;
		}
		
		System.out.println("startNum : " + this.getStartNum());
		System.out.println("LastNum : " + this.getLastNum());
		System.out.println("IsBefore : " + this.isBefore());
		System.out.println("IsAfter : " + this.isAfter());
	}
}
