package com.helloworld.quickstart.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
public interface QuickMapper {

    HashMap<String, Object> findById(HashMap<String, Object> paramMap);
}