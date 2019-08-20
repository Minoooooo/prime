package com.team02.prime.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {
    private int reply_num;
    private String comment;
    private int user_number;
    private int board_num;
    private Date register_date;
//    private String id;
    private String reply_id;


}
