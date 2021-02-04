package com.stone.challenge_1.config.httpLogger.services;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

	public JSONObject GetResponseInfo(String responseObjectString, String uri) {
		Object responseObject = JSONValue.parse(responseObjectString);
		JSONObject responseObjectAsJsonObject = (JSONObject) responseObject;
		JSONObject response = MapInfoResponseAsJson(responseObjectAsJsonObject, uri);
		return response;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject MapInfoResponseAsJson(JSONObject responseObject, String uri) {
		JSONObject responseAsJson = responseObject;
		responseAsJson.put("uri", uri);
		return responseAsJson;
	}
}
