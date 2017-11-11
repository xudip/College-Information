package com.collegesInNepal.collegesInNepal;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by h on 8/29/16.
 */
public class ApiService {
    public void sendTokenToServer(final Callback<ResponseBody> callback, User user) {
        RetrofitGetInterface userRegisterService =
                ServiceGenerator.createService(RetrofitGetInterface.class);

        // finally, execute the request
        Call<ResponseBody> call = userRegisterService.registerToken(user.getToken());


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            callback.onFailure(call,t);
            }
        });   }


}
