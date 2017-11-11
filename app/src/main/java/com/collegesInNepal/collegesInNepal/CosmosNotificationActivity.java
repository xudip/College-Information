package com.collegesInNepal.collegesInNepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import sap.collegesInNepal.R;

/**
 * Created by h on 8/28/16.
 */
public class CosmosNotificationActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> notificationDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_application_procedure);

        try {
            Intent intent = getIntent();
            notificationDatas = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra("notificationData");
        } catch (NullPointerException e) {
            
        }


    }
}
