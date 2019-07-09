package com.example.paggingdemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * created by Sunday
 * on 2019-07-09 12:03
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView mNameTV;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameTV = itemView.findViewById(R.id.name);
    }

    public void bindTo(User user) {
        mNameTV.setText(user.getName());
    }
}
