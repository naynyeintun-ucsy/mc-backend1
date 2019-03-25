package com.nnt.backend.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/***
 * created by Nay Nyein Tun
 * March 19 2019
 ***/

public class DataUtil {

    /**
     * Get Json Object
     * 
     * @param strJson
     * @return JsonObject
     * @throws
     * @throws java.lang.Exception
     */
    public static JsonObject getJsonObject(String strJson) {
        JsonObject json = null;
        try {
            if (null != strJson && 0 != strJson.length()) {
                json = new Gson().fromJson(strJson, JsonObject.class);
            }
            if (json != null && json.has("data")) {
                json = json.getAsJsonObject("data");
            }
        } catch (Exception ex) {
            json = null;
            System.out.println("JSON invalid");
        }
        return json;
    }

    /**
     * Get data from JSON, return String.
     * 
     * @param json
     * @param memberName
     * @return String
     */
    public static String getJsonString(JsonObject json, String memberName) {
        return getJsonString(json, memberName, null);
    }

    /**
     * Get data from JSON, return String.
     * 
     * @param json
     * @param memberName
     * @param defaultValue
     * @return String
     */
    public static String getJsonString(JsonObject json, String memberName, String defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        return json.get(memberName).getAsString();
    }
    
}
