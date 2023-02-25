package com.project.admincollegeapp.Model;

import static com.project.admincollegeapp.Constants.CONTENT_TYPE;
import static com.project.admincollegeapp.Constants.SERVER_KEY;

import com.project.admincollegeapp.Model.PushNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @Headers({"Authorization: key="+SERVER_KEY,"Content-Type:"+CONTENT_TYPE})
    @POST("fcm/send")
    Call<PushNotification> sendNotification(@Body PushNotification notification);
}
