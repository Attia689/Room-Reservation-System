package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main9Activity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        b1=findViewById(R.id.viewallusers);
        b2=findViewById(R.id.viewallrooms);
        b3=findViewById(R.id.viewallbookings);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main9Activity.this,Main10Activity.class);
                startActivity(i);
            }   });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main9Activity.this,Main11Activity.class);
                startActivity(i);
            }   });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main9Activity.this,Main12Activity.class);
                startActivity(i);
            }   });

    }
}
