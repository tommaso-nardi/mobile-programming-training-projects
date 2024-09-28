package com.example.campominato;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Drawable safe,bomb,base;
    int[] celle = new int[16];
    int max,clicks;
    TextView[] vista = new TextView[16];
    TextView sconfitta,vittoria, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizializza();
    }

    public void inizializza(){
        safe = ContextCompat.getDrawable(this, R.drawable.background_safe);
        bomb = ContextCompat.getDrawable(this, R.drawable.background_bomb);
        base = ContextCompat.getDrawable(this, R.drawable.background_cella);
        vittoria = (TextView) findViewById(R.id.vittoria);
        sconfitta = (TextView) findViewById(R.id.sconfitta);
        reset = (TextView) findViewById(R.id.reset);
        clicks=0;
        Random rand = new Random();
        max = 4;
        for (int i=0;i<16;i++){
            celle[i] = rand.nextInt(2);
            if (celle[i]==1){
                if (max!=0){
                    max=max-1;
                }
                else
                    celle[i]=0;
            }
        }
        vista[0] = (TextView) findViewById(R.id.c1); vista[5] = (TextView) findViewById(R.id.c6); vista[10] = (TextView) findViewById(R.id.c11);
        vista[1] = (TextView) findViewById(R.id.c2); vista[6] = (TextView) findViewById(R.id.c7); vista[11] = (TextView) findViewById(R.id.c12);
        vista[2] = (TextView) findViewById(R.id.c3); vista[7] = (TextView) findViewById(R.id.c8); vista[12] = (TextView) findViewById(R.id.c13);
        vista[3] = (TextView) findViewById(R.id.c4); vista[8] = (TextView) findViewById(R.id.c9); vista[13] = (TextView) findViewById(R.id.c14);
        vista[4] = (TextView) findViewById(R.id.c5); vista[9] = (TextView) findViewById(R.id.c10); vista[14] = (TextView) findViewById(R.id.c15); vista[15] = (TextView) findViewById(R.id.c16);
    }

    public void cellacliccata(View v){
        int ind = getIndice(v);
        if (celle[ind]==0){
            vista[ind].setBackground(safe);
            vista[ind].setText(scan(ind));
            vista[ind].setEnabled(false);
            clicks+=1;
            if (clicks==12) vittoria();
        }
        else{
            vista[ind].setBackground(bomb);
            sconfitta();
        }
    }

    public int getIndice(View v){
        int i=0;
        switch(v.getId()){
            case(R.id.c1): i=0; break; case(R.id.c9): i=8; break;
            case(R.id.c2): i=1; break; case(R.id.c10): i=9; break;
            case(R.id.c3): i=2; break; case(R.id.c11): i=10; break;
            case(R.id.c4): i=3; break; case(R.id.c12): i=11; break;
            case(R.id.c5): i=4; break; case(R.id.c13): i=12; break;
            case(R.id.c6): i=5; break; case(R.id.c14): i=13; break;
            case(R.id.c7): i=6; break; case(R.id.c15): i=14; break;
            case(R.id.c8): i=7; break; case(R.id.c16): i=15; break;
        }
        return i;
    }

    public String scan(int ind){
        int i=0;
        String empty="";
        switch(ind){
            case(0):
                if (celle[1]==1) i+=1;
                if (celle[4]==1) i+=1;
                if (celle[5]==1) i+=1;
                break;
            case(1):
                if (celle[0]==1) i+=1;
                if (celle[2]==1) i+=1;
                if (celle[4]==1) i+=1;
                if (celle[5]==1) i+=1;
                if (celle[6]==1) i+=1;
                break;
            case(2):
                if (celle[1]==1) i+=1;
                if (celle[3]==1) i+=1;
                if (celle[5]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[7]==1) i+=1;
                break;
            case(3):
                if (celle[2]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[7]==1) i+=1;
                break;
            case(4):
                if (celle[5]==1) i+=1;
                if (celle[0]==1) i+=1;
                if (celle[8]==1) i+=1;
                if (celle[1]==1) i+=1;
                if (celle[9]==1) i+=1;
                break;
            case(5):
                if (celle[4]==1) i+=1;
                if (celle[1]==1) i+=1;
                if (celle[0]==1) i+=1;
                if (celle[2]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[8]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[10]==1) i+=1;
                break;
            case(6):
                if (celle[2]==1) i+=1;
                if (celle[1]==1) i+=1;
                if (celle[3]==1) i+=1;
                if (celle[5]==1) i+=1;
                if (celle[7]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[11]==1) i+=1;
                break;
            case(7):
                if (celle[2]==1) i+=1;
                if (celle[3]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[11]==1) i+=1;
                break;
            case(8):
                if (celle[4]==1) i+=1;
                if (celle[5]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[12]==1) i+=1;
                if (celle[13]==1) i+=1;
                break;
            case(9):
                if (celle[4]==1) i+=1;
                if (celle[5]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[8]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[12]==1) i+=1;
                if (celle[13]==1) i+=1;
                if (celle[14]==1) i+=1;
                break;
            case(10):
                if (celle[5]==1) i+=1;
                if (celle[6]==1) i+=1;
                if (celle[7]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[11]==1) i+=1;
                if (celle[13]==1) i+=1;
                if (celle[14]==1) i+=1;
                if (celle[15]==1) i+=1;
                break;
            case(11):
                if (celle[6]==1) i+=1;
                if (celle[7]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[14]==1) i+=1;
                if (celle[15]==1) i+=1;
                break;
            case(12):
                if (celle[8]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[13]==1) i+=1;
                break;
            case(13):
                if (celle[8]==1) i+=1;
                if (celle[9]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[12]==1) i+=1;
                if (celle[14]==1) i+=1;
                break;
            case(14):
                if (celle[9]==1) i+=1;
                if (celle[10]==1) i+=1;
                if (celle[11]==1) i+=1;
                if (celle[13]==1) i+=1;
                if (celle[15]==1) i+=1;
                break;
            case(15):
                if (celle[10]==1) i+=1;
                if (celle[11]==1) i+=1;
                if (celle[14]==1) i+=1;
                break;
        }
        if (i==0)
        return empty;
        return String.valueOf(i);
    }

    public void sconfitta(){
        for (int i=0;i<16;i++){
            if (celle[i]==1){
                vista[i].setBackground(bomb);
            }
            vista[i].setEnabled(false);
        }
        sconfitta.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
    }

    public void vittoria(){
        for (int i=0;i<16;i++){
            if (celle[i]==1){
                vista[i].setBackground(bomb);
                vista[i].setEnabled(false);
            }
        }
        vittoria.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
    }

    public void reset(View v){
        for (int i=0;i<16;i++){
                vista[i].setBackground(base);
                vista[i].setEnabled(true);
                vista[i].setText("");
        }
        vittoria.setVisibility(View.INVISIBLE);
        sconfitta.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        inizializza();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}