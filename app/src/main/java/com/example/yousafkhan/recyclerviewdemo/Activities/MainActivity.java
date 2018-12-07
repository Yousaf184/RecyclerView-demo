package com.example.yousafkhan.recyclerviewdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yousafkhan.recyclerviewdemo.R;
import com.example.yousafkhan.recyclerviewdemo.models.Contact;
import com.example.yousafkhan.recyclerviewdemo.recyclerview.MyActionMode;
import com.example.yousafkhan.recyclerviewdemo.recyclerview.MyItemDetailsLookup;
import com.example.yousafkhan.recyclerviewdemo.recyclerview.MyItemKeyProvider;
import com.example.yousafkhan.recyclerviewdemo.recyclerview.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter<MyRecyclerViewAdapter.MyRvViewHolder> recyclerViewAdapter;
    private SelectionTracker<Contact> selectionTracker;
    private ActionMode actionMode;
    private MyActionMode myActionMode;

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

        recyclerViewAdapter = new MyRecyclerViewAdapter(contactList);
        recyclerView.setAdapter(recyclerViewAdapter);

        setRecyclerViewSelectionTracker();

        // pass SelectionTracker in RecyclerViewAdapter to access this SelectionTracker
        // inside RecyclerView.Adapter
        ((MyRecyclerViewAdapter) recyclerViewAdapter).setSelectionTracker(selectionTracker);

        setRecyclerViewSelectionObserver();
    }

    private void setRecyclerViewSelectionTracker() {
        SelectionTracker.Builder<Contact> selectionBuilder = new SelectionTracker.Builder<>(
                "my_selection_id",
                recyclerView,
                new MyItemKeyProvider(ItemKeyProvider.SCOPE_CACHED ,contactList),
                new MyItemDetailsLookup(recyclerView),
                StorageStrategy.createParcelableStorage(Contact.class)
        );

        selectionTracker = selectionBuilder.build();
    }

    private void setRecyclerViewSelectionObserver() {
        selectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onSelectionChanged() {
                super.onSelectionChanged();

                if(selectionTracker.hasSelection() && actionMode == null) {
                    myActionMode = new MyActionMode(
                                                     selectionTracker,
                                                     contactList,
                                                     recyclerViewAdapter
                                                   );

                    actionMode = startSupportActionMode(myActionMode);

                } else if(!selectionTracker.hasSelection() && actionMode != null) {
                    actionMode.finish();
                    actionMode = null;

                } else {
                    myActionMode.setSelectedItemCount(selectionTracker.getSelection().size());
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        selectionTracker.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectionTracker.onRestoreInstanceState(savedInstanceState);
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
