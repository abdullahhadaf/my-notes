package com.a3non.mynotes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class UpdateActivity extends AppCompatActivity {
    com.a3non.mynotes.MyHelper db;
    EditText edit1;
    EditText edit2;
    Button button ;
    ImageButton ExitubdateJAVA;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edit1=findViewById(R.id.editname);
        //edit2=findViewById(R.id.editphone);
        button=findViewById(R.id.btn);
        ExitubdateJAVA=(ImageButton)findViewById(R.id.exitubdateXML);


        id=getIntent().getIntExtra("id",0);
        db=new MyHelper(this);
        Contact contact=db.getContactId(id);
        edit1.setText(contact.getName());
        //edit2.setText(contact.getPhone());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit1.getText().toString();
               // String phone= edit2.getText().toString();
                Contact newContact=new Contact(name, id);
                db.updateContact(newContact);
                Toast.makeText(UpdateActivity.this,"ok",Toast.LENGTH_SHORT).show();
                Intent update = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(update);

            }
        });
ExitubdateJAVA.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        finishAffinity();
    }
});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                showAlert();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //delete contact
                        db.deleteContact(id);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
