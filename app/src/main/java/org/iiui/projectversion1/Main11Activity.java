package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main11Activity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        List<String> roomsList = new ArrayList();
        Cursor c1 = db.rawQuery("select * from Room_Info",null);
        while (c1.moveToNext())
        {
            String roomno= c1.getString(1) ;
            String roomtype=c1.getString(2);
            String h="Room no. : "+roomno+" Roomtype : "+roomtype;
            roomsList.add(h);
        }
        ListView lv=(ListView) findViewById(R.id.list2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, roomsList);
        lv.setAdapter(adapter);

        c1.close();
        // db.close();

    }
}
