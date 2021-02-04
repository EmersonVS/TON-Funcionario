package com.stone.challenge_1.config.httpLogger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.challenge_1.config.httpLogger.services.RequestService;
import com.stone.challenge_1.config.httpLogger.services.ResponseService;

@Aspect
@Component
public class TonLogging {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ResponseService responseService;
	
	Logger log = LoggerFactory.getLogger(TonLogging.class);
	
	@Pointcut(value = "execution(* com.stone.challenge_1.app.controller.*.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		JSONObject request = requestService.GetRequestInfo();
		String URI = request.get("uri").toString();
		Object responseObject = pjp.proceed();
		String responseObjectAsString = mapper.writeValueAsString(responseObject);
		JSONObject response = responseService.GetResponseInfo(responseObjectAsString, URI);
		log.info(request.toString());
		log.info(response.toString());
		return responseObject;
	}

}
