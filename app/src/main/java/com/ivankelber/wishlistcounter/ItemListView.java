package com.ivankelber.wishlistcounter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by ivankelber on 9/6/17.
 */


public class ItemListView extends ListView implements AdapterView.OnItemClickListener {

    private List<String> items;
    private ItemClickListener itemClickListener;

    public ItemListView(Context context) {
        super(context);
    }

    public ItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }
    public void setItems(List<String> items) {
        this.items = items;
        ItemAdapter adapter = new ItemAdapter(getContext(), items);
        setAdapter(adapter);

        setOnItemClickListener(this);

    }

    public void setOnItemClickListener(ItemClickListener d) {
        this.itemClickListener = d;
    }

    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        if (itemClickListener != null) {
            itemClickListener.onItemClicked(items.get(position));
        }
    }
}

