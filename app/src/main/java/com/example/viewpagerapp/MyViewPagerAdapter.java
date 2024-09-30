package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentlist = new ArrayList<>(); //list of fragments; fragment1, fragment2

    public MyViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    //responsible for creating and returning the fragment
    //for a specific position within ViewPager2
    @NonNull
    @Override
    public Fragment createFragment(int position) {



        //return the fragment corresponding to the position
        return fragmentlist.get(position);
    }


    //responsible for returning the total of fragments
    @Override
    public int getItemCount() {
        return fragmentlist.size();
    }

    public void addFragment(Fragment fragment){
        fragmentlist.add(fragment);
    }
}
