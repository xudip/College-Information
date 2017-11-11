package com.collegesInNepal.collegesInNepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.*;

import java.util.HashMap;

import sap.collegesInNepal.R;

/**
 * Created by h on 8/30/16.
 */
public class LogIn extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        Button btnLogIn = (Button) findViewById(R.id.btn_login);

        username = (EditText)findViewById(R.id.txt_username);
        password = (EditText)findViewById(R.id.txt_password);

        btnLogIn.setOnClickListener(this);


    }

    @Override
    public void processFinish(String result) {
        if(result.contains("successfulLogIn"))
        {

        }
        else
        {

        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("btnLogin", "Login");
        postData.put("mobile", "android");
        postData.put("txtUsername", username.getText().toString());
        postData.put("txtPassword", password.getText().toString() );

        PostResponseAsyncTask loginTask =
                new PostResponseAsyncTask(this, postData, this);

        loginTask.execute("https://udipgora.000webhostapp.com/College%20App/login.php");
    }
}
