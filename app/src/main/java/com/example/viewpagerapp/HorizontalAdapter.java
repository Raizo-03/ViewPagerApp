package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    private ArrayList<Fragment> fragmentList;
    private FragmentActivity fragmentActivity;

    public HorizontalAdapter(FragmentActivity fragmentActivity, ArrayList<Fragment> fragmentList) {
        this.fragmentActivity = fragmentActivity;
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fragment fragment = fragmentList.get(position);
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();

        // Replace the fragment in the holder's container view
        transaction.replace(holder.containerView.getId(), fragment);
        transaction.commit();
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View containerView;

        ViewHolder(View itemView) {
            super(itemView);
            // Set the container view for each item
            containerView = itemView.findViewById(R.id.fragment_container);
        }
    }
}
