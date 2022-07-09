package com.jimcode.simuladorprestamo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    TextView txvCoutaMensual, txvInteresTotal, txvMontoTotal;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txvCoutaMensual = (TextView) findViewById(R.id.txvCoutaMensual);
        txvInteresTotal = (TextView) findViewById(R.id.txvInteresTotal);
        txvMontoTotal = (TextView) findViewById(R.id.txvMontoTotal);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        String couta_mensual = getIntent().getStringExtra("couta");
        String interes_total = getIntent().getStringExtra("intere_total");
        String monto_total = getIntent().getStringExtra("monto_total");


        txvCoutaMensual.setText(couta_mensual);
        txvInteresTotal.setText(interes_total);
        txvMontoTotal.setText(monto_total);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadoActivity.this, MainActivity.class));
            }
        });



    }
}