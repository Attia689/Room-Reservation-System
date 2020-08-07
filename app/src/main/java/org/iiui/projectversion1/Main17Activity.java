package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main17Activity extends AppCompatActivity {

    Button b;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        b= findViewById(R.id.submitfeedback);
        e=findViewById(R.id.message);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if( TextUtils.isEmpty(e.getText()))
                {
                    e.setError( "Feedback is required!" );
                }//empty
                else
                {
                    Intent i=new Intent(Main17Activity.this,Main4Activity.class);
                    startActivity(i);
                }
            }   });
    }
}
