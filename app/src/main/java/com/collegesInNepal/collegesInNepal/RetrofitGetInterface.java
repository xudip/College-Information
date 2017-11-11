package com.collegesInNepal.collegesInNepal;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by h on 8/29/16.
 */
public interface RetrofitGetInterface {

    //@GET("/notification")
    @GET("/test.php")
    Call<ResponseBody> registerToken(@Query("id") String token);
}
