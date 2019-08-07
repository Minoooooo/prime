package com.team02.prime.service;

import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BoardService {

    /**
     * 게시물 등록
     * @param boardVO
     */
    void insertBoard(BoardVO boardVO);

    /**
     * 게시물 수정
     * @param boardVO
     */
    void updateBoard(BoardVO boardVO);

    /**
     * 게시물 삭제
     * @param board_nubmer
     */
    void deleteBoard(HttpServletRequest request, int board_nubmer);

    /**
     * 게시물 조회
     * @param board_number
     * @return
     */
    BoardVO selectBoard(int board_number);

    /**
     * 게시물 목록 조회
     * @return
     */
    Map<String,Object> selectBoardList(BoardPaging boardPaging);
}
