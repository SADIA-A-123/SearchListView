package com.example.searchlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    SearchView searchView;
    ArrayList<String> list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv1);
        searchView = (SearchView) findViewById(R.id.searchView);
        list = new ArrayList<>();
        list.add("Sadia");
        list.add("Madiha");
        list.add("Noshaba");
        list.add("Sana");
        list.add("Saira");
        list.add("subha");
        list.add("sobia");
        list.add("hina");
        list.add("shaida");
        list.add("samreen");
        list.add("khan");



        adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
//
            public boolean onQueryTextSubmit(String query){

                if (list.contains(query))

                {
                    adapter.getFilter().filter(query);
                }

                else{

                    Toast.makeText(MainActivity.this, "Match not Found",

                    Toast.LENGTH_SHORT).show();
                }
                return false;
            }
            public boolean onQueryTextChange(String newText) {


                adapter.getFilter().filter(newText);


                return false;
            }
        });
    }
}
