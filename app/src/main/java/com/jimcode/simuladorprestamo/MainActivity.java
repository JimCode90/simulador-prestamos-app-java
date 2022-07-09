package com.jimcode.simuladorprestamo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txinetImporte, txinetInteres, txinetTiempo;
    Button btnCalcular, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txinetImporte = (TextInputEditText) findViewById(R.id.txinetImporte);
        txinetInteres = (TextInputEditText) findViewById(R.id.txinetInteres);
        txinetTiempo = (TextInputEditText) findViewById(R.id.txinetTiempo);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float importe_total, interes_anual, tiempo_plazos;
                double porcentaje_mensual, cuota;

                importe_total = Float.parseFloat(txinetImporte.getText().toString());
                interes_anual = Float.parseFloat(txinetInteres.getText().toString()) / 100;
                tiempo_plazos = Float.parseFloat(txinetTiempo.getText().toString());
                porcentaje_mensual = Math.pow(1 + interes_anual, 1d / 12d) - 1;

                cuota = (importe_total * (porcentaje_mensual * Math.pow((1 + porcentaje_mensual), tiempo_plazos))) /
                        ((Math.pow((1 + porcentaje_mensual), tiempo_plazos)) - 1);

                DecimalFormat formato_decimal = new DecimalFormat("#.00");

                String interes_total = formato_decimal.format((cuota * tiempo_plazos) - importe_total);
                String monto_total = formato_decimal.format(cuota * tiempo_plazos);

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("couta", formato_decimal.format(cuota));
                intent.putExtra("intere_total", interes_total);
                intent.putExtra("monto_total", monto_total);

                startActivity(intent);


            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}