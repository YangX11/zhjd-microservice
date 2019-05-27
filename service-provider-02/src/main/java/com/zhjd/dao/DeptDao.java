package com.zhjd.dao;

import com.zhjd.entities.BaseData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface DeptDao {

	public List<BaseData> findAll(Map<String,Object> param);
}
