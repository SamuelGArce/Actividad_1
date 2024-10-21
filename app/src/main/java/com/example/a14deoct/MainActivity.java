package com.example.a14deoct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText Usuario, Contraseña;
    ProgressBar pgB;
    Button btnValidar;
    TextView lblResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario = findViewById(R.id.txtUsuario);
        Contraseña = findViewById(R.id.txtPass);
        btnValidar = findViewById(R.id.btnLogin);
        pgB = findViewById(R.id.progressBar);
        lblResultado = findViewById(R.id.textView2);
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask().execute(Usuario.getText().toString(), Contraseña.getText().toString());

            }
        });
    }

    class AsyncTask extends android.os.AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            pgB.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(5000);
                String UserValido = "SOUL";
                String PassValido = "PEPITO";
                String UserImput = strings[0];
                String PassImput = strings[1];
                if (UserImput.equals(UserValido) && PassImput.equals(PassValido)){
                    lblResultado.setText("Usuario correcto");

                }else {
                    lblResultado.setText("Usuario o contraseña incorrectos");
                }

            } catch (InterruptedException e){

            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pgB.setVisibility(View.INVISIBLE);
            btnValidar.setEnabled(true);

        }
    }
}