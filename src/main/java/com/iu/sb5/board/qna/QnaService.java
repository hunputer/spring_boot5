package com.iu.sb5.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.BoardService;
import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.FileManager;
import com.iu.sb5.util.FilePathGenerator;
import com.iu.sb5.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.qna.filePath}")
	private String filePath;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
		File file = filePathGenerator.getUseResourceLoader(filePath);
		int result = qnaMapper.setInsert(boardVO);
		result = qnaMapper.setRefUpdate(boardVO);
		
		for(MultipartFile f : files) {
			if(f.getSize() != 0) {
				String fileName = fileManager.saveFileCopy(f, file);
				FileVO fileVO = new FileVO();
				fileVO.setNum(boardVO.getNum());
				fileVO.setFileName(fileName);
				fileVO.setOriName(f.getOriginalFilename());
				qnaMapper.setInsertFile(fileVO);
			}
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return qnaMapper.getOne(boardVO);
	}
	
	public List<BoardVO> getList(Pager pager) throws Exception{
		if(pager.getKind() == null) {
			pager.setKind("title");
		}
		if(pager.getSearch() == null) {
			pager.setSearch("");
		}
		pager.makeRow();
		long totalCount = qnaMapper.getCount(pager);
		pager.makePage(totalCount);
		return qnaMapper.getList(pager);
	}
	
	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
