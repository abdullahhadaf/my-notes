package com.a3non.mynotes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class AddActivity extends AppCompatActivity {

    EditText edit1;
    Button button2;
    ImageButton  ExitaddJAVA;
    ImageView ImageViewJAVA;
    MyHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edit1=findViewById(R.id.editname);
        ImageViewJAVA=findViewById(R.id.imageViewXML);
        //edit2=findViewById(R.id.editphone);
        button2=findViewById(R.id.aboutXML);
        ExitaddJAVA=(ImageButton)findViewById(R.id.exitaddXML);
        db =new MyHelper(this);
        ImageViewJAVA.setOnClickListener(new View.OnClickListener() {
            private int id;

            @Override
            public void onClick(View v) {
                String name=edit1.getText().toString();
               // String phone=edit2.getText().toString();
                Contact contact=new Contact(name, id);
                db.addContact(contact);
                Toast.makeText(AddActivity.this,"Data added",Toast.LENGTH_SHORT).show();
                Intent add =new Intent(AddActivity.this,MainActivity.class);
                startActivity(add);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about= new Intent(AddActivity.this,Houl.class);
                startActivity(about);
            }
        });
        ExitaddJAVA.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}
