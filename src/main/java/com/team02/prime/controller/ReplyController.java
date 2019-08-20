package com.team02.prime.controller;

import com.sun.javafx.collections.MappingChange;
import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.BoardService;
import com.team02.prime.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/restBoard")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private BoardService boardService;

    @PostMapping("/getReplyList")
    public List<ReplyVO> listReply(@RequestParam("board_num") int board_num) {

        return replyService.getReplyList(board_num);

    }

    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)

    public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) {
        

        Map<String, Object> result = new HashMap<>();

        try {
            replyService.saveReply(replyVO);
            result.put("status", "OK");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "Fail");
        }
        return result;
    }

}
