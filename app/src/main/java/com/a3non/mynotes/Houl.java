package com.a3non.mynotes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Houl extends AppCompatActivity {
    Button b1,b2,b3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houl);

        b1 = (Button)findViewById(R.id.button17);
        b2 = (Button)findViewById(R.id.button18);
        b3 = (Button)findViewById(R.id.button19);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appPackageName = getPackageName(); // getPackageName() طلبنا اسم الباكيج الخاص للتطبيق من هذا التطبيق, لو أردت تقييم تطبيق اخر ضع اسم الباكيج الخاصة به
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));


                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String developerName = "abdullah/hadaf";     //ضع هنا اسم المبرمج الاسم المستخدم في المتجر
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q="+developerName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q="+developerName)));
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,"ملاحظاتي");
                i.putExtra(Intent.EXTRA_TEXT,"دون ملاحظاتك بشكل اسهل  \n https://play.google.com/store/movies/details?id=com.a3non.mynotes ");
                startActivity(Intent.createChooser(i,"ملاحظاتي"));
            }
        });
    }
}
