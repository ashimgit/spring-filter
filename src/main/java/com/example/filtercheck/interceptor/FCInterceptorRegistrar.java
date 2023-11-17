package com.example.filtercheck.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Component
public class FCInterceptorRegistrar extends WebMvcConfigurerAdapter {

	@Autowired
	FCInterceptor fcInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("addInterceptors . . ..");
		registry.addInterceptor(fcInterceptor);
	}
}
