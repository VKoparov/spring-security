package com.valik98.security.mappers;

import com.valik98.security.api.UserCreateRequest;
import com.valik98.security.api.UserResponse;
import com.valik98.security.entity.User;
import com.valik98.security.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserModel model);

    @Mapping(target = "password", ignore = true)
    UserModel toUserModel(User entity);

    UserModel toUserModel(UserCreateRequest request);

    UserResponse toUserResponse(UserModel model);
}
