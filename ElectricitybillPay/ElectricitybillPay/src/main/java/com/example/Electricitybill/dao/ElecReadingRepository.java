package com.example.Electricitybill.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Electricitybill.bean.ElecReading;

public interface ElecReadingRepository extends JpaRepository<ElecReading,Long>{

}
