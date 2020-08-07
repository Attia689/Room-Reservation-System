package org.iiui.projectversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    EditText editemail,editpass;
    Button create_acc,signin;
    String check_email,check_pass;
    boolean r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

        signin=findViewById(R.id.sign_in);
        create_acc=findViewById(R.id.create_account);
        editemail=findViewById(R.id.input_email);
        editpass=findViewById(R.id.input_password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(( TextUtils.isEmpty(editemail.getText()))||( TextUtils.isEmpty(editpass.getText())))
                {
                    editemail.setError( "Email is required!" );
                    editpass.setError( "Password is required!" );
                }//empty

                else
                {
                    check_email=editemail.getText().toString();
                    check_pass=editpass.getText().toString();

                    Cursor c = db.rawQuery("select * from User_Info where U_EMAIL=? and U_PASS=?",new String[] {check_email,check_pass});
                    if(c.getCount()>0)
                    {
                        r1=true;
                    }
                    else
                    {
                        r1=false;
                    }


                    if(r1==true)
                    {
                        Toast.makeText(Main2Activity.this,"Login successful",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Main2Activity.this,Main4Activity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Main2Activity.this,"You don't have any account yet",Toast.LENGTH_SHORT).show();
                    }

                }

            }

        });


        create_acc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }   });

    }
}




