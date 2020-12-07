package com.iu.sb5.board.qna;

import java.util.List;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;

import lombok.Data;

@Data
public class QnaVO extends BoardVO {
	private long ref;
	private long step;
	private long dept;
	private List<FileVO> file;
}
