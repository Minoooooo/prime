package com.team02.prime.controller;

import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/restBoard")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/listReply")
    public List<ReplyVO> listReply(@RequestParam("board_num") int board_num) {
        return replyService.listReply(board_num);
    }

}
