package com.example.purushotham.collapsingtoolbartest.ApiInterface;

import com.example.purushotham.collapsingtoolbartest.Model.MyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("todos/")
    Call<List<MyModel>> getTodos();

    @GET("todos/{id}")
    Call<MyModel> getMyTodo(@Path("id")int id);

    @GET("todos/")
    Call<List<MyModel>> getQueryTodo(@Query("Userid")int id,@Query("completed")boolean query);

    @POST("todos/")
    Call<MyModel> postMyTodo(@Body MyModel myModel);
}
