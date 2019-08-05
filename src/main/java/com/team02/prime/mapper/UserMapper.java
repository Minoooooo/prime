package com.team02.prime.mapper;

import com.team02.prime.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /**
     *     회원가입_등록 전
     *    @param userVO
     */
    void insertUser_before(UserVO userVO);

    /**
     *     회원가입_등록 후
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
    void deleteUser(int user_number);

    /**
     *     가입전 회원삭제
     *     @param user_number
     */
    void delete_b_User(int user_number);

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
