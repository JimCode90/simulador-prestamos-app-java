package com.jimcode.simuladorprestamo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText txietUsuario, txietPassword;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txietUsuario = (TextInputEditText) findViewById(R.id.txietUsuario);
        txietPassword = (TextInputEditText) findViewById(R.id.txietPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario, password;
                usuario = txietUsuario.getText().toString();
                password = txietPassword.getText().toString();

                if (usuario.equals("isil") && password.equals("123456")){
                    Toast.makeText(LoginActivity.this, "Bienvenido usuario: " + usuario, Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}