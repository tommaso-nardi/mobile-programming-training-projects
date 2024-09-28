package com.example.giocodel8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] valori = new String[9];
    int cont=0,indexvuoto=0,indexcliccato=0;
    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,mosse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mosse = (TextView) findViewById(R.id.mosse);
        inizializza();
        posiziona();
        bloccaclick();
    }

    public void inizializza(){
        for (int i=0; i<8;i++){
            valori[i]=String.valueOf(i+1);
        }
        valori[8]="";
        List<String> strList = Arrays.asList(valori);
        Collections.shuffle(strList);
        valori = strList.toArray(new String[strList.size()]);
    }

    public void posiziona(){
        b1 = (TextView) findViewById(R.id.b1); b1.setText(String.valueOf(valori[0]));
        b2 = (TextView) findViewById(R.id.b2); b2.setText(String.valueOf(valori[1]));
        b3 = (TextView) findViewById(R.id.b3); b3.setText(String.valueOf(valori[2]));
        b4 = (TextView) findViewById(R.id.b4); b4.setText(String.valueOf(valori[3]));
        b5 = (TextView) findViewById(R.id.b5); b5.setText(String.valueOf(valori[4]));
        b6 = (TextView) findViewById(R.id.b6); b6.setText(String.valueOf(valori[5]));
        b7 = (TextView) findViewById(R.id.b7); b7.setText(String.valueOf(valori[6]));
        b8 = (TextView) findViewById(R.id.b8); b8.setText(String.valueOf(valori[7]));
        b9 = (TextView) findViewById(R.id.b9); b9.setText(String.valueOf(valori[8]));
    }

    public void reset(View v){
        inizializza();
        posiziona();
        bloccaclick();
        cont=0;
        mosse.setText("Mosse: "+String.valueOf(cont));
    }

    public void clicknumero(View v){
        indexcliccato = trovacliccato((TextView) v);
        String temp = valori[indexvuoto];
        valori[indexvuoto]=valori[indexcliccato];
        valori[indexcliccato]=temp;
        cont=cont+1;
        mosse.setText("Mosse: "+String.valueOf(cont));
        posiziona();
        bloccaclick();

    }

    public void bloccaclick()
    {
        bloccatutto();
        indexvuoto = trovavuotoindex();
        TextView t = trovavuoto(indexvuoto);
        switch(t.getId()){
            case(R.id.b1):
                b2.setEnabled(true);
                b4.setEnabled(true);
                break;
            case(R.id.b2):
                b1.setEnabled(true);
                b3.setEnabled(true);
                b5.setEnabled(true);
                break;
            case(R.id.b3):
                b2.setEnabled(true);
                b6.setEnabled(true);
                break;
            case(R.id.b4):
                b1.setEnabled(true);
                b5.setEnabled(true);
                b7.setEnabled(true);
                break;
            case(R.id.b5):
                b2.setEnabled(true);
                b4.setEnabled(true);
                b6.setEnabled(true);
                b8.setEnabled(true);
                break;
            case(R.id.b6):
                b3.setEnabled(true);
                b5.setEnabled(true);
                b9.setEnabled(true);
                break;
            case(R.id.b7):
                b4.setEnabled(true);
                b8.setEnabled(true);
                break;
            case(R.id.b8):
                b5.setEnabled(true);
                b7.setEnabled(true);
                b9.setEnabled(true);
                break;
            case(R.id.b9):
                b6.setEnabled(true);
                b8.setEnabled(true);
                break;
        }
    }

    public void bloccatutto(){
        b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);
        b4.setEnabled(false);b5.setEnabled(false);b6.setEnabled(false);
        b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }

    public int trovavuotoindex(){
        for (int i=0;i<9;i++){
            if (valori[i]==""){
                return i;
            }
        }
        return 0;
    }

    public TextView trovavuoto(int n){
        TextView r=null;
        switch (n){
            case(0):
                r=b1;break;
            case(1):
                r=b2;break;
            case(2):
                r=b3;break;
            case(3):
                r=b4;break;
            case(4):
                r=b5;break;
            case(5):
                r=b6;break;
            case(6):
                r=b7;break;
            case(7):
                r=b8;break;
            case(8):
                r=b9;break;
        }
        return r;
    }

    public int trovacliccato(TextView v){
        int i=0,j;
        for (j=0;j<9;j++){
            if (valori[j]==v.getText()){
                i=j;
            }
        }
        return i;
    }
}