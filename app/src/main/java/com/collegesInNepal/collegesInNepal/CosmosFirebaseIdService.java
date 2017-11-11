package com.collegesInNepal.collegesInNepal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by h on 8/26/16.
 */
public class CosmosFirebaseIdService extends FirebaseInstanceIdService {

    private String TAG = "myFirebaseId";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG, "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
        localSave(refreshedToken);

    }

    private void localSave(String refreshedToken) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("CosmosPreferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myToken", refreshedToken);
        editor.commit();
    }

    public void sendRegistrationToServer(String token) {
        User user = new User();
        user.setToken(token);

        ApiService apiService = new ApiService();
        apiService.sendTokenToServer(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("response",response.message().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("error",t.toString());
            }
        }, user);
    }

    }
