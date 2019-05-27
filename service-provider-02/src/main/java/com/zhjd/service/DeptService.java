package com.zhjd.service;

import com.zhjd.entities.BaseData;
import com.zhjd.entities.PageInfoVo;

import java.util.Map;

public interface DeptService {

	public PageInfoVo<BaseData> list(Map<String, Object> param);
}
