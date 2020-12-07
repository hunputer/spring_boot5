package com.iu.sb5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar= qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board","qna");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board","qna");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(QnaVO qnaVO, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(qnaVO, files);
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = qnaService.getOne(qnaVO); 
		mv.addObject("vo", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		return mv;
	}
}
