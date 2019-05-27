package com.zhjd.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhjd.entities.BaseData;
import com.zhjd.entities.PageInfoVo;
import com.zhjd.entities.ResponseVo;
import com.zhjd.service.DeptService;
import com.zhjd.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DeptController {

	private Logger logger =Logger.getLogger(this.getClass());

	@Autowired
	private DeptService service;

	@HystrixCommand(fallbackMethod = "processHystrix_Method")
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public ResponseVo list(@RequestParam Map<String,Object> param) {
		PageInfoVo<BaseData> info = service.list(param);
		return ResultUtil.success("success",info);
	}

	//服务降级
	public ResponseVo processHystrix_Method(@RequestParam Map<String,Object> param) {
		//打印此处信息时，请注释对应方法的@HystrixCommand，否则控制套不会输出异常信息
		logger.debug("生产服务未响应或异常，请检查参数或联系管理员调试");
		return ResultUtil.error("service-provider-error");
	}

}
