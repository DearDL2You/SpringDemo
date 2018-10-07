package com.example.controller.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/one/*" ,filterName = "testFilter")
public class TestFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			HttpServletRequest request= (HttpServletRequest) servletRequest;
		    HttpServletResponse response = (HttpServletResponse) servletResponse;
		    System.out.printf("过滤器实现\n");
		    filterChain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
//	//过滤器    
//	@Bean    
//	public FilterRegistrationBean filterRegistrationBean(){
//			FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//			List<String> urlPatterns = new ArrayList<String>();
//			TestFilter testFilter = new TestFilter();
//			//new过滤器       
//			urlPatterns.add("/one");
//			//指定需要过滤的url
//			filterRegistrationBean.setFilter(testFilter);
//			//set
//			filterRegistrationBean.setUrlPatterns(urlPatterns);
//			//set
//			return filterRegistrationBean;    
//		}

}
