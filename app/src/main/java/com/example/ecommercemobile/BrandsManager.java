package com.example.ecommercemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BrandsManager extends AppCompatActivity {
    public Flow flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flow = new Flow();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_manager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void OnClick(View v){
        flow.OnClick(v, this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
