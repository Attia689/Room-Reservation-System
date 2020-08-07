package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static org.iiui.projectversion1.DatabaseContract.Roomreservation.TAB_ROOM;

public class Main6Activity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ImageView img1, img2, img3, img4, img5, img6;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16,t17, t18, t19, t20, t21, t22, t23, t24;
    ArrayList<String> roomlist = new ArrayList<String>();
    ArrayList<String> roomtype = new ArrayList<String>();
    ArrayList<Integer> roomcost = new ArrayList<Integer>();
    ArrayList<Integer> roomoccupied = new ArrayList<Integer>();
    String uname,ucnic,uemail,checkin,checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        dbHelper = new DatabaseHelper(this);

        img1 = findViewById(R.id.pic1);
        img2 = findViewById(R.id.pic2);
        img3 = findViewById(R.id.pic3);
        img4 = findViewById(R.id.pic4);
        img5 = findViewById(R.id.pic5);
        img6 = findViewById(R.id.pic6);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);
        t9 = findViewById(R.id.textView9);
        t10 = findViewById(R.id.textView10);
        t11 = findViewById(R.id.textView11);
        t12 = findViewById(R.id.textView12);
        t13 = findViewById(R.id.textView13);
        t14 = findViewById(R.id.textView14);
        t15 = findViewById(R.id.textView15);
        t16 = findViewById(R.id.textView16);
        t17 = findViewById(R.id.textView17);
        t18 = findViewById(R.id.textView18);
        t19 = findViewById(R.id.textView19);
        t20 = findViewById(R.id.textView20);
        t21 = findViewById(R.id.textView21);
        t22 = findViewById(R.id.textView22);
        t23 = findViewById(R.id.textView23);
        t24 = findViewById(R.id.textView24);

        Intent i = getIntent();
        checkin = i.getStringExtra("checkin");
        checkout = i.getStringExtra("checkout");
        uname= i.getStringExtra("name");
        ucnic = i.getStringExtra("cnic");
        uemail = i.getStringExtra("email");


        db = dbHelper.getReadableDatabase();

        Cursor cursor1 = db.rawQuery("select * from Room_Info", null);
        if (cursor1.getCount() > 0) {

            while(cursor1.moveToNext())
            {
                String name = cursor1.getString(1);
                roomlist.add(name);
                String type = cursor1.getString(2);
                roomtype.add(type);
                int cost = cursor1.getInt(3);
                roomcost.add(cost);
                int occupied = cursor1.getInt(4);
                roomoccupied.add(occupied);
            }
        }

        db.close();

        t1.setText("Room no. " + roomlist.get(0));
        t2.setText("Room type " + roomtype.get(0));
        t3.setText("Room cost " + roomcost.get(0)+" for 24 hours");
        if (roomoccupied.get(0) == 0)
        {
            t4.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(0)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t4.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }

        t5.setText("Room no. " + roomlist.get(1));
        t6.setText("Room type " + roomtype.get(1));
        t7.setText("Room cost " + roomcost.get(1)+" for 24 hours");
        if (roomoccupied.get(1) == 0)
        {
            t8.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(1)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t8.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }

        t9.setText("Room no. " + roomlist.get(2));
        t10.setText("Room type " + roomtype.get(2));
        t11.setText("Room cost " + roomcost.get(2)+" for 24 hours");
        if (roomoccupied.get(2) == 0)
        {
            t12.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(2)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t12.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }

        t13.setText("Room no. " + roomlist.get(3));
        t14.setText("Room type " + roomtype.get(3));
        t15.setText("Room cost " + roomcost.get(3)+" for 24 hours");
        if (roomoccupied.get(3) == 0)
        {
            t16.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(3)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t16.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }

        t17.setText("Room no. " + roomlist.get(4));
        t18.setText("Room type " + roomtype.get(4));
        t19.setText("Room cost " + roomcost.get(4)+" for 24 hours");
        if (roomoccupied.get(4) == 0)
        {
            t20.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(4)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t20.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }

        t21.setText("Room no. " + roomlist.get(5));
        t22.setText("Room type " + roomtype.get(5));
        t23.setText("Room cost " + roomcost.get(5)+" for 24 hours");
        if (roomoccupied.get(5) == 0)
        {
            t24.setText("Available");
        }
        else
        {
            db = dbHelper.getReadableDatabase();
            Cursor cursor2 = db.rawQuery("select * from Room_Dates_Info where RD_NUMBER=?",new String[] {roomlist.get(5)});
            cursor2.moveToNext();
            String date1 = cursor2.getString(2);
            String date2 = cursor2.getString(3);
            t24.setText("Not available for " + date1 + " and " + date2);
            db.close();
        }


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=roomlist.get(0);
                updateRoom(r, true);
                dbHelper.insertRoomInfoDates(r,checkin, checkout);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,r,t);
                int temp=differenceDate(checkin,checkout);
                int sv=roomcost.get(0);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(sv));
                startActivity(i);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                String s=roomlist.get(1);
                updateRoom(s, true);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,s,t);
                dbHelper.insertRoomInfoDates(s,checkin, checkout);
                int temp=differenceDate(checkin,checkout);
                int su=roomcost.get(1);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(su));
                startActivity(i);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=roomlist.get(2);
                updateRoom(r, true);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,r,t);
                dbHelper.insertRoomInfoDates(r,checkin, checkout);
                int temp=differenceDate(checkin,checkout);
                int sv=roomcost.get(2);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(sv));
                startActivity(i);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=roomlist.get(3);
                updateRoom(r, true);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,r,t);
                dbHelper.insertRoomInfoDates(r,checkin, checkout);
                int temp=differenceDate(checkin,checkout);
                int sv=roomcost.get(3);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(sv));
                startActivity(i);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=roomlist.get(4);
                updateRoom(r, true);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,r,t);
                dbHelper.insertRoomInfoDates(r,checkin, checkout);
                int temp=differenceDate(checkin,checkout);
                int sv=roomcost.get(4);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(sv));
                startActivity(i);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=roomlist.get(5);
                updateRoom(r, true);
                String t=roomtype.get(0);
                dbHelper.insertBookingInfo(uname,ucnic,uemail,checkin,checkout,r,t);
                dbHelper.insertRoomInfoDates(r,checkin, checkout);
                int temp=differenceDate(checkin,checkout);
                int sv=roomcost.get(5);
                Intent i=new Intent(Main6Activity.this,Main7Activity.class);
                i.putExtra("no_of_stays",String.valueOf(temp));
                i.putExtra("no_of_stays_cost",String.valueOf(sv));
                startActivity(i);
            }
        });
    }


    public void updateRoom(String roomno,boolean occ)
    {
        db = dbHelper.getWritableDatabase();

        ContentValues args = new ContentValues();
        args.put(DatabaseContract.Roomreservation.R_COL_5,occ);
        String[] wherearg={roomno};
        Integer roomupdate= db.update(TAB_ROOM, args, DatabaseContract.Roomreservation.R_COL_2 + "=?",wherearg);
        if (roomupdate > 0)
        {
            Toast.makeText(this, "  Records updated: "+roomno, Toast.LENGTH_SHORT).show();
        }
        db.close();
    }       //updateroom function finished*/



    public int differenceDate(String ch_in_string,String ch_out_string)
    {
        String a1[];
        a1 = ch_in_string.split("/");
        String s1, s2;
        s1 = a1[0];
        s2 = a1[1];
        int ch_in_day = Integer.parseInt(s1);
        int ch_in_month = Integer.parseInt(s2);


        String a2[];
        a2 = ch_out_string.split("/");
        String r1, r2;
        r1 = a2[0];
        r2 = a2[1];
        int ch_out_day = Integer.parseInt(r1);
        int ch_out_month = Integer.parseInt(r2);

        int result = 0;

        if (ch_in_month == ch_out_month)
        {
            result=ch_out_day-ch_in_day;
        }
        else if(ch_in_month<ch_out_month)
        {
            result=ch_in_day-ch_out_day;
        }
        return result;

    }
}
