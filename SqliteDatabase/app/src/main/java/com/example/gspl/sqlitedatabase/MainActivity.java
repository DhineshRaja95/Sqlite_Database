package com.example.gspl.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    Button button,button1,button2,button3;
    Database database;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        editText3=findViewById(R.id.edit3);
        editText4=findViewById(R.id.edit4);
        editText5=findViewById(R.id.edit5);
        editText6=findViewById(R.id.edit6);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.bt1);
        button1=findViewById(R.id.bt2);
        button2=findViewById(R.id.bt3);
        button3=findViewById(R.id.bt4);
        database=new Database(MainActivity.this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=editText1.getText().toString();
                String s2=editText2.getText().toString();
                long obj=database.saves(s1,s2);

                Toast.makeText(MainActivity.this, "save successfully" + obj, Toast.LENGTH_SHORT).show();

            }

        });

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String s3=editText3.getText().toString();
               String obj=database.gett(s3);
               textView.setText(obj);

           }
       });

       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s1=editText4.getText().toString();
               String s2=editText5.getText().toString();
               boolean isupdate=database.updateit(s1,s2);
               if(isupdate==true)
               {
                   Toast.makeText(MainActivity.this, "update successfully", Toast.LENGTH_SHORT).show();
               }else
               {
                   Toast.makeText(MainActivity.this, "Data Invalid", Toast.LENGTH_SHORT).show();
           }
       }
    });

       button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                   Integer deletedRows = database.deleteData(editText6.getText().toString());
                   if(deletedRows > 0)
                       Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                   else
                       Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();

           }
       });

    }
}
