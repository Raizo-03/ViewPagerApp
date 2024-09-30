package com.example.viewpagerapp;

import androidx.fragment.app.Fragment;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHorizontal extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HorizontalAdapter adapter;
    private ArrayList<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_horizontal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Fragment> fragmentList = new ArrayList<>();

// Add fragments to the list
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());

// Set up the adapter
        HorizontalAdapter adapter = new HorizontalAdapter(this, fragmentList);
        recyclerView.setAdapter(adapter);

// Set the layout manager to horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}