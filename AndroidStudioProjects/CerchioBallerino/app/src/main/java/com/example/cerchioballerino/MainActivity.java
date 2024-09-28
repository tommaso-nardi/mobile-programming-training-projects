package com.example.cerchioballerino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout lr;
    int lim,att,pos=900,cont;
    private CerchioView cerchioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lr=(RelativeLayout) findViewById(R.id.rl);
        TextView d = (TextView) findViewById(R.id.debug);
        cerchioView = findViewById(R.id.cerchio_view);
        Button spostaCerchioButton = findViewById(R.id.sposta_cerchio_button);
        spostaCerchioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont+50>=lim){cerchioView.setX(lim*2-50);cerchioView.invalidate();return;}
                else if (cont-50<=-lim){cerchioView.setX(50);cerchioView.invalidate();return;}
                else {cont=cont+50;cerchioView.spostaCerchio(50, 0);}

            }
        });

        lr.post(new Runnable()
        {

            @Override
            public void run()
            {
                lim = (lr.getWidth()/2);
                d.setText(String.valueOf(lim*2));
            }
        });
    }
}