package com.example.examen_calificaciones_valverde;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrimerParcial, editTextSegundoParcial;
    private TextView promedioTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrimerParcial = findViewById(R.id.editTextPrimerParcial);
        editTextSegundoParcial = findViewById(R.id.editTextSegundoParcial);
        promedioTextView = findViewById(R.id.promedioTextView);

        // Agrega un TextWatcher para detectar cambios en los campos de texto
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                calcularPromedio();
            }
        };

        editTextPrimerParcial.addTextChangedListener(textWatcher);
        editTextSegundoParcial.addTextChangedListener(textWatcher);
    }

    private void calcularPromedio() {
        try {
            double primerParcial = Double.parseDouble(editTextPrimerParcial.getText().toString());
            double segundoParcial = Double.parseDouble(editTextSegundoParcial.getText().toString());

            double promedio = (primerParcial + segundoParcial) / 2;
            promedioTextView.setText("Promedio: " + String.format("%.2f", promedio));
        } catch (NumberFormatException e) {
            // Manejar el caso en que la entrada no sea un número válido
            promedioTextView.setText("Promedio: ");
        }
    }
}
