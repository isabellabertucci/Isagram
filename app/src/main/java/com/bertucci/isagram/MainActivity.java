package com.bertucci.isagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Post> listPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPost.add(new Post("isa", "description", R.drawable.photo1));
        listPost.add(new Post("Pedro", "description", R.drawable.photo2));
        listPost.add(new Post("Vi", "description", R.drawable.photo3));
        listPost.add(new Post("Rita", "description", R.drawable.photo4));

        recyclerView = findViewById(R.id.recycleView);

        AdapterTimeLine adapterTimeLine = new AdapterTimeLine(this, listPost);
        recyclerView.setAdapter(adapterTimeLine);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}