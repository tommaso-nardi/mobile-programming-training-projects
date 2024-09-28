package com.example.cerchioballerino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CerchioView extends View {

    private Paint paint;
    private int cerchioColor = Color.BLUE; // Colore del cerchio
    private float cerchioRadius = 50; // Raggio del cerchio
    private float cerchioX = 0; // Posizione orizzontale del cerchio
    private float cerchioY = 0; // Posizione verticale del cerchio

    public CerchioView(Context context) {
        super(context);
        init();
    }

    public CerchioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CerchioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Inizializza il Paint
        paint = new Paint();
        paint.setColor(cerchioColor);
        paint.setStyle(Paint.Style.FILL); // Riempie il cerchio
        paint.setAntiAlias(true); // Migliora la qualità del disegno
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Disegna il cerchio alla posizione aggiornata
        canvas.drawCircle(cerchioX, cerchioY, cerchioRadius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Imposta la posizione centrale iniziale
        cerchioX = w / 2;
        cerchioY = h / 2;
    }

    // Metodo per aggiornare il colore del cerchio
    public void setCerchioColor(int color) {
        cerchioColor = color;
        paint.setColor(cerchioColor);
        invalidate(); // Richiede una ridisegnata
    }

    // Metodo per aggiornare il raggio del cerchio
    public void setCerchioRadius(float radius) {
        cerchioRadius = radius;
        invalidate(); // Richiede una ridisegnata
    }

    // Metodo per spostare il cerchio
    public void spostaCerchio(float dx, float dy) {
        cerchioX += dx;
        cerchioY += dy;
        invalidate(); // Richiede una ridisegnata
    }

    public float getX(){return cerchioX;}
    public void setX(float X){cerchioX=X;}
}
