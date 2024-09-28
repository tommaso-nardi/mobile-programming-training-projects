package com.example.doppiotris;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements BoardFragment.OnCellClickListener {

    FragmentManager fm;
    FragmentTransaction ft;
    BoardFragment xBoardFragment;
    BoardFragment oBoardFragment;
    TextView tx,to;
    View fx,fo;
    int turno,mosse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turno=0;mosse=0;
        tx = (TextView) findViewById(R.id.tx);
        to = (TextView) findViewById(R.id.to);

        // Crea i frammenti con il tipo di scacchiera appropriato
        xBoardFragment = BoardFragment.newInstance('X');
        oBoardFragment = BoardFragment.newInstance('O');

        // Aggiungi i frammenti all'Activity
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.fragmentContainer1, xBoardFragment);
        ft.add(R.id.fragmentContainer2, oBoardFragment);
        to.setVisibility(View.INVISIBLE);
        ft.commit();
        to.post(new Runnable() {
            @Override
            public void run() {
                fx = xBoardFragment.getView();  // Ora la vista è disponibile
                fo = oBoardFragment.getView();

                if (fo != null) {
                    fo.setVisibility(View.INVISIBLE);  // Imposta invisibilità sulla vista del frammento
                }
            }
        });
    }

    @Override
    public void onCellClicked(int buttonIndex, char symbol) {
        // Aggiorna entrambi i frammenti quando una cella viene cliccata
        xBoardFragment.updateCell(buttonIndex, symbol);
        oBoardFragment.updateCell(buttonIndex, symbol);
        mosse = mosse+1;
        if (turno==0)
        {
            turno=1;
            to.setVisibility(View.VISIBLE);
            tx.setVisibility(View.INVISIBLE);
            fo.setVisibility(View.VISIBLE);
            fx.setVisibility(View.INVISIBLE);
        }
        else
        {
            turno=0;
            to.setVisibility(View.INVISIBLE);
            tx.setVisibility(View.VISIBLE);
            fo.setVisibility(View.INVISIBLE);
            fx.setVisibility(View.VISIBLE);
        }
        String s = xBoardFragment.controllavittoria();
        if (s!=null)
        {
            xBoardFragment.blocco();
            oBoardFragment.blocco();
            tx.setText(s+" vince!");
            to.setText(s+" vince!");
        }
        else if (mosse==9)
        {
            xBoardFragment.blocco();
            oBoardFragment.blocco();
            tx.setText("Pareggio!");
            to.setText("Pareggio!");
        }
    }
}
