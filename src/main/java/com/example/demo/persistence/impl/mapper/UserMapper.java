package com.example.demo.persistence.impl.mapper;

import com.example.demo.model.User;
import com.example.demo.typehandler.UUIDTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (id, username, email, password) VALUES (#{id, javaType=java.util.UUID, jdbcType=OTHER, typeHandler=UUIDTypeHandler}, #{username}, #{email}, #{password})")
    void create(User user);

    @Results(id = "userResult")
    @ConstructorArgs({
            @Arg(column = "id", javaType = UUID.class, typeHandler = UUIDTypeHandler.class, id = true),
            @Arg(column = "username", javaType = String.class),
            @Arg(column = "email", javaType = String.class),
            @Arg(column = "password", javaType = String.class),
    })
    @Select("SELECT * FROM users")
    List<User> getAll();

    @ResultMap("userResult")
    @Select("SELECT * FROM users WHERE id = #{id, javaType=java.util.UUID, jdbcType=OTHER, typeHandler=UUIDTypeHandler}")
    User get(@Param("id") UUID id);
}
