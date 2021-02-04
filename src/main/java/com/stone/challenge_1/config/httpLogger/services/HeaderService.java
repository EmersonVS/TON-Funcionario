package com.stone.challenge_1.config.httpLogger.services;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {


	@SuppressWarnings("unchecked")
	public JSONObject CreateHeadersJson(HttpServletRequest httpRequest) {
		Enumeration<String> headerNames = httpRequest.getHeaderNames();
		JSONObject jsonHeaders = new JSONObject();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				jsonHeaders.put(headerName.toString(), httpRequest.getHeader(headerName));
			}
		}
		return jsonHeaders;
	}

}
