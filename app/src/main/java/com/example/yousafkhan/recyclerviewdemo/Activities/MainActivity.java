package com.example.yousafkhan.recyclerviewdemo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yousafkhan.recyclerviewdemo.R;
import com.example.yousafkhan.recyclerviewdemo.models.Contact;
import com.example.yousafkhan.recyclerviewdemo.recyclerview.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get data
        contactList = getData();

        // initialize  and set up RecyclerView
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(contactList));
    }

    private List<Contact> getData() {
        List<Contact> list = new ArrayList<>();

        list.add(new Contact("John", "123456789"));
        list.add(new Contact("Adam", "123456789"));
        list.add(new Contact("Mike", "123456789"));
        list.add(new Contact("Tom", "123456789"));
        list.add(new Contact("Bradshaw", "123456789"));
        list.add(new Contact("Smith", "123456789"));
        list.add(new Contact("Clarke", "123456789"));
        list.add(new Contact("Rick", "123456789"));
        list.add(new Contact("Aaron", "123456789"));
        list.add(new Contact("Jack", "123456789"));
        list.add(new Contact("Brad", "123456789"));
        list.add(new Contact("Raymond", "123456789"));
        list.add(new Contact("Michael", "123456789"));
        list.add(new Contact("Zack", "123456789"));
        list.add(new Contact("Bradshaw", "123456789"));
        list.add(new Contact("Ian", "123456789"));
        list.add(new Contact("Cole", "123456789"));

        return list;
    }
}
