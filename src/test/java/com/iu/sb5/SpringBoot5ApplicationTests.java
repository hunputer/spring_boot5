package com.iu.sb5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb5.board.qna.QnaMapper;
import com.iu.sb5.board.qna.QnaVO;

@SpringBootTest
class SpringBoot5ApplicationTests {

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
