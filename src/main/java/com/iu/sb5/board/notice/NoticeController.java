package com.iu.sb5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		fileVO = noticeService.getFile(fileVO);
		
		mv.addObject("fileVO", fileVO);
		mv.addObject("filePath", filePath);
		
		System.out.println(fileVO.getFileName());
		
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getOne(boardVO);
		mv.addObject("vo", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception{
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
		}
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardVO, files);
		mv.setViewName("redirect:./noticeList");
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		if(pager.getKind()== null) {
			pager.setKind("title");
		}
		if(pager.getSearch()== null) {
			pager.setSearch("");
		}
		List<BoardVO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
		
	}
}
