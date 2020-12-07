package com.iu.sb5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.notice.NoticeMapper;
import com.iu.sb5.board.qna.QnaMapper;
import com.iu.sb5.board.qna.QnaVO;
import com.iu.sb5.util.Pager;

@SpringBootTest
class NoticeTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Test
	void insertTest() throws Exception{
		for(int i = 1; i<= 100; i++){
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("title"+i);
			qnaVO.setWriter("writer" + i);
			qnaVO.setContents("contents"+i);
			int result = qnaMapper.setInsert(qnaVO);
		}
	}

}
