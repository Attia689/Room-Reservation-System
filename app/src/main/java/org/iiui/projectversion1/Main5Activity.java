package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Main5Activity extends AppCompatActivity {
    EditText username, usercnic, useremail, usercheckindate, usercheckoutdate;
    Button submitbooking;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        username = findViewById(R.id.enterredname);
        usercnic = findViewById(R.id.enterredcnic);
        useremail = findViewById(R.id.enterredemail);
        usercheckindate = findViewById(R.id.enterredcheckindate);
        usercheckoutdate = findViewById(R.id.enterredcheckoutdate);
        submitbooking = findViewById(R.id.btnbooking);

        dbHelper = new DatabaseHelper(this);

        usercheckindate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Get Current Date
                int mYear1, mMonth1, mDay1;
                final Calendar c1 = Calendar.getInstance();
                mYear1 = c1.get(Calendar.YEAR);
                mMonth1 = c1.get(Calendar.MONTH);
                mDay1 = c1.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog1 = new DatePickerDialog(Main5Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                usercheckindate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear1, mMonth1, mDay1);

                datePickerDialog1.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog1.show();
            }
        });     //check in date picker finished

        usercheckoutdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Get Current Date
                int mYear2, mMonth2, mDay2;
                final Calendar c2 = Calendar.getInstance();
                mYear2 = c2.get(Calendar.YEAR);
                mMonth2 = c2.get(Calendar.MONTH);
                mDay2 = c2.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog2 = new DatePickerDialog(Main5Activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                usercheckoutdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear2, mMonth2, mDay2);

                datePickerDialog2.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog2.show();
            }
        });    //check out date picker finished

        submitbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(( TextUtils.isEmpty(username.getText()))||( TextUtils.isEmpty(usercnic.getText()))||( TextUtils.isEmpty(useremail.getText()))||( TextUtils.isEmpty(usercheckindate.getText()))||( TextUtils.isEmpty(usercheckoutdate.getText())))
                {
                    username.setError( "Name is required!" );
                    usercnic.setError( "CNIC is required!" );
                    useremail.setError( "Email is required!" );
                    usercheckindate.setError( "Checkin Date is required!" );
                    usercheckoutdate.setError( "Checkout Date is required!" );
                }//empty

                else
                {
                    String val1= username.getText().toString();
                    String val2=usercnic.getText().toString();
                    String val3= useremail.getText().toString();
                    String val4 = usercheckindate.getText().toString();
                    String val5 = usercheckoutdate.getText().toString();

                    boolean k=dateComparison(val4,val5);

                    if (k==true)
                    {
                        Toast.makeText(Main5Activity.this, "Booking successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Main5Activity.this,Main6Activity.class);
                        i.putExtra("name",val1);
                        i.putExtra("cnic",val2);
                        i.putExtra("email",val3);
                        i.putExtra("checkin",val4);
                        i.putExtra("checkout",val5);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Main5Activity.this, "Incorrect Dates", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
    public boolean dateComparison(String d1,String d2)
    {
        String a1[];
        a1 = d1.split("/");
        String s1, s2;
        s1 = a1[0];
        s2 = a1[1];
        int ch_in_day = Integer.parseInt(s1);
        int ch_in_month = Integer.parseInt(s2);

        String a2[];
        a2 = d2.split("/");
        String r1, r2;
        r1 = a2[0];
        r2 = a2[1];
        int ch_out_day = Integer.parseInt(r1);
        int ch_out_month = Integer.parseInt(r2);

        boolean x = false;

        if(ch_in_month==ch_out_month)
        {
            if((ch_in_day==ch_out_day)||(ch_in_day<ch_out_day))
            {
                x=true;
            } //same day or checkin date smaller than checkout
            else
            {
                x=false;
            }//check out if greater
        } //same months

        else  if(ch_out_month>ch_in_month)
        {
            if(ch_out_day<=ch_in_day)
            {
                x=true;
            }
            else
            {
                x=false;
            }
        }//months not same
        return x;
    }
}
