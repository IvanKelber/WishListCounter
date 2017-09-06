package com.ivankelber.wishlistcounter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class WishListActivity extends AppCompatActivity {

    List<String> strings = new ArrayList<String>();
    int clickCount = 0;
    ItemListView ilv;
    NewItemDialog newItemDialog = new NewItemDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        strings.add("Guitar");
        strings.add("DSLR");
        strings.add("Theremin");
        for(int i = 0; i < 35; i++) {
            strings.add("" + i);
        }

        ilv = (ItemListView) findViewById(R.id.list);
        ilv.setItems(strings);
        ilv.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClicked(String item) {
                Log.e("ITEM CLICKED: ",item);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                newItemDialog.show(ft,"newItem");
//                strings.add("clicked " + clickCount++);
//                ((BaseAdapter)ilv.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
