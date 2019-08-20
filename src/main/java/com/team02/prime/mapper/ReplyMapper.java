package com.team02.prime.mapper;


import com.team02.prime.model.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    // 댓글 개수
    public int countReply(int board_num);

    // 댓글 목록
    public List<ReplyVO> getReplyList(int board_num);

    // 댓글 입력
    public void saveReply(ReplyVO replyVO);

    // 댓글 수정
    public int updateReply(ReplyVO replyVO);

    // 댓글 삭제
    public int deleteReply(int reply_num);

}
