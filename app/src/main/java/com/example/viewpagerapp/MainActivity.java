package com.example.viewpagerapp;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(), // method for getting the instance of fragment manager that is used for adding, removing etc of fragments
                getLifecycle() // get instance of lifecycle
        );


        //add fragments to the adapter
        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());

        //set orientation of viewpager
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //connects the adapter with viewpager2
        viewPager2.setAdapter(myAdapter);



        tabLayout = findViewById(R.id.tabLayout);

        //connecting tablayout with viewpager
        new TabLayoutMediator(
                tabLayout,
                viewPager2,
                (tab, position) -> {
                    tab.setText("Fragment " + (position + 1));

                }
        ).attach();

        // Add margin between fragments
        int pageMarginPx = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        int offsetPx = getResources().getDimensionPixelOffset(R.dimen.offsetPx);

        // Adjust padding for adjacent fragments
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                float scale = 0.85f + (1 - Math.abs(position)) * 0.15f;
                page.setScaleY(scale);
                page.setAlpha(0.5f + (1 - Math.abs(position)) * 0.5f);
            }
        });

        // Add ItemDecoration to add page margin
        viewPager2.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.right = pageMarginPx;
            }
        });

        Button btn = findViewById(R.id.btnNext);
        btn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RecyclerViewHorizontal.class);
            startActivity(i);
        });
    }


    /*
    ViewPager is a layout manager that allows the user to flip left and right through pages of data


    It is mostly found in apps like YouTube, Snapchat
    where the users shifts right to left to switch to a screen
    Instead of using activities, fragments are used


    It is also used to guide the user through the app
    when the user launches the app for the first time


    Tab layout - allows user to navigate through fragments
    user can tap on the pages to switch between them



     */
}