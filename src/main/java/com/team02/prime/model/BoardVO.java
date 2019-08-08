package com.team02.prime.model;


import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    private int board_num;
    private String board_title;
    private String board_password;
    private Date board_register_date;
    private String board_content;
    private int board_view_cnt;
    private int user_number;
    private String id;
    private String name;


}
