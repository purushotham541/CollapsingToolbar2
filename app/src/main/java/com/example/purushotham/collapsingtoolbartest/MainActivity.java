package com.example.purushotham.collapsingtoolbartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.purushotham.collapsingtoolbartest.ApiClient.ApiClient;
import com.example.purushotham.collapsingtoolbartest.ApiInterface.ApiInterface;
import com.example.purushotham.collapsingtoolbartest.Model.MyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    ApiInterface apiInterface;
    Button url1,url2,url3,url4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url1=findViewById(R.id.url1);
        url2=findViewById(R.id.url2);
        url3=findViewById(R.id.url3);
        url4=findViewById(R.id.url4);


        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        url1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Call<List<MyModel>> mytoDos=apiInterface.getTodos();
                mytoDos.enqueue(new Callback<List<MyModel>>() {
                    @Override
                    public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                        Log.d(TAG, "onResponse: "+response.body());

                    }

                    @Override
                    public void onFailure(Call<List<MyModel>> call, Throwable t) {
                        Log.e(TAG, "onFailure: ", t);
                    }
                });

            }
        });
        url2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                apiInterface.getMyTodo(2).enqueue(new Callback<MyModel>() {
                    @Override
                    public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                        Log.d(TAG, "onResponse: "+response.body());

                    }

                    @Override
                    public void onFailure(Call<MyModel> call, Throwable t) {

                    }
                });



            }
        });
        url3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<MyModel>> listCall=apiInterface.getQueryTodo(1,true);
                listCall.enqueue(new Callback<List<MyModel>>() {
                    @Override
                    public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                        Log.d(TAG, "onResponse: "+response.body());
                    }

                    @Override
                    public void onFailure(Call<List<MyModel>> call, Throwable t) {

                    }
                });
            }
        });
        url4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MyModel myModel=new MyModel(123,"get my milk",true);
                Call<MyModel> myModelCall=apiInterface.postMyTodo(myModel);
                myModelCall.enqueue(new Callback<MyModel>() {
                    @Override
                    public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                        Log.d(TAG, "onResponse: "+response.body());

                    }

                    @Override
                    public void onFailure(Call<MyModel> call, Throwable t) {

                    }
                });
            }
        });

    }
}
