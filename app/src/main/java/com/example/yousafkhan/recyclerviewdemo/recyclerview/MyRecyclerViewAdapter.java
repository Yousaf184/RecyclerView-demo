package com.example.yousafkhan.recyclerviewdemo.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yousafkhan.recyclerviewdemo.R;
import com.example.yousafkhan.recyclerviewdemo.models.Contact;

import java.util.List;

import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.SelectionTracker;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRvViewHolder> {

    private List<Contact> dataList;
    private SelectionTracker<Contact> selectionTracker;

    public MyRecyclerViewAdapter(List<Contact> contactList) {
        this.dataList = contactList;
    }

    public void setSelectionTracker(SelectionTracker<Contact> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }

    // create new views
    // this method is invoked by layout manager
    @NonNull
    @Override
    public MyRvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create new view by inflating the layout defined for RecyclerView's single row
        View v = LayoutInflater.from(viewGroup.getContext())
                               .inflate(R.layout.recyclerview_row, viewGroup, false);

        // return a new instance of RecyclerView.ViewHolder
        return new MyRvViewHolder(v);
    }

    // recycle the contents of the view
    // this method is invoked by the layout manager
    @Override
    public void onBindViewHolder(@NonNull MyRvViewHolder myRvViewHolder, int i) {
        Contact contact = dataList.get(i);
        myRvViewHolder.setDataToView(contact);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // ViewHolder for RecyclerView
    public class MyRvViewHolder extends RecyclerView.ViewHolder {

        private TextView contactNameText;
        private TextView contactNumberText;
        private ImageView selectedIcon;

        public MyRvViewHolder(@NonNull View itemView) {
            super(itemView);
            contactNameText = itemView.findViewById(R.id.contact_name_textview);
            contactNumberText = itemView.findViewById(R.id.contact_number_textview);
            selectedIcon = itemView.findViewById(R.id.row_check_icon);
        }

        // sets data inside a RecyclerView row
        public void setDataToView(Contact contact) {
            contactNameText.setText(contact.getContactName());
            contactNumberText.setText(contact.getContactPhoneNumber());
        }

        // returns an instance of MyItemDetail to MyItemDetailsLookup class
        public ItemDetailsLookup.ItemDetails<Contact> getItemDetails() {
            return new MyItemDetail(dataList.get(getAdapterPosition()), getAdapterPosition());
        }
    }
}
