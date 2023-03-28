package com.hm.restapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.hm.restapi.service.BoardService;
import com.hm.restapi.model.Board;

@RestController
public class BoardController {
	@Autowired
    BoardService boardService;

	/**
	 * 게시판 목록 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/board_nmk", produces = "application/json")
    public Map<String, Object> listBoard() throws Exception {
        return boardService.getBoardList();
    }
	
	/**
	 * 게시판 등록 
	 * @param baordDto
	 * @return
	 * @throws Exception
	 */
	 @PostMapping(value = "/board_nmk", produces = "application/json")
	 public Map<String, Object> registBoard(Board baord_nmk) throws Exception {
	      return boardService.registBoard(baord_nmk);
	  }
	 
	 /**
		 * 게시판 조회 
		 * @param seq
		 * @return
		 * @throws Exception
		 */
		@GetMapping(value = "/board_nmk/{seq}", produces = "application/json")
	    public Map<String, Object> getBoard(@PathVariable("seq") int seq) throws Exception {
	        return boardService.getBoard(seq);
	    }
		
	/**
	     * 게시판 수정 
	     * @param baordDto
	     * @return
	     * @throws Exception
	     */
	    @PutMapping(value = "/board_nmk", produces = "application/json")
	    public Map<String, Object> modifyBoard(Board baord_nmk) throws Exception {
	        return boardService.modifyBoard(baord_nmk);
	    }
	    
	 /**
	     * 게시판 삭제 
	     * @param seq
	     * @return
	     * @throws Exception
	     */
	    @DeleteMapping(value = "/board_nmk/{seq}", produces = "application/json")
	    public Map<String, Object> deleteBoard(@PathVariable("seq") int seq) throws Exception {
	        return boardService.deleteBoard(seq);
	    }
}
