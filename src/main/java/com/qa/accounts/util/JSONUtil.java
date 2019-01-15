package com.qa.accounts.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

}
