package com.a3non.mynotes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by WIN7SP1 on 01/09/2018.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        TextView text1=(TextView) convertView.findViewById(R.id.txt);
       // TextView text2=(TextView) convertView.findViewById(R.id.txt2);

        Contact currentContact=getItem(position);
        text1.setText(currentContact.getName());
       // text2.setText(currentContact.getPhone());


        return convertView;
    }
}
