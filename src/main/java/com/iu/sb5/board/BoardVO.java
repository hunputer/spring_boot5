package com.iu.sb5.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	public long num;
	public String title;
	public String writer;
	public String contents;
	public Date regDate;
	public long hit;
}
