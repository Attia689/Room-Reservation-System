package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    EditText edemail,edpass;
    Button adsignin;
    String check_ademail,check_adpass;
    boolean r1,r2;
    String e="faza@gmail.com";
    String p="faza4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        adsignin=findViewById(R.id.admin_sign_in);
        edemail=findViewById(R.id.admin_email);
        edpass=findViewById(R.id.admin_password);

        adsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(( TextUtils.isEmpty(edemail.getText()))||( TextUtils.isEmpty(edpass.getText())))
                {
                    edemail.setError( "Email is required!" );
                    edpass.setError( "Password is required!" );
                }//empty

                else
                {
                    check_ademail=edemail.getText().toString();
                    check_adpass=edpass.getText().toString();

                    r1=check_ademail.equalsIgnoreCase(e);
                    r2=check_adpass.equalsIgnoreCase(p);

                       if((r1==true)&&(r2==true))
                    {
                        Toast.makeText(Main8Activity.this,"Login successful",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Main8Activity.this,Main9Activity.class);
                        startActivity(i);
                    }
         else
                {
                    Toast.makeText(Main8Activity.this,"Incorrect credentials",Toast.LENGTH_SHORT).show();
                }

                }

            }

        });

    }
}




