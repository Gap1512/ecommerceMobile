package com.example.ecommercemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BrandsRegister extends AppCompatActivity {
    public Flow flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flow = new Flow();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_register);
    }

    public void OnClick(View v){
        flow.OnClick(v, this);
    }
}
