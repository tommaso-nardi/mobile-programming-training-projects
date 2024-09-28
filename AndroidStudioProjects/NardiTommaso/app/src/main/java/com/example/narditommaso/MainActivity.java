package com.example.narditommaso;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*Variabili globali usate nei vari metodi per il funzionamento dell'app
    "Valori" sono i valori nelle celle, salvate nell'array "celle" il motivo per cui
    c'è questa suddivisione è per semplificare la modifica dei valori quando facciamo gli shift
    cosi da evitare di avere righe e righe con celle[i].setText(celle[i+1].getText().toString())*/

    int[] valori = new int[8];
    TextView[] celle = new TextView[8];
    TextView modalita;
    int mod = 0;
    Button cambiamod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizializza();
        aggiornavalori();
    }

    //Semplice metodo chiamato all'inizio per inizializzare tutti i puntatori e generare i valori nelle celle
    public void inizializza(){
        inizializzapuntatori();
        Random rand = new Random();
        for (int i=0;i<8;i++)
        {
            valori[i]=rand.nextInt(2);
        }
    }

    //Suddetto metodo per l'assegnazione dei puntatori, con casting ad ognuno per sicurezza
    public void inizializzapuntatori(){
        celle[0] = (TextView) findViewById(R.id.n1);
        celle[1] = (TextView) findViewById(R.id.n2);
        celle[2] = (TextView) findViewById(R.id.n3);
        celle[3] = (TextView) findViewById(R.id.n4);
        celle[4] = (TextView) findViewById(R.id.n5);
        celle[5] = (TextView) findViewById(R.id.n6);
        celle[6] = (TextView) findViewById(R.id.n7);
        celle[7] = (TextView) findViewById(R.id.n8);
        modalita = (TextView) findViewById(R.id.modalita);
        cambiamod = (Button) findViewById(R.id.cambiamod);
    }

    /*Il metodo onClick presente in ogni bottone, semplicemente si prende l'id della cella premuta
    e a seconda di qual'è lo shift verrà ripetuto tot volte (es. posizione 5 = 5 shift)*/
    public void numeroclick(View v){
        switch (v.getId()){
            case(R.id.n1):
                shift(1);break;
            case(R.id.n2):
                shift(2);break;
            case(R.id.n3):
                shift(3);break;
            case(R.id.n4):
                shift(4);break;
            case(R.id.n5):
                shift(5);break;
            case(R.id.n6):
                shift(6);break;
            case(R.id.n7):
                shift(7);break;
            case(R.id.n8):
                shift(8);break;
        }
    }

    /*Metodo per lo shift, usiamo 8 variabili temporanee temp per semplicità, cosi da
    fare subito tutti i cambi senza confusione, altrimenti come spiegato prima, sarebbe un metodo
    pieno di "celle[i].setText(celle[i+1].getText().toString())" per esempio
    Il for verrà iterato tot volte a seconda di come spiegato nel metodo precedente*/
    public void shift(int ind){
        int temp0,temp1,temp2,temp3,temp4,temp5,temp6,temp7;
        for (int i=0;i<ind;i++){
            if (mod==0){
                temp0=valori[0];temp1=valori[1];temp2=valori[2];temp3=valori[3];
                temp4=valori[4];temp5=valori[5];temp6=valori[6];temp7=valori[7];
                valori[0]=temp7;valori[1]=temp0;valori[2]=temp1;valori[3]=temp2;
                valori[4]=temp3;valori[5]=temp4;valori[6]=temp5;valori[7]=temp6;
            }
            else{
                temp0=valori[0];temp1=valori[1];temp2=valori[2];temp3=valori[3];
                temp4=valori[4];temp5=valori[5];temp6=valori[6];temp7=valori[7];
                valori[0]=temp1;valori[1]=temp2;valori[2]=temp3;valori[3]=temp4;
                valori[4]=temp5;valori[5]=temp6;valori[6]=temp7;valori[7]=temp0;
            }
        }
        aggiornavalori();
    }

    /*Semplice metodo per aggiornare i valori delle celle in una singola istruzione for.
    Metodo chiamato nell'inizializzazione (ovviamente) e dopo la conclusione dell'esecuzione del
    motodo shift*/
    public void aggiornavalori(){
        for (int i=0;i<8;i++) celle[i].setText(String.valueOf(valori[i]));
    }

    /*Metodo onClick del bottone per cambiare modalità, aggiorna solo il testo visibile in 'S' o 'D'
    come da traccia, e la variabile interna*/
    public void cambiamod(View v){
        if (mod==0){
            mod = 1;
            modalita.setText("S");
        }
        else{
            mod = 0;
            modalita.setText("D");
        }
    }

    /*Questo onConfigurationChanged non fa nulla, serve solo ad evitare che lo stato venga
    perso ogni qualvolta che lo schermo viene ruotato, se non ci fosse, allora, dopo ogni rotazione
    l'intera applicazione rigenererebbe i valori nelle celle e reimposterebbe la modalità in "D"*/
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}