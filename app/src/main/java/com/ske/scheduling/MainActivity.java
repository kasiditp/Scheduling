package com.ske.scheduling;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Model.Date;
import Model.Schedule;
import Model.Storage;
import view.ScheduleAdapter;

public class MainActivity extends AppCompatActivity {

    List<Schedule> nameList = new ArrayList<Schedule>();
    List<Schedule> scheduleList;
    private ListView nameListView;
    private ScheduleAdapter scheduleAdapter;
    private Storage storage;
    private Calendar today = Calendar.getInstance();
    private int number = today.get(Calendar.DATE);
    private java.util.Date date  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Calendar today = Calendar.getInstance();
        date = (java.util.Date) getIntent().getSerializableExtra("DATE");
        if(date == null)
            getSupportActionBar().setTitle(today.get(Calendar.DATE) + "/"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.YEAR));
        else
            getSupportActionBar().setTitle(date.getDate()+"/"+date.getMonth()+"/"+date.getYear());

        initComponent(date);
    }

    public void initComponent(java.util.Date date){

        if(date == null)
            scheduleList = Storage.getInstance().getDate(number).getScheduleList();
        else
            scheduleList =  Storage.getInstance().getDate(date.getDay()).getScheduleList();

        scheduleAdapter = new  ScheduleAdapter(this, R.layout.schedule_cell, scheduleList);

        nameListView = (ListView)findViewById(R.id.listView_main);
        nameListView.setAdapter(scheduleAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        else if (id == R.id.action_calendar) {
            startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            return true;
        }
        else if (id == R.id.action_today){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
//        scheduleList.clear();
        if(date == null)
            scheduleList = Storage.getInstance().getDate(number).getScheduleList();
        else
            scheduleList = Storage.getInstance().getDate(date.getDay()).getScheduleList();

        scheduleAdapter.notifyDataSetChanged();
    }
}
