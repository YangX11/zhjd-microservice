package com.zhjd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjd.dao.DeptDao;
import com.zhjd.entities.BaseData;
import com.zhjd.entities.PageInfoVo;
import com.zhjd.service.DeptService;
import com.zhjd.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dao;

	@Override
	public PageInfoVo<BaseData> list(Map<String,Object> param) {
		Object pageNum = param.get("pageNum");
		Object pageSize = param.get("pageSize");
		PageUtil.setPageNum(pageNum);
		PageUtil.setPageSize(pageSize);
		PageHelper.startPage(PageUtil.setPageNum(pageNum),PageUtil.setPageSize(pageSize));	//设置分页参数
		List<BaseData> list = dao.findAll(param);
		PageInfoVo<BaseData> info = PageUtil.simplePageInfo(new PageInfo(list));			//获取精简版pagedata
		return info;
	}

}
