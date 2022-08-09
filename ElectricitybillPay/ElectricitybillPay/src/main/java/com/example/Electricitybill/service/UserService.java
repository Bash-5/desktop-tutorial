package com.example.Electricitybill.service;

import com.example.Electricitybill.bean.Userbean;
import com.example.Electricitybill.exception.DuplicateUserException;
import com.example.Electricitybill.exception.InvalidLoginCredentialException;

import java.util.List;

public interface UserService {
    public Userbean registerUser(Userbean user) throws DuplicateUserException;
    public Userbean loginUser(Userbean user) throws InvalidLoginCredentialException;
    public Userbean forgetPassword(String username);
    public Userbean changePassword(Userbean user,String np);
    public Userbean getUserById(int uid);
    public Userbean getUserByUserName(String username);
    public List<Userbean> getallUsers();
}