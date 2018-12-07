package com.example.yousafkhan.recyclerviewdemo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yousafkhan.recyclerviewdemo.R;
import com.example.yousafkhan.recyclerviewdemo.models.Contact;

import java.util.List;

import androidx.recyclerview.selection.Selection;
import androidx.recyclerview.selection.SelectionTracker;

public class MyActionMode implements ActionMode.Callback {

    private SelectionTracker<Contact> selectionTracker;
    private List<Contact> dataList;
    private RecyclerView.Adapter<MyRecyclerViewAdapter.MyRvViewHolder> recyclerViewAdapter;
    private MenuItem selectedItemCount;

    public MyActionMode(SelectionTracker<Contact> st, List<Contact> contactList,
                        RecyclerView.Adapter<MyRecyclerViewAdapter.MyRvViewHolder> rvAdapter) {

        this.selectionTracker = st;
        this.dataList = contactList;
        this.recyclerViewAdapter = rvAdapter;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.recyclerview_menu, menu);
        selectedItemCount = menu.findItem(R.id.action_item_count);
        mode.setTitle("Choose Action");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_clear:
                selectionTracker.clearSelection();
                setSelectedItemCount(0);
                break;

            case R.id.action_select_all:
                selectionTracker.setItemsSelected(dataList, true);
                break;

            case R.id.action_delete:
                Selection<Contact> selectedItems = selectionTracker.getSelection();

                for (Contact c : selectedItems) {
                    dataList.remove(c);
                }

                recyclerViewAdapter.notifyDataSetChanged();
                selectionTracker.clearSelection();

                break;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        selectionTracker.clearSelection();
    }

    public void setSelectedItemCount(int count) {
        selectedItemCount.setTitle("Selected: " + count);
    }
}
