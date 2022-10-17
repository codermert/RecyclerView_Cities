package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        landmarkArrayList = new ArrayList<>() ;


        //Data
        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel","France",R.drawable.eiffel);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.colloseum);
        Landmark londonBridge = new Landmark("London Bridge","UK",R.drawable.londonbridge) ;

        landmarkArrayList.add (pisa) ;
        landmarkArrayList.add (eiffel) ;
        landmarkArrayList.add (colosseum) ;
        landmarkArrayList.add (londonBridge) ;

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

        /*

        // BURADA SADECE LİSTVİEW ÇALIŞMASI YAPILIYOR ÜST KISIM RECYCLERVİEW

        //Adapter
        //ListView

        //mapping

        ArrayAdapter arrayAdapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                    landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
            );
        }
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(MainActivity.this, landmarkArrayList.get(i).name, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(i));
                startActivity(intent);
            }
        });

         */




    }
}