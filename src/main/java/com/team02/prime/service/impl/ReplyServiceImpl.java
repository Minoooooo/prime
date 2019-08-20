package com.team02.prime.service.impl;

import com.team02.prime.mapper.ReplyMapper;
import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;


    @Override
    public void countReply(int board_num) {
        this.replyMapper.countReply(board_num);
    }

    @Override
    public void saveReply(ReplyVO replyVO) {
        this.replyMapper.saveReply(replyVO);
    }

    @Override
    public void updateReply(ReplyVO replyVO) {
        this.replyMapper.updateReply(replyVO);
    }

    @Override
    public void deleteReply(HttpServletRequest request, int reply_num) {
        this.replyMapper.deleteReply(reply_num);
    }

    @Override
    public List<ReplyVO> getReplyList(int board_num) {
        return this.replyMapper.getReplyList(board_num);
    }


}
