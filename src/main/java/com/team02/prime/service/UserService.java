package com.team02.prime.service;

import com.team02.prime.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    UserVO login(UserVO userVO, HttpServletRequest request);

    /**
     *     회원가입_등록_확인후
     *    @param userVO
     */
    void insertUser(UserVO userVO);


    /**
     *     회원정보_수정
     *    @param userVO
     */
    void updateUserInfo(UserVO userVO);

    /**
     *     회원탈퇴
     *     @param user_number
     */
    void deleteUser(HttpServletRequest request,int user_number);

    /**
     *     가입전 회원 삭제
     *     @param user_number
     */
    void delete_b_User(HttpServletRequest request,int user_number);

    /**
     * 회원조회
     * @param user_number
     * @return
     */
    UserVO selectUser(int user_number);

    /**
     * 회원 목록 조회
     * @return
     */
    List<UserVO> selectUserList();

}
