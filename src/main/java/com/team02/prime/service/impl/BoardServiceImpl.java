package com.team02.prime.service.impl;

import com.team02.prime.mapper.BoardMapper;
import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;
import com.team02.prime.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardVO boardVO) {
        this.boardMapper.insertBoard(boardVO);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        this.boardMapper.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(HttpServletRequest request, int board_num) {

        /*
        // session을 통해 사용자 인증정보 조회
        MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");

        // 해당 게시물 조회하여 등록된 사용자의 삭제 요청인지 비교
        BoardVO board = this.boardMapper.selectBoard(qna_no);
        if(board.getM_no() == memberVO.getM_no()){
            this.boardMapper.deleteBoard(qna_no);
        }
        */

        this.boardMapper.deleteBoard(board_num);

    }

    @Override
    public BoardVO selectBoard(int board_num) {
        return this.boardMapper.selectBoard(board_num);
    }

    @Override
    public Map<String,Object> selectBoardList(BoardPaging boardPaging) {

        Map<String,Object> map = new HashMap<>();

        /**
         * 처음 진입한 경우 currentPage 등 초기화 해줍니다.
         */
        if(boardPaging.getCurrentPage()==0){
            boardPaging.setCurrentPage(1); // 1page 부터 조회
            boardPaging.setArticleCount(20); // 페이지당 게시물 갯수
        }

        boardPaging.setTotalCount(this.boardMapper.selectBoardListCount(boardPaging));

        map.put("boardPaging", boardPaging);
        map.put("boardList", this.boardMapper.selectBoardList(boardPaging));
        System.out.println("********************************" +this.boardMapper.selectBoardList(boardPaging) );

        return map;
    }
}
