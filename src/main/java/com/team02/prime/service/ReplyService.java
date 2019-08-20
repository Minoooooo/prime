package com.team02.prime.service;

import com.team02.prime.model.ReplyVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReplyService {

    void countReply(int board_num);

    /**
     * 댓글 등록
     * @param replyVO
     */
    void saveReply(ReplyVO replyVO);

    /**
     * 댓글 수정
     * @param replyVO
     */
    void updateReply(ReplyVO replyVO);

    /**
     * 댓글 삭제
     * @param reply_num
     */
    void deleteReply(HttpServletRequest request, int reply_num);


    /**
     * 댓글목록
     * @param board_num
     * @return
     */
    List<ReplyVO> getReplyList(int board_num);




}
