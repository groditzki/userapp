package com.haegerconsulting.userservice.service.interfaces;

import com.haegerconsulting.userservice.exceptions.DuplicateUserException;
import com.haegerconsulting.userservice.exceptions.UserNameEmptyException;
import com.haegerconsulting.userservice.exceptions.UserNotFoundException;
import com.haegerconsulting.userservice.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface UserService {

    Iterable<User> getAll();
    User create (User user) throws DuplicateUserException, UserNameEmptyException;
    User get (Long id) throws UserNotFoundException;
    void delete (Long id) throws UserNotFoundException;
    Iterable<User> searchUsersByUserName(String searchString);

}
