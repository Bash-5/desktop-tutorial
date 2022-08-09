package com.example.Electricitybill.dao;

import com.example.Electricitybill.bean.Userbean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Userbean,Integer> {
   
}
