package com.example.ecommercemobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cart extends AppCompatActivity {

    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myList = (ListView)this.findViewById(R.id.myList);
        list = new ArrayList<>();

        prefs = this.getSharedPreferences("Cart",this.MODE_PRIVATE);
        String new_product_name = getIntent().getStringExtra("product_name");
        if(new_product_name != null){
            SharedPreferences.Editor editor = prefs.edit();
            Set<String> set = prefs.getStringSet("product_names", new HashSet<String>());
            Set<String> newSet = new HashSet<String>(set);
            newSet.add(new_product_name);
            editor.putStringSet("product_names",newSet);
            editor.apply();
        }


        RefreshCart();

    }

    private void RefreshCart(){

        Set<String> loadset = prefs.getStringSet("product_names", new HashSet<String>());
        list = new ArrayList<String>(loadset);

        adapter = new ArrayAdapter<>(this.getApplicationContext(),android.R.layout.simple_list_item_1, list);
        myList.setAdapter(adapter);

        int cartNumber = list.size();
        ((TextView)this.findViewById(R.id.cart_quantity)).setText("Products in the Cart: " + String.valueOf(cartNumber));
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

    public void CompletePurchase(View v){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("product_names",new HashSet<String>());
        editor.apply();
        RefreshCart();
        Toast.makeText(this,"Successful purchase",Toast.LENGTH_LONG).show();
    }
}
