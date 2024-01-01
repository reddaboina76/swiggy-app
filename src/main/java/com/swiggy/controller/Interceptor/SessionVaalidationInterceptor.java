package com.swiggy.controller.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionVaalidationInterceptor extends HandlerInterceptorAdapter{

	final static Logger logger = Logger.getLogger(SessionVaalidationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Executing SessionVaalidationInterceptor :: preHandle method!!");
		HttpSession httpSession = request.getSession();
		request.getSession(false);
		String name = (String) httpSession.getAttribute("name");
		logger.debug("name not available in session ::" + name);
		logger.debug("User trying to skip login page!!");
		if (name == null || name.isEmpty()) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "pleaseclogin to acces this page!!");
			
			throw new ModelAndViewDefiningException(mv);
		}else {
			logger.debug("name is available in session!!");
			logger.debug("user already loged in!!");
			return true;
		}

	}
	
}
