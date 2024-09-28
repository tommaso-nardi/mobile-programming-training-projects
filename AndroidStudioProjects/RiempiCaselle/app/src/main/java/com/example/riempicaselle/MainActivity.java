package com.example.riempicaselle;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] valori = new int[]{0,0,0,0,0,0,0,0,0};
    TextView n1,n2,n3,n4,n5,n6,n7,n8,n9;
    Button mode;
    int mod = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode = (Button) findViewById(R.id.mode);
        inizializza();
    }

    public void inizializza(){
        n1 = (TextView) findViewById(R.id.n1); n1.setText(String.valueOf(valori[0]));
        n2 = (TextView) findViewById(R.id.n2); n2.setText(String.valueOf(valori[1]));
        n3 = (TextView) findViewById(R.id.n3); n3.setText(String.valueOf(valori[2]));
        n4 = (TextView) findViewById(R.id.n4); n4.setText(String.valueOf(valori[3]));
        n5 = (TextView) findViewById(R.id.n5); n5.setText(String.valueOf(valori[4]));
        n6 = (TextView) findViewById(R.id.n6); n6.setText(String.valueOf(valori[5]));
        n7 = (TextView) findViewById(R.id.n7); n7.setText(String.valueOf(valori[6]));
        n8 = (TextView) findViewById(R.id.n8); n8.setText(String.valueOf(valori[7]));
        n9 = (TextView) findViewById(R.id.n9); n9.setText(String.valueOf(valori[8]));
        Drawable s = ContextCompat.getDrawable(this, R.drawable.background_bottone);
        n9.setBackground(s);
    }

    public void changemode(View v){
        if (mod == 0){
            mod = 1;
            mode.setText("COLONNA");
        }
        else{
            mod = 0;
            mode.setText("RIGA");
        }
    }

    public void cellacliccata(View v){
        if (mod == 0) incrementariga((TextView) v);
        else incrementacolonna((TextView) v);
    }

    public void incrementariga(TextView v){
        switch(v.getId()){
            case(R.id.n1):
                valori[0]=(valori[0]+=1)%10;valori[1]=(valori[1]+=1)%10;valori[2]=(valori[2]+=1)%10;
                break;
            case(R.id.n2):
                valori[0]=(valori[0]+=1)%10;valori[1]=(valori[1]+=1)%10;valori[2]=(valori[2]+=1)%10;
                break;
            case(R.id.n3):
                valori[0]=(valori[0]+=1)%10;valori[1]=(valori[1]+=1)%10;valori[2]=(valori[2]+=1)%10;
                break;
            case(R.id.n4):
                valori[3]=(valori[3]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[5]=(valori[5]+=1)%10;
                break;
            case(R.id.n5):
                valori[3]=(valori[3]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[5]=(valori[5]+=1)%10;
                break;
            case(R.id.n6):
                valori[3]=(valori[3]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[5]=(valori[5]+=1)%10;
                break;
            case(R.id.n7):
                valori[6]=(valori[6]+=1)%10;valori[7]=(valori[7]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
            case(R.id.n8):
                valori[6]=(valori[6]+=1)%10;valori[7]=(valori[7]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
            case(R.id.n9):
                valori[6]=(valori[6]+=1)%10;valori[7]=(valori[7]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
        }
        aggiornavalori();
    }

    public void incrementacolonna(TextView v){
        switch(v.getId()){
            case(R.id.n1):
                valori[0]=(valori[0]+=1)%10;valori[3]=(valori[3]+=1)%10;valori[6]=(valori[6]+=1)%10;
                break;
            case(R.id.n4):
                valori[0]=(valori[0]+=1)%10;valori[3]=(valori[3]+=1)%10;valori[6]=(valori[6]+=1)%10;
                break;
            case(R.id.n7):
                valori[0]=(valori[0]+=1)%10;valori[3]=(valori[3]+=1)%10;valori[6]=(valori[6]+=1)%10;
                break;
            case(R.id.n2):
                valori[1]=(valori[1]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[7]=(valori[7]+=1)%10;
                break;
            case(R.id.n5):
                valori[1]=(valori[1]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[7]=(valori[7]+=1)%10;
                break;
            case(R.id.n8):
                valori[1]=(valori[1]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[7]=(valori[7]+=1)%10;
                break;
            case(R.id.n3):
                valori[2]=(valori[2]+=1)%10;valori[5]=(valori[5]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
            case(R.id.n6):
                valori[2]=(valori[2]+=1)%10;valori[5]=(valori[5]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
            case(R.id.n9):
                valori[2]=(valori[2]+=1)%10;valori[5]=(valori[5]+=1)%10;valori[8]=(valori[8]+=1)%10;
                break;
        }
        aggiornavalori();
    }

    public void incrementatotale(){
        valori[0]=(valori[0]+=1)%10;valori[1]=(valori[1]+=1)%10;valori[2]=(valori[2]+=1)%10;
        valori[3]=(valori[3]+=1)%10;valori[4]=(valori[4]+=1)%10;valori[5]=(valori[5]+=1)%10;
        valori[6]=(valori[6]+=1)%10;valori[7]=(valori[7]+=1)%10;valori[8]=(valori[8]+=1)%10;
        aggiornavalori();
    }

    public void aggiornavalori(){
        n1.setText(String.valueOf(valori[0]));
        n2.setText(String.valueOf(valori[1]));
        n3.setText(String.valueOf(valori[2]));
        n4.setText(String.valueOf(valori[3]));
        n5.setText(String.valueOf(valori[4]));
        n6.setText(String.valueOf(valori[5]));
        n7.setText(String.valueOf(valori[6]));
        n8.setText(String.valueOf(valori[7]));
        n9.setText(String.valueOf(valori[8]));
    }

    public void reset(View v){
        valori = new int[]{0,0,0,0,0,0,0,0,0};
        inizializza();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        incrementatotale();
    }
}