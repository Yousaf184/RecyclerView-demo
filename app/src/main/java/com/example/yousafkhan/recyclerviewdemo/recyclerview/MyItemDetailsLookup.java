package com.example.yousafkhan.recyclerviewdemo.recyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.yousafkhan.recyclerviewdemo.models.Contact;

import androidx.recyclerview.selection.ItemDetailsLookup;

/**
 * ItemDetailsLookup enables the selection library to access information
 * about RecyclerView items given a MotionEvent.
 *
 * It is effectively a factory for ItemDetails instances that are backed
 * up by a RecyclerView.ViewHolder instance.
 */

public class MyItemDetailsLookup extends ItemDetailsLookup<Contact> {

    private RecyclerView recyclerView;

    public MyItemDetailsLookup(RecyclerView rv) {
        this.recyclerView = rv;
    }

    @Nullable
    @Override
    public ItemDetails<Contact> getItemDetails(@NonNull MotionEvent motionEvent) {
        View v = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if(v != null) {
            MyRecyclerViewAdapter.MyRvViewHolder vh =
                    (MyRecyclerViewAdapter.MyRvViewHolder) recyclerView.getChildViewHolder(v);

            if(vh != null) {
                return vh.getItemDetails();
            }
        }

        return null;
    }
}
