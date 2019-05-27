package com.zhjd.service.fallBack;

import com.zhjd.service.DeptClientService;
import com.zhjd.util.ResultUtil;
import feign.hystrix.FallbackFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	private Logger logger =Logger.getLogger(this.getClass());

	@Override
	public DeptClientService create(Throwable throwable){
		return new DeptClientService() {

			@Override
			public Object list(@RequestParam Map<String,Object> param) {
				logger.debug("消费服务异常，异常信息："+throwable.getMessage());
				return (Object) ResultUtil.error("service-consumer-error");
			}

		};
	}
}
