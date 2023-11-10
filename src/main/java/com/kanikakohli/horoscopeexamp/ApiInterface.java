package com.kanikakohli.horoscopeexamp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("thoughtcvtjson.php")

    Call<List<Modal>> getModal();

    @GET("predictcvtjson.php")

    Call<List<Modal>> getModals();

}
