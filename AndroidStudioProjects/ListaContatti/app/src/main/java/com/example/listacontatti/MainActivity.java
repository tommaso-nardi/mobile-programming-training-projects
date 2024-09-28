package com.example.listacontatti;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> itemList;
    private CustomAdapter adapter;
    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        listView = findViewById(R.id.listView);

        itemList = new ArrayList<>();
        adapter = new CustomAdapter(this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            itemList.remove(position);
            adapter.notifyDataSetChanged();
        });
    }

    public void aggiungi(View v){
        String name = editTextName.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        if (!name.isEmpty() && !phoneNumber.isEmpty()) {
            Item item = new Item(name, phoneNumber);
            itemList.add(item);
            adapter.notifyDataSetChanged();
            editTextName.setText("");
            editTextPhoneNumber.setText("");
        } else {
            Toast.makeText(MainActivity.this, "Inserisci nome e numero di telefono", Toast.LENGTH_SHORT).show();
        }
    }

}
