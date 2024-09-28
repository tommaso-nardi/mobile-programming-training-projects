package com.example.doppiotris;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BoardFragment extends Fragment {

    private Button[] buttons = new Button[9];
    private OnCellClickListener mListener;
    private char boardType; // 'X' per la scacchiera delle X, 'O' per quella delle O

    public interface OnCellClickListener {
        void onCellClicked(int buttonIndex, char symbol);
    }

    // Metodo statico per creare un'istanza di BoardFragment con un tipo specifico
    public static BoardFragment newInstance(char boardType) {
        BoardFragment fragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putChar("boardType", boardType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        // Recupera il tipo di scacchiera dagli argomenti
        if (getArguments() != null) {
            boardType = getArguments().getChar("boardType");
        }

        // Inizializza i bottoni
        buttons[0] = view.findViewById(R.id.button1);
        buttons[1] = view.findViewById(R.id.button2);
        buttons[2] = view.findViewById(R.id.button3);
        buttons[3] = view.findViewById(R.id.button4);
        buttons[4] = view.findViewById(R.id.button5);
        buttons[5] = view.findViewById(R.id.button6);
        buttons[6] = view.findViewById(R.id.button7);
        buttons[7] = view.findViewById(R.id.button8);
        buttons[8] = view.findViewById(R.id.button9);

        // Imposta OnClickListener per ogni bottone
        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].setOnClickListener(v -> {
                if (mListener != null) {
                    char symbol = (boardType == 'X') ? 'X' : 'O'; // Determina il simbolo in base al tipo
                    mListener.onCellClicked(index, symbol);
                }
            });
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCellClickListener) {
            mListener = (OnCellClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " deve implementare OnCellClickListener");
        }
    }

    public void updateCell(int index, char symbol) {
        buttons[index].setText(String.valueOf(symbol));
        buttons[index].setEnabled(false);
    }

    public String controllavittoria() {
        String r = null;

        // Controlla se le celle non sono vuote prima di fare il confronto
        if (!buttons[0].getText().toString().isEmpty() &&
                buttons[0].getText().toString().equals(buttons[1].getText().toString()) &&
                buttons[0].getText().toString().equals(buttons[2].getText().toString())) {
            r = buttons[0].getText().toString();
        }
        if (!buttons[0].getText().toString().isEmpty() &&
                buttons[0].getText().toString().equals(buttons[3].getText().toString()) &&
                buttons[0].getText().toString().equals(buttons[6].getText().toString())) {
            r = buttons[0].getText().toString();
        }
        if (!buttons[0].getText().toString().isEmpty() &&
                buttons[0].getText().toString().equals(buttons[4].getText().toString()) &&
                buttons[0].getText().toString().equals(buttons[8].getText().toString())) {
            r = buttons[0].getText().toString();
        }
        if (!buttons[1].getText().toString().isEmpty() &&
                buttons[1].getText().toString().equals(buttons[4].getText().toString()) &&
                buttons[1].getText().toString().equals(buttons[7].getText().toString())) {
            r = buttons[1].getText().toString();
        }
        if (!buttons[2].getText().toString().isEmpty() &&
                buttons[2].getText().toString().equals(buttons[5].getText().toString()) &&
                buttons[2].getText().toString().equals(buttons[8].getText().toString())) {
            r = buttons[2].getText().toString();
        }
        if (!buttons[3].getText().toString().isEmpty() &&
                buttons[3].getText().toString().equals(buttons[4].getText().toString()) &&
                buttons[3].getText().toString().equals(buttons[5].getText().toString())) {
            r = buttons[3].getText().toString();
        }
        if (!buttons[6].getText().toString().isEmpty() &&
                buttons[6].getText().toString().equals(buttons[7].getText().toString()) &&
                buttons[6].getText().toString().equals(buttons[8].getText().toString())) {
            r = buttons[6].getText().toString();
        }
        if (!buttons[6].getText().toString().isEmpty() &&
                buttons[6].getText().toString().equals(buttons[4].getText().toString()) &&
                buttons[6].getText().toString().equals(buttons[2].getText().toString())) {
            r = buttons[6].getText().toString();
        }

        return r;
    }


    public void blocco(){
        for (int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
    }
}
