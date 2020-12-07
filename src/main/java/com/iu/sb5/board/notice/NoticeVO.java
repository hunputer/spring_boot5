package com.iu.sb5.board.notice;

import java.util.List;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;

import lombok.Data;

@Data
public class NoticeVO extends BoardVO {
	private List<FileVO> file;
}
