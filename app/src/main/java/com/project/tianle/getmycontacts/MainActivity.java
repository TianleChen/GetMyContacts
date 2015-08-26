package com.project.tianle.getmycontacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private ListView lv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetContacts.getContacts(this);
        lv = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter(GetContacts.lists, this);
        lv.setAdapter(adapter);
    }


}