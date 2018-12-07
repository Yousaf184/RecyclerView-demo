package com.example.yousafkhan.recyclerviewdemo.recyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.yousafkhan.recyclerviewdemo.models.Contact;

import java.util.List;

import androidx.recyclerview.selection.ItemKeyProvider;

public class MyItemKeyProvider extends ItemKeyProvider<Contact> {

    private List<Contact> dataList;

    public MyItemKeyProvider(int scope, List<Contact> contactList) {
        super(scope);
        this.dataList = contactList;
    }

    @Nullable
    @Override
    public Contact getKey(int i) {
        return dataList.get(i);
    }

    @Override
    public int getPosition(@NonNull Contact contact) {
        return dataList.indexOf(contact);
    }
}
