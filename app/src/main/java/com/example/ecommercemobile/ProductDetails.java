package com.example.ecommercemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {
    public Flow flow;
    public String product_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        flow = new Flow();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String data = getIntent().getStringExtra("product_name");
        TextView name_view = (TextView)this.findViewById(R.id.product_name);
        name_view.setText(data);
        product_name = data;
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

    public void CalculateFreight(View v){
        TextView view = (TextView)this.findViewById(R.id.freight_value);
        view.setText("Freight Value: R$ 35.00");
    }

    public void AddToCart(View v){
        Intent it = new Intent(this.getBaseContext(),Cart.class);
        it.putExtra("product_name", product_name);
        startActivity(it);
    }
}
