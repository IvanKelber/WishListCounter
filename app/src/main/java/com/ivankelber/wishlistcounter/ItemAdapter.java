package com.ivankelber.wishlistcounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ivankelber on 9/6/17.
 */
public class ItemAdapter extends BaseAdapter {

    private List<String> items;
    private LayoutInflater layoutInflater;

    public ItemAdapter(Context context, List<String> items) {
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check to see if convertView has already been set or not.
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_layout,null);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.item_name);
        itemName.setText(items.get(position));

        return convertView;
    }
}
