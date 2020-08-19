package com.bertucci.isagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.userNames);
        s2 = getResources().getStringArray(R.array.description);

        AdapterTimeLine adapterTimeLine = new AdapterTimeLine(this, s1, s2, images);
        recyclerView.setAdapter(adapterTimeLine);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}