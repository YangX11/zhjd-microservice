package com.zhjd.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigBean {
	//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
	//在使用fegin后，放弃使用RestTemplate+ribbon的方式
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		return new RetryRule();
	}

	//swagger
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zhjd"))//api接口包扫描路径
				.paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("苏州市全面从严治党\"智慧监督\"平台")//设置文档的标题
				.description("苏州市全面从严治党\"智慧监督\"平台(二期)数据接口,为相关项目提供数据支持.")//设置文档的描述->1.Overview
				.version("1.0")//设置文档的版本信息-> 1.1 Version information
				.contact(new Contact("", "http:", ""))//设置文档的联系方式->1.2 Contact information
				.termsOfServiceUrl("")//设置文档的License信息->1.3 License information
				.build();
	}
}