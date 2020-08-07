package org.iiui.projectversion1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static org.iiui.projectversion1.DatabaseContract.Roomreservation.TAB_BOOKING;
import static org.iiui.projectversion1.DatabaseContract.Roomreservation.TAB_ROOM;
import static org.iiui.projectversion1.DatabaseContract.Roomreservation.TAB_ROOM_DATES;
import static org.iiui.projectversion1.DatabaseContract.Roomreservation.TAB_USER;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "fazafour.db";

    String user_sql= "create table " + TAB_USER + "(U_ID INTEGER PRIMARY KEY AUTOINCREMENT,U_NAME TEXT,U_CONTACT TEXT" +
            ",U_EMAIL TEXT,U_PASS TEXT)";

    String room_sql= "create table " + TAB_ROOM + "(R_ID INTEGER PRIMARY KEY AUTOINCREMENT,R_NUMBER TEXT,R_TYPE TEXT" +
            ",R_COST TEXT,R_OCCUPIED TEXT)";

    String room_dates_sql= "create table " + TAB_ROOM_DATES + "(RD_ID INTEGER PRIMARY KEY AUTOINCREMENT,RD_NUMBER TEXT,RD_CHECKIN TEXT" +
            ",RD_CHECKOUT TEXT)";

    String booking_sql= "create table " + TAB_BOOKING + "(B_ID INTEGER PRIMARY KEY AUTOINCREMENT,B_NAME TEXT,B_CNIC TEXT" +
            ",B_EMAIL TEXT,B_CHECKIN TEXT,B_CHECKOUT TEXT,B_ROOMNO TEXT,B_ROOMTYPE TEXT)";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(user_sql);
        db.execSQL(room_sql);
        db.execSQL(room_dates_sql);
        db.execSQL(booking_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion)
    {
        if (oldversion >= newversion)
        {return;}
        String sql = null;
        if (oldversion == 1)
        {sql = "alter table " + TAB_USER + " add note text;";  }
        if (oldversion == 2)
        {sql = "";}
        Log.d("EventsData", "onUpgrade : " + sql);
        if (sql != null)
        {db.execSQL(sql);}
    }

    public boolean insertRoomInfoDates(String rno,String chin, String chout)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Roomreservation.RD_COL_2, rno);
        values.put(DatabaseContract.Roomreservation.RD_COL_3, chin);
        values.put(DatabaseContract.Roomreservation.RD_COL_4, chout);

        long newRowId = db.insert(TAB_ROOM_DATES, null, values);

        if (newRowId == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insertRoomInfo(String number, String type,int cost, boolean occupied)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Roomreservation.R_COL_2, number);
        values.put(DatabaseContract.Roomreservation.R_COL_3, type);
        values.put(DatabaseContract.Roomreservation.R_COL_4, cost);
        values.put(DatabaseContract.Roomreservation.R_COL_5, occupied);

        long newRowId = db.insert(TAB_ROOM, null, values);

        if (newRowId == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insertUserInfo(String name, String contact, String email, String pass)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Roomreservation.U_COL_2, name);
        values.put(DatabaseContract.Roomreservation.U_COL_3, contact);
        values.put(DatabaseContract.Roomreservation.U_COL_4, email);
        values.put(DatabaseContract.Roomreservation.U_COL_5, pass);

        long newRowId = db.insert(TAB_USER, null, values);

        if (newRowId == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insertBookingInfo(String name,String cnic, String email, String checkin, String checkout ,String roomno,String roomtype)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Roomreservation.B_COL_2, name);
        values.put(DatabaseContract.Roomreservation.B_COL_3, cnic);
        values.put(DatabaseContract.Roomreservation.B_COL_4, email);
        values.put(DatabaseContract.Roomreservation.B_COL_5, checkin);
        values.put(DatabaseContract.Roomreservation.B_COL_6, checkout);
        values.put(DatabaseContract.Roomreservation.B_COL_7, roomno);
        values.put(DatabaseContract.Roomreservation.B_COL_8, roomtype);

        long newRowId = db.insert(TAB_BOOKING, null, values);

        if (newRowId == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}


