package com.example.indovinaparola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] parole = new String[]{"AUTO","BELLO","STRADA","IDEA","ESAME","GIOCO","AVVENTURA"};
    int cont=0;
    String parola,indov;
    TextView guess,tent;
    EditText tex;
    Button prova;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guess = (TextView) findViewById(R.id.guess);
        tex = (EditText) findViewById(R.id.tex);
        tent = (TextView) findViewById(R.id.tent);
        prova = (Button) findViewById(R.id.prova);
        inizializza();
    }

    public void inizializza(){
        Random rand= new Random();
        int ind = rand.nextInt(parole.length);
        parola = parole[ind];
        indov="_";
        for (int i=1;i<parola.length();i++){
            indov=indov+"_";
        }
        guess.setText(indov);
        tex.setText("");
        cont=0;
        tent.setText("Tentativi: "+String.valueOf(cont));
    }

    public void prova(View v){
        if (tex.length()>1)
        {
            Toast.makeText(getApplicationContext(),"Solo una lettera alla volta!",Toast.LENGTH_SHORT).show();
            return;
        }

        char l = Character.toUpperCase(tex.getText().charAt(0));

        for (int i=0;i<parola.length();i++){
            if ((l == parola.charAt(i)) && (l != indov.charAt(i))){
                scoprilettera(i);
            }
        }
        cont=cont+1;
        tent.setText("Tentativi: "+String.valueOf(cont));
        controllavittoria();
    }

    public void scoprilettera(int i){
        char[] indovchars = indov.toCharArray();
        indovchars[i] = parola.charAt(i);
        indov = String.valueOf(indovchars);
        guess.setText(indov);
    }

    public void aiuto(View v){
        for (int i=0;i<parola.length();i++){
            if (indov.charAt(i) == '_'){
                scopriletteraaiuto(parola.charAt(i));
                cont=cont+10;
                tent.setText("Tentativi: "+String.valueOf(cont));
                controllavittoria();
                return;
            }
        }
    }

    public void scopriletteraaiuto(char l){
        char[] indovchars = indov.toCharArray();
        for (int i=0;i<parola.length();i++){
            if (l == parola.charAt(i)){
                indovchars[i] = parola.charAt(i);
            }
        }
        indov = String.valueOf(indovchars);
        guess.setText(indov);
    }

    public void controllavittoria(){
        if (indov.equals(parola))
        {
            prova.setEnabled(false);
            tent.setText("Hai Vinto! Tentativi: "+String.valueOf(cont));
        }
    }

    public void reset(View v){
        prova.setEnabled(true);
        inizializza();
    }
}