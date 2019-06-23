package com.example.purushotham.collapsingtoolbartest.ApiClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    //Single ton design pattern..
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit=null;
    public  static Retrofit getApiClient()
    {

        if(retrofit==null)
        {
           retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        }
        return retrofit;



    }


}
