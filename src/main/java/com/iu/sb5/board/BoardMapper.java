package com.iu.sb5.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.Pager;

@Mapper
public interface BoardMapper {
	public int setInsert(BoardVO boardVO) throws Exception;
	
	//title, contents update
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public long getCount(Pager pager) throws Exception;
	
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;
}
