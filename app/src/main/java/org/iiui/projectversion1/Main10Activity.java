package org.iiui.projectversion1;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main10Activity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        List<String> usersList = new ArrayList();
        Cursor c1 = db.rawQuery("select * from User_Info",null);
        while (c1.moveToNext())
        {
            String username= c1.getString(1) ;
            String useremail=c1.getString(3);
            String h="User Name : "+username+" Email is : "+useremail;
            usersList.add(h);
        }
        ListView lv=(ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, usersList);
        lv.setAdapter(adapter);

        c1.close();
        // db.close();

    }
}
