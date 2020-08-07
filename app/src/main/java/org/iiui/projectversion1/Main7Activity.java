package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {

    Button returntohomescreen;
    int stays,staycost,payment;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        t1=findViewById(R.id.txt2);
        t2=findViewById(R.id.txt3);
        t3=findViewById(R.id.txt4);

        String e = getIntent().getExtras().getString("no_of_stays");
        stays=Integer.parseInt(e);

        String ee = getIntent().getExtras().getString("no_of_stays_cost");
        staycost=Integer.parseInt(ee);

        payment=stays*staycost;

        t1.setText("Your no. of stays are: "+stays);
        t2.setText("Your selected room cost is:"+staycost);
        t3.setText("Total Payment is: "+payment+" and it will be done through cash");

        returntohomescreen=findViewById(R.id.returnhomefrombooking);

        returntohomescreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main7Activity.this,Main4Activity.class);
                startActivity(i);
            }   });
    }
}
