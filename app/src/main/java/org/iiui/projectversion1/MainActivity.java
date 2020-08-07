package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    Button admin,user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        dbHelper.insertRoomInfo("RC001","Single",10000,false);
        dbHelper.insertRoomInfo("RC002","Double",15000,false);
        dbHelper.insertRoomInfo("RC003","Triple",20000,false);
        dbHelper.insertRoomInfo("RC004","Single",10000,false);
        dbHelper.insertRoomInfo("RC005","Double",15000,false);
        dbHelper.insertRoomInfo("RC006","Triple",20000,false);
        dbHelper.insertRoomInfo("RC007","Single",10000,false);
        dbHelper.insertRoomInfo("RC008","Double",15000,false);
        dbHelper.insertRoomInfo("RC009","Triple",20000,false);
        dbHelper.insertRoomInfo("RC010","Single",10000,false);

        boolean b1=dbHelper.insertUserInfo("nazia","090051876","nazia@gmail.com","abc");
        boolean b2=dbHelper.insertUserInfo("amna","034258791","amna@gmail.com","def");
        boolean b3=dbHelper.insertUserInfo("asma","045619718","asma@gmail.com","ghi");
        boolean b4=dbHelper.insertUserInfo("fareeha","068925217","fareeha@gmail.com","jkl");

        admin=findViewById(R.id.admin_login);
        user=findViewById(R.id.user_login);

        admin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(MainActivity.this,Main8Activity.class);
                startActivity(i);
            }   });


        user.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }   });

    }



}
