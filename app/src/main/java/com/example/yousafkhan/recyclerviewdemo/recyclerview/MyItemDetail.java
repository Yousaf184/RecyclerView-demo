package com.example.yousafkhan.recyclerviewdemo.recyclerview;

import android.support.annotation.Nullable;

import com.example.yousafkhan.recyclerviewdemo.models.Contact;

import androidx.recyclerview.selection.ItemDetailsLookup;

/**
 * ItemDetails implementation provides the selection library
 * with access to information about a specific RecyclerView item.
 */

public class MyItemDetail extends ItemDetailsLookup.ItemDetails<Contact> {

    private Contact contact;
    private int adapterPosition;

    public MyItemDetail(Contact c, int position) {
        this.contact = c;
        this.adapterPosition = position;
    }

    @Override
    public int getPosition() {
        return this.adapterPosition;
    }

    @Nullable
    @Override
    public Contact getSelectionKey() {
        return this.contact;
    }
}
