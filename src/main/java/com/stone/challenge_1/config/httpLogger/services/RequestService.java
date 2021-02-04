package com.stone.challenge_1.config.httpLogger.services;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class RequestService {

	@Autowired
	private HeaderService headerService;

	public JSONObject GetRequestInfo() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		JSONObject headers = headerService.CreateHeadersJson(httpRequest);
		JSONObject requestInfo = MapInfoRequestAsJson(requestURI, headers);
		return requestInfo;
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject MapInfoRequestAsJson(String requestURI, JSONObject headers) {
		JSONObject requestInfo = new JSONObject();
		requestInfo.put("uri", requestURI);
		requestInfo.put("headers", headers);
		return requestInfo;
	}

}
