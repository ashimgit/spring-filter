package com.example.filtercheck.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.filtercheck.FCBadReqException;

//@Component
//@Order(1)
public class FCFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Inside Filter------------");
		
		if(true) {//(request.getParameter("testKey").equals("exception")) {
			System.out.println("request.getParameter(\"testKey\").equals(\"exception\")");
			throw new FCBadReqException("Param contains exception");
		}
		
		chain.doFilter(request, response);
	}

}
