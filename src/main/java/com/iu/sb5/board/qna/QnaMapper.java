package com.iu.sb5.board.qna;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iu.sb5.board.BoardMapper;
import com.iu.sb5.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper {
	
	public int setRefUpdate(BoardVO boardVO) throws Exception;
}
