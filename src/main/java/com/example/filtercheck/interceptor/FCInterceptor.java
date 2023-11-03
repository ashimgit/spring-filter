package com.example.filtercheck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.filtercheck.FCBadReqException;

@Component
public class FCInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		if(true) {//(request.getParameter("testKey").equals("exception")) {
			System.out.println("request.getParameter(\"testKey\").equals(\"exception\")");
			throw new FCBadReqException("Param contains exception");
		}
		String transactionId = request.getHeader("tran-id");
		if(transactionId==null) {
//			MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);
//            mutableHttpServletRequest.putHeader(SapMsgConstants.PLATFORM_TRANSACTION_ID, SAPConnectorUtil.platformTransactionId());

			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request1 = attributes.getRequest();
	        HttpServletResponse response1 = attributes.getResponse();

	        // Add the custom header
//	        request1.addHeader("MyCustomHeader", "MyCustomValue");
		}
        
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println("afterCompletion");
	}
}
