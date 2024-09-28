package com.example.calcolatricebinaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] valori = new int[8];
    int mod=0;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,cont;
    Button s2,s4,mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont = (TextView) findViewById(R.id.valore);
        s2 = (Button) findViewById(R.id.s2);
        s4 = (Button) findViewById(R.id.s4);
        mode = (Button) findViewById(R.id.mod);
        inizializza();
        inseriscivalori();
    }

    public void inizializza(){
        Random random = new Random();
        for (int i = 0; i < valori.length; i++) {
            valori[i] = random.nextInt(2);
        }
    }

    public void inseriscivalori(){
        t1 =(TextView) findViewById(R.id.n1); t1.setText(String.valueOf(valori[0]));
        t2 =(TextView) findViewById(R.id.n2); t2.setText(String.valueOf(valori[1]));
        t3 =(TextView) findViewById(R.id.n3); t3.setText(String.valueOf(valori[2]));
        t4 =(TextView) findViewById(R.id.n4); t4.setText(String.valueOf(valori[3]));
        t5 =(TextView) findViewById(R.id.n5); t5.setText(String.valueOf(valori[4]));
        t6 =(TextView) findViewById(R.id.n6); t6.setText(String.valueOf(valori[5]));
        t7 =(TextView) findViewById(R.id.n7); t7.setText(String.valueOf(valori[6]));
        t8 =(TextView) findViewById(R.id.n8); t8.setText(String.valueOf(valori[7]));
        calcola();
    }

    public void calcola(){
        int i=0;
        if (valori[7]==1) i=i+1;
        if (valori[6]==1) i=i+2;
        if (valori[5]==1) i=i+4;
        if (valori[4]==1) i=i+8;
        if (valori[3]==1) i=i+16;
        if (valori[2]==1) i=i+32;
        if (valori[1]==1) i=i+64;
        if (valori[0]==1) i=i+128;
        cont.setText("Valore Bit: "+String.valueOf(i));
    }

    public void shift(View v){
        TextView t =(TextView) v;
        switch(t.getId()){
            case(R.id.n1):
                if (mod==0) shiftdx(1);
                else shiftsx(1);
                break;
            case(R.id.n2):
                if (mod==0) shiftdx(2);
                else shiftsx(2);
                break;
            case(R.id.n3):
                if (mod==0) shiftdx(3);
                else shiftsx(3);
                break;
            case(R.id.n4):
                if (mod==0) shiftdx(4);
                else shiftsx(4);
                break;
            case(R.id.n5):
                if (mod==0) shiftdx(5);
                else shiftsx(5);
                break;
            case(R.id.n6):
                if (mod==0) shiftdx(6);
                else shiftsx(6);
                break;
            case(R.id.n7):
                if (mod==0) shiftdx(7);
                else shiftsx(7);
                break;
            case(R.id.n8):
                if (mod==0) shiftdx(8);
                else shiftsx(8);
                break;
        }
    }

    public void changemode(View v){
        if (mod==0){
            mod = 1;
            mode.setText("SINISTRA");
        }
        else{
            mod = 0;
            mode.setText("DESTRA");
        }
    }

    public void shiftdx(int v){
        int temp0=0,temp1=0,temp2=0,temp3=0,temp4=0,temp5=0,temp6=0,temp7=0;
        for (int i=0;i<v;i++){
            temp0=valori[0];temp1=valori[1];temp2=valori[2];temp3=valori[3];
            temp4=valori[4];temp5=valori[5];temp6=valori[6];temp7=valori[7];
            valori[0]=temp7;valori[1]=temp0;valori[2]=temp1;valori[3]=temp2;
            valori[4]=temp3;valori[5]=temp4;valori[6]=temp5;valori[7]=temp6;
        }
        inseriscivalori();
    }

    public void shiftsx(int v){
        int temp0=0,temp1=0,temp2=0,temp3=0,temp4=0,temp5=0,temp6=0,temp7=0;
        for (int i=0;i<v;i++){
            temp0=valori[0];temp1=valori[1];temp2=valori[2];temp3=valori[3];
            temp4=valori[4];temp5=valori[5];temp6=valori[6];temp7=valori[7];
            valori[0]=temp1;valori[1]=temp2;valori[2]=temp3;valori[3]=temp4;
            valori[4]=temp5;valori[5]=temp6;valori[6]=temp7;valori[7]=temp0;
        }
        inseriscivalori();
    }

    public void shuffle4(View v){
        shiftsx(4);
    }

    public void shuffle2(View v){
        int temp;
        temp=valori[0]; valori[0]=valori[1]; valori[1]=temp;
        temp=valori[2]; valori[2]=valori[3]; valori[3]=temp;
        temp=valori[4]; valori[4]=valori[5]; valori[5]=temp;
        temp=valori[6]; valori[6]=valori[7]; valori[7]=temp;
        inseriscivalori();
    }

    public void reset(View v){
        inizializza();
        inseriscivalori();
    }
}