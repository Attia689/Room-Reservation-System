package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        List<String> bookingsList = new ArrayList();
        Cursor c1 = db.rawQuery("select * from Booking_Info",null);
        while (c1.moveToNext())
        {
            String bookedbyuser= c1.getString(1) ;
            String bookedroomno=c1.getString(6);
            String h="Room no. "+bookedroomno+" is Booked by "+bookedbyuser;
            bookingsList.add(h);
        }
        ListView lv=(ListView) findViewById(R.id.list3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, bookingsList);
        lv.setAdapter(adapter);

        c1.close();
        // db.close();

    }
}
