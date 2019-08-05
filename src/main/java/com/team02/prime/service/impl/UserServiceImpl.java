package com.team02.prime.service.impl;

import com.team02.prime.mapper.UserMapper;
import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void insertUser(UserVO userVO) {
        this.userMapper.insertUser(userVO);
    }

    @Override
    public void updateUserInfo(UserVO userVO) {
        this.userMapper.updateUserInfo(userVO);
    }

    @Override
    public void deleteUser(HttpServletRequest request,int user_number) {

        //session을 통해 관리자 인증정보 조회
        UserVO userVO = (UserVO)request.getSession().getAttribute("userVo");


        UserVO user = this.userMapper.selectUser(user_number);

        if(user.getId() == userVO.getId()){
            this.userMapper.deleteUser(user_number);
        }


        this.userMapper.deleteUser(user_number);
    }
    @Override
    public void delete_b_User(HttpServletRequest request,int user_number){

        this.userMapper.delete_b_User(user_number);
    }

    @Override
    public UserVO selectUser(int user_number) {
        return this.userMapper.selectUser(user_number);
    }

    @Override
    public List<UserVO> selectUserList() {
        return this.userMapper.selectUserList();
    }
}
