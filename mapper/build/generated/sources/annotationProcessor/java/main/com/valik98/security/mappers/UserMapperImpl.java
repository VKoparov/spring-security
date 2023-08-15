package com.valik98.security.mappers;

import com.valik98.security.api.UserCreateRequest;
import com.valik98.security.api.UserResponse;
import com.valik98.security.entity.User;
import com.valik98.security.enums.Role;
import com.valik98.security.model.UserModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-15T14:06:38+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserModel model) {
        if ( model == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.username( model.username() );
        user.password( model.password() );
        user.email( model.email() );
        Set<Role> set = model.roles();
        if ( set != null ) {
            user.roles( new LinkedHashSet<Role>( set ) );
        }

        return user.build();
    }

    @Override
    public UserModel toUserModel(User entity) {
        if ( entity == null ) {
            return null;
        }

        String username = null;
        String email = null;
        Set<Role> roles = null;

        username = entity.getUsername();
        email = entity.getEmail();
        Set<Role> set = entity.getRoles();
        if ( set != null ) {
            roles = new LinkedHashSet<Role>( set );
        }

        String password = null;

        UserModel userModel = new UserModel( username, email, password, roles );

        return userModel;
    }

    @Override
    public UserModel toUserModel(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        String username = null;
        String email = null;
        String password = null;
        Set<Role> roles = null;

        username = request.username();
        email = request.email();
        password = request.password();
        Set<Role> set = request.roles();
        if ( set != null ) {
            roles = new LinkedHashSet<Role>( set );
        }

        UserModel userModel = new UserModel( username, email, password, roles );

        return userModel;
    }

    @Override
    public UserResponse toUserResponse(UserModel model) {
        if ( model == null ) {
            return null;
        }

        String username = null;
        String email = null;

        username = model.username();
        email = model.email();

        UserResponse userResponse = new UserResponse( username, email );

        return userResponse;
    }
}