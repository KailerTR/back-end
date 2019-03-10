package com.brainacad;

import com.jayway.jsonpath.JsonPath;

public class JsonUtils {
    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения строки из JSON по JSON Path:

    public static String stringFromJSONByPath(String json, String jsonPath){
        return JsonPath.read(json, jsonPath);
    }

    public static String getUserJob(String json){
        return JsonPath.read(json, "$.data.job");
    }

    public static String getUserFirstName(String json){
        return JsonPath.read(json, "$.data.first_name");
    }

    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения int из JSON по JSON Path:
    /*
    public static int intFromJSONByPath(String json, String jsonPath){
    }
    */

    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения double из JSON по JSON Path:
    /*
    public static double doubleFromJSONByPath(String json, String jsonPath){
    }
    */

    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения списка (List) из JSON по JSON Path:
    /*
    public static List listFromJSONByPath(String json, String jsonPath){
    }
    */

}
