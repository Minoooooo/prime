package com.team02.prime.model;


import lombok.Data;

@Data
public class UserVO {
    private int user_number;
    private String id;
    private String passwd;
    private String name;
    private String gender;
    private String phonenumber;
    private String email;
    private String address;

}
