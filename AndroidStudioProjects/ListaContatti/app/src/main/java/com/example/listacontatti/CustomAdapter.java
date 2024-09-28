package com.example.listacontatti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {
    private Context context;
    private List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Item item = items.get(position);

        TextView nameTextView = convertView.findViewById(R.id.textViewName);
        TextView phoneNumberTextView = convertView.findViewById(R.id.textViewPhoneNumber);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        nameTextView.setText(item.getName());
        phoneNumberTextView.setText(item.getPhoneNumber());
        imageView.setImageResource(R.drawable.ic_default_photo); // Assicurati di avere questa immagine nella cartella drawable

        return convertView;
    }
}
