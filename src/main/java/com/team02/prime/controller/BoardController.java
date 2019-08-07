package com.team02.prime.controller;

import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;
import com.team02.prime.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    //    @RequestMapping(value = "/board/insert", method = RequestMethod.GET)
    @GetMapping("/board/insert")
    public String boardInsert(){

        return "board/insert";
    }

    @PostMapping("/board/insert")
    public String boardInsertExecute(Model model, @ModelAttribute BoardVO boardVO){

        log.debug("##### 게시물 등록 요청 처리 ####");
        log.debug(boardVO.toString());
        this.boardService.insertBoard(boardVO);

        log.debug("##### 게시물 등록 결과 ####");
        log.debug(boardVO.toString());

        boardVO = this.boardService.selectBoard(boardVO.getBoard_num());

        model.addAttribute("board", boardVO);

        return "board/insert_after";
    }


    @GetMapping("/board/view/{board_num}")
    public String boardView(Model model, @PathVariable int board_num){
        model.addAttribute("board", this.boardService.selectBoard(board_num));
        return "board/view";
    }

    @PostMapping("/board/delete/{board_num}")
    public String boardDelete(HttpServletRequest request, @PathVariable int board_num){
        this.boardService.deleteBoard(request, board_num);
        return "board/delete_after";
    }

    @GetMapping("/board/update/{board_num}")
    public String boardUpdate(Model model, @PathVariable int board_num){
        model.addAttribute("board", this.boardService.selectBoard(board_num));
        return "board/update";
    }

    @PostMapping("/board/update")
    public String boardUpdateExecute(Model model, @ModelAttribute BoardVO boardVO){
        this.boardService.updateBoard(boardVO);
        model.addAttribute("board", this.boardService.selectBoard(boardVO.getBoard_num()));
        return "board/insert_after";
    }

    @GetMapping("/board/list")
    public String boardList(Model model, @ModelAttribute BoardPaging boardPaging){
        model.addAllAttributes(this.boardService.selectBoardList(boardPaging));
        return "board/list";
    }

    @GetMapping("/postcode")
    public String postocde(){
        return "postcode";
    }
}
