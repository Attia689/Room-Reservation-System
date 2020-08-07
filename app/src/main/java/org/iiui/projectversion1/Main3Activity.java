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


public class Main3Activity extends AppCompatActivity {
    DatabaseHelper helper_db;
    EditText editname,editcontact,editemail,editpassword,editconfirmpass;
    Button btn_submit;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        helper_db = new DatabaseHelper(this);      //initialized object

        editname = (EditText) findViewById(R.id.u_name);    //initialized edittexts
        editcontact = (EditText) findViewById(R.id.u_contact);
        editemail = (EditText) findViewById(R.id.u_email);
        editpassword = (EditText) findViewById(R.id.u_password);
        editconfirmpass=(EditText) findViewById(R.id.u_confirm_password);
        btn_submit = (Button) findViewById(R.id.submit);
    }

    public void insertUserData(View v)
    {
        if(( TextUtils.isEmpty(editname.getText()))||( TextUtils.isEmpty(editcontact.getText()))||( TextUtils.isEmpty(editemail.getText()))||( TextUtils.isEmpty(editpassword.getText()))||( TextUtils.isEmpty(editconfirmpass.getText())))
        {
            editname.setError( "Name is required!" );
            editcontact.setError( "Contact is required!" );
            editemail.setError( "Email is required!" );
            editpassword.setError( "Password is required!" );
            editconfirmpass.setError( "Confirm Password is required!" );
        }//empty

        else
        {
            String val1 = editname.getText().toString();
            String val2 = editcontact.getText().toString();
            String val3 = editemail.getText().toString();
            String val4 = editpassword.getText().toString();
            String val5=editconfirmpass.getText().toString();

            db=helper_db.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from User_Info where U_EMAIL=?",new String[] {val3});
            if(cursor.getCount()>0)
            {
                Toast.makeText(this, "User Already Exists", Toast.LENGTH_SHORT).show();
            }
            else
            {
                boolean x=val4.equals(val5);
                if(x==true)
                {
                    db=helper_db.getWritableDatabase();

                    boolean b=helper_db.insertUserInfo(val1,val2,val3,val4);

                    if (b==true)
                    {
                        Toast.makeText(this, "New Record Inserted", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Main3Activity.this, Main2Activity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(this, "New Record Not Inserted", Toast.LENGTH_SHORT).show();
                    }

                    db.close();
                }
                else
                {
                    Toast.makeText(this, "Passwords Mismatched", Toast.LENGTH_SHORT).show();
                }

            }

            db.close();
        }

    }


}
