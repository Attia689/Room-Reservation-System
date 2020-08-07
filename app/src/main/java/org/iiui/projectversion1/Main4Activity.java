package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {
    Button btnroombook,btngallery,btnservices,btnfeedback,btnabout,btncontact,btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnroombook=findViewById(R.id.roombook);
        btngallery=findViewById(R.id.gallery);
        btnservices=findViewById(R.id.services);
        btnfeedback=findViewById(R.id.feedback);
        btnabout=findViewById(R.id.about);
        btncontact=findViewById(R.id.contactus);
        btnlogout=findViewById(R.id.logout);

        btnroombook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(i);
            }   });

        btngallery.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main13Activity.class);
                startActivity(i);
            }   });

        btnfeedback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main17Activity.class);
                startActivity(i);
            }   });

        btnservices.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main14Activity.class);
                startActivity(i);
            }   });

        btnabout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main15Activity.class);
                startActivity(i);
            }   });

        btncontact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,Main16Activity.class);
                startActivity(i);
            }   });

        btnlogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main4Activity.this,MainActivity.class);
                startActivity(i);
            }   });
    }


}
