package com.example.ecommercemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {
    public Flow flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flow = new Flow();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void OnClick(View v){
        flow.OnClick(v, this);
    }
}
