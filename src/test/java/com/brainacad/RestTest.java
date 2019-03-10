package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.brainacad.HttpClientHelper.*;


public class RestTest{

    private static final String URL="https://reqres.in/";

    @Test//GET метод
    public void checkGetResponseStatusCode(){
        String endpoint="/api/users/2";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.

        HttpResponse response = get(URL+endpoint,"page=2");

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }

    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = get(URL+endpoint,"page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод
    public void checkPostResponseStatusCode(){
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = post(URL+endpoint,requestBody);

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 201", 201, statusCode);
    }

    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = post(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

    @Test
    public void checkUserInfoUpdate() throws IOException {
        String endpoint="/api/users/2";
        HttpResponse response = get(URL+endpoint, null);
        String body = getBodyFromResponse(response);
        System.out.println("Data before: " + body);

        String requestBody="{\"name\": \"morpheus\",\"job\": \"zion resident\"}";

        response = put(URL+endpoint,requestBody);
        body = getBodyFromResponse(response);
        System.out.println(body);

        response = get(URL+endpoint, null);
        body = getBodyFromResponse(response);
        System.out.println("Data after: " + body);

        //Assert.assertEquals("Name is correct?", "Janet", stringFromJSONByPath(body, "$.data.first_name"));
        //Assert.assertEquals("Name is correct?", "Janet", getUserFirstName(body));

       // Assert.assertEquals("Job is correct", "zion resident", stringFromJSONByPath(body, "$.data.job"));
       // Assert.assertEquals("Job is correct", "zion resident", getUserJob(body));
    }


}
