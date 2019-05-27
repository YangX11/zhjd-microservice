package com.zhjd.controller;

import com.zhjd.controller.base.BaseController;
import com.zhjd.service.DeptClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "DeptApi", description = "the Dept API")
@RestController
public class DeptController extends BaseController {

	@Autowired
	private DeptClientService service;

	@ApiOperation(value="部门列表(分页)", notes="获取所有部门列表(分页)",produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "map", value = "可变的多参数列表", required =false )
	})
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public Object list(@RequestParam Map map) {
		System.out.println(map);
		return service.list(map);
	}

}
