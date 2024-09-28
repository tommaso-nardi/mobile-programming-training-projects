package com.example.memorycarte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] valori = new int[16];
    int cont=0;
    private static Random random;
    TextView csalvata, cattuale, dsalvata, dattuale;
    TextView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,retry;
    TextView tent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tent=(TextView) findViewById(R.id.tentativiTextView);
        inizializza();
        shuffle(valori);
        posizionanumeri();
        nascondi();
    }

    public void dorsoCliccato(View v){
        if (dsalvata == null){
            v.setVisibility(View.INVISIBLE);
            dsalvata = (TextView) v;
            csalvata = salvaCarta(v);
            csalvata.setVisibility(View.VISIBLE);
        }
        else
        {
            v.setVisibility(View.INVISIBLE);
            dattuale = (TextView) v;
            cattuale = salvaCarta(v);
            cattuale.setVisibility(View.VISIBLE);
            if (confronto(csalvata, cattuale) == 0){
                cont=cont+1;
                tent.setText("Tentativi: "+cont);
                TextView d1=findViewById(R.id.d1); //SOLUZIONEEEEH
                d1.setEnabled(false);
            }
            csalvata = null; dsalvata = null; cattuale = null; dattuale = null;
        }
    }

    public void inizializza() {
        for (int i=0; i<8; i++)
        {
            valori[2*i]=i+1;
            valori[2*i+1]=i+1;
        }
    }

    public void shuffle(int[] array) {
        if (random == null) random = new
                Random();
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void posizionanumeri(){
        c1 = (TextView) findViewById(R.id.c1); c1.setText(String.valueOf(valori[0]));
        c2 = (TextView) findViewById(R.id.c2); c2.setText(String.valueOf(valori[1]));
        c3 = (TextView) findViewById(R.id.c3); c3.setText(String.valueOf(valori[2]));
        c4 = (TextView) findViewById(R.id.c4); c4.setText(String.valueOf(valori[3]));
        c5 = (TextView) findViewById(R.id.c5); c5.setText(String.valueOf(valori[4]));
        c6 = (TextView) findViewById(R.id.c6); c6.setText(String.valueOf(valori[5]));
        c7 = (TextView) findViewById(R.id.c7); c7.setText(String.valueOf(valori[6]));
        c8 = (TextView) findViewById(R.id.c8); c8.setText(String.valueOf(valori[7]));
        c9 = (TextView) findViewById(R.id.c9); c9.setText(String.valueOf(valori[8]));
        c10 = (TextView) findViewById(R.id.c10); c10.setText(String.valueOf(valori[9]));
        c11 = (TextView) findViewById(R.id.c11); c11.setText(String.valueOf(valori[10]));
        c12 = (TextView) findViewById(R.id.c12); c12.setText(String.valueOf(valori[11]));
        c13 = (TextView) findViewById(R.id.c13); c13.setText(String.valueOf(valori[12]));
        c14 = (TextView) findViewById(R.id.c14); c14.setText(String.valueOf(valori[13]));
        c15 = (TextView) findViewById(R.id.c15); c15.setText(String.valueOf(valori[14]));
        c16 = (TextView) findViewById(R.id.c16); c16.setText(String.valueOf(valori[15]));
    }

    public TextView salvaCarta(View v){
        TextView r = (TextView) findViewById(R.id.c1);
        switch(v.getId()){
            case(R.id.d1):
                r = (TextView) findViewById(R.id.c1); break;
            case(R.id.d2):
                r = (TextView) findViewById(R.id.c2); break;
            case(R.id.d3):
                r = (TextView) findViewById(R.id.c3); break;
            case(R.id.d4):
                r = (TextView) findViewById(R.id.c4); break;
            case(R.id.d5):
                r = (TextView) findViewById(R.id.c5); break;
            case(R.id.d6):
                r = (TextView) findViewById(R.id.c6); break;
            case(R.id.d7):
                r = (TextView) findViewById(R.id.c7); break;
            case(R.id.d8):
                r = (TextView) findViewById(R.id.c8); break;
            case(R.id.d9):
                r = (TextView) findViewById(R.id.c9); break;
            case(R.id.d10):
                r = (TextView) findViewById(R.id.c10); break;
            case(R.id.d11):
                r = (TextView) findViewById(R.id.c11); break;
            case(R.id.d12):
                r = (TextView) findViewById(R.id.c12); break;
            case(R.id.d13):
                r = (TextView) findViewById(R.id.c13); break;
            case(R.id.d14):
                r = (TextView) findViewById(R.id.c14); break;
            case(R.id.d15):
                r = (TextView) findViewById(R.id.c15); break;
            case(R.id.d16):
                r = (TextView) findViewById(R.id.c16); break;
        }
        return r;
    }

    public void nascondi(){
        c1.setVisibility(View.INVISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
        c4.setVisibility(View.INVISIBLE);
        c5.setVisibility(View.INVISIBLE);
        c6.setVisibility(View.INVISIBLE);
        c7.setVisibility(View.INVISIBLE);
        c8.setVisibility(View.INVISIBLE);
        c9.setVisibility(View.INVISIBLE);
        c10.setVisibility(View.INVISIBLE);
        c11.setVisibility(View.INVISIBLE);
        c12.setVisibility(View.INVISIBLE);
        c13.setVisibility(View.INVISIBLE);
        c14.setVisibility(View.INVISIBLE);
        c15.setVisibility(View.INVISIBLE);
        c16.setVisibility(View.INVISIBLE);
    }

    public int confronto(TextView v1, TextView v2){
        int r=0;
        if (v1.getText() == v2.getText()){
            r=1;
        }
        return r;
    }
}