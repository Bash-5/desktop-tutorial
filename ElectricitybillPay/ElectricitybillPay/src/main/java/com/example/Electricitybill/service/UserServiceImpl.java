package com.example.Electricitybill.service;

import com.example.Electricitybill.bean.Userbean;
import com.example.Electricitybill.exception.DuplicateUserException;
import com.example.Electricitybill.exception.InvalidLoginCredentialException;
import com.example.Electricitybill.exception.InvalidUserIdException;
import com.example.Electricitybill.exception.InvalidUserNameException;
import com.example.Electricitybill.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public Userbean registerUser(Userbean user) throws DuplicateUserException {
    	try{
            Userbean user1=this.getUserByUserName(user.getUserName());
        }
        catch (InvalidUserNameException exception){
            userRepo.save(user);
            return user;
        }
        throw new DuplicateUserException();
    }

    @Override
    public Userbean loginUser(Userbean user) throws InvalidLoginCredentialException {
    	List<Userbean> users=userRepo.findAll();
        System.out.println(users);
        for(Userbean user1:users){
            if(Objects.equals(user.getUserName(), user1.getUserName()) && Objects.equals(user.getPassword(), user1.getPassword()))
                return user1;
        }
        throw new InvalidLoginCredentialException();
    }

    @Override
    public Userbean forgetPassword(String username) {
        List<Userbean> users=userRepo.findAll();
        for(Userbean user1:users){
            if(Objects.equals(user1.getUserName(), username)) {
                user1.setPassword("12345678");
                userRepo.save(user1);
                return user1;
            }

        }
        throw new InvalidLoginCredentialException();
    }

    @Override
    public Userbean changePassword(Userbean user, String np) {
        List<Userbean> users=userRepo.findAll();
        for(Userbean user1:users){
            if(Objects.equals(user1.getUserName(),user.getUserName()) && Objects.equals(user1.getPassword(),user.getPassword())) {
                user1.setPassword(np);
                userRepo.save(user1);
                return user1;
            }
    }
        throw new InvalidLoginCredentialException();
}

    @Override
    public Userbean getUserById(int uid) {
        try {
            Optional<Userbean> user= userRepo.findById(uid);
            if(user.isPresent())
                return user.get();
        }
        catch (Exception e){
            throw new InvalidLoginCredentialException();
        }
        throw new InvalidUserIdException();
    }

    @Override
    public Userbean getUserByUserName(String username) {
        List<Userbean> users=userRepo.findAll();
        for(Userbean user:users){
            if(Objects.equals(user.getUserName(),username)){
                return user;
            }
        }
        throw new InvalidUserNameException();
    }
    @Override
    public List<Userbean> getallUsers() {
    	return userRepo.findAll();
    }
}
