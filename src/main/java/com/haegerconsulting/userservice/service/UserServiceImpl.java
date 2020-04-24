package com.haegerconsulting.userservice.service;

import com.haegerconsulting.userservice.exceptions.DuplicateUserException;
import com.haegerconsulting.userservice.exceptions.UserNameEmptyException;
import com.haegerconsulting.userservice.exceptions.UserNotFoundException;
import com.haegerconsulting.userservice.model.User;
import com.haegerconsulting.userservice.repository.UserRepository;
import com.haegerconsulting.userservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) throws DuplicateUserException, UserNameEmptyException {
        if(user.getId() != null && userRepository.existsById(user.getId()))
        {
            throw new DuplicateUserException(user.getId());
        }
        if(user.getUserName().isEmpty()){
            throw new UserNameEmptyException();
        }
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) throws UserNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void delete(Long id) throws UserNotFoundException {
        if( userRepository.existsById(id) ) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException ();
        }
    }

    @Override
    public Iterable<User> searchUsersByUserName(String searchString) {
        if(searchString.isEmpty())
        {
            return getAll();
        }
        String jpaSearchString = "%"+searchString+"%";
        return userRepository.findByUserName(jpaSearchString);
    }
}
