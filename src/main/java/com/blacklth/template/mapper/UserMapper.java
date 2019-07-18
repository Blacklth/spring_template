package com.blacklth.template.mapper;

import com.blacklth.template.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/18 11:57
 * @description:
 */
@Component
public interface UserMapper {

    int insert(User record);

    User selectUser(Integer userId);

    List<User> selectUsers();

    @Delete("delete from user where user_id = #{userId}")
    int deleteUser(Integer userId);

    @Update("update user set user_name = #{userName},password = #{password},phone = #{phone}  where user_id = #{userId}")
    int updateUser(User user);
}
