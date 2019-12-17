package com.example.ecommercemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowProducts extends AppCompatActivity {

    public Flow flow;

    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        onViewCreated(this.findViewById(android.R.id.content),savedInstanceState);
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

    public void onViewCreated(View view,Bundle savedInstanceState) {
        mySearchView = (SearchView) this.findViewById(R.id.searchView);
        myList = (ListView)this.findViewById(R.id.myList);

        list = new ArrayList<>();

        list.add("Xbox One");
        list.add("Nintendo Switch");
        list.add("Celular Mi A2 Lite");
        list.add("Sansung Galaxy S9");
        list.add("Tênis Deeprut");
        list.add("Tênis Nike Revolution");
        list.add("Tênis Olympikus");
        list.add("Camiseta Ralph Lauren Custom Fit Branca");
        list.add("Camiseta Tommy Hilfiger Masculina Classic Branca");
        list.add("Moletom Fechado GAP Logo Bordado Cinza");
        list.add("Fiat 147 - Ano 84");
        list.add("BMW M5");
        list.add("Chevrolet Camaro");
        list.add("PlayStation 4");
        list.add("iPhone 8 Apple Plus");

        adapter = new ArrayAdapter<>(this.getApplicationContext(),android.R.layout.simple_list_item_1, list);
        myList.setAdapter(adapter);

        final Activity activity = this;

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data=(String)adapterView.getItemAtPosition(i);
                Intent intent = new Intent(activity.getBaseContext(),ProductDetails.class);
                intent.putExtra("product_name", data);
                startActivity(intent);
                //SharedPreferences userPrefs = this.getSharedPreferences("user", fragment.getActivity().MODE_PRIVATE);
                //boolean isConectedToInternet = userPrefs.getBoolean("isConectedToInternet",true);
                /*    TextView cidadebaixada = (TextView) fragment.getView().findViewById(R.id.cidade_baixada);
                    cidadebaixada.setText(fragment.getResources().getString(R.string.downloaded_city, data));
                    SharedPreferences.Editor userEditor = userPrefs.edit();
                    userEditor.putString("Downloaded_city", data);*/

            }
        });

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
