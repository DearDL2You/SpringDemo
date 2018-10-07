package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.controller.interceptor.OneInterceptor;
import com.example.controller.interceptor.TwoInterceptor;

@Configuration
public class WebMvcConfigurers implements  WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */

		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
														.addPathPatterns("/one/**");
		
//		super.addInterceptors(registry);
	}

}
