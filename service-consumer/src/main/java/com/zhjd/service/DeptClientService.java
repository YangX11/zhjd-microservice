package com.zhjd.service;

import com.zhjd.service.fallBack.DeptClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "SERVICE-PROVIDER",fallbackFactory= DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public Object list(@RequestParam Map<String,Object> param);

}
