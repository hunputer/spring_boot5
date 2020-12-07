package com.iu.sb5.board;

import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.Pager;

public interface BoardService {
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;
}
