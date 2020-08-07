package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main16Activity extends AppCompatActivity {

    TextView loc,pho,ema,f1,f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        loc=findViewById(R.id.location);
        pho=findViewById(R.id.phoneno);
        ema=findViewById(R.id.email);
        f1=findViewById(R.id.facebook1);
        f2=findViewById(R.id.facebook2);

        loc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url="https://www.google.com/maps/place/F-7,+Islamabad,+Islamabad+Capital+Territory/@33.7201055,73.0396641,14z/data=!3m1!4b1!4m5!3m4!1s0x38dfbfa6d5a2c555:0xf6c7d42af7275c26!8m2!3d33.7220384!4d73.0570372";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }   });

        pho.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri number = Uri.parse("tel:03325645166");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }   });

        ema.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url="https://mail.google.com/mail/u/0/#inbox";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }   });

        f1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url="https://www.facebook.com/attia.zafar.5";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }   });

        f2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String url="https://www.facebook.com/profile.php?id=100012523294220";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }   });


    }
}
