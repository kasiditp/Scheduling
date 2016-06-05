package com.ske.scheduling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Date;

import Model.Calendar;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initComponent();
    }

    private void initComponent(){
        calendarView = (CalendarView) findViewById(R.id.calendar_id);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Date date = new Date(year,month,dayOfMonth);
                Toast.makeText(getApplicationContext(), year+"/"+month+"/"+dayOfMonth,Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(CalendarActivity.this, MainActivity.class));
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("DATE", date);
                startActivity(intent);
            }
        });
    }
}
