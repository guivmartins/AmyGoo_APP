package com.zomercorporation.android_database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome = (EditText)findViewById(R.id.editText);
                EditText bairro = (EditText)findViewById((R.id.editText2));
                EditText email = (EditText)findViewById(R.id.editText3);
                EditText nomepet = (EditText)findViewById((R.id.editText4));
                EditText racapet = (EditText)findViewById((R.id.editText5));
                EditText corpet = (EditText)findViewById((R.id.editText6));

                String nomeString = nome.getText().toString();
                String bairroString = bairro.getText().toString();
                String emailString = email.getText().toString();
                String nomepetString = nomepet.getText().toString();
                String racapetString = racapet.getText().toString();
                String corpetString = corpet.getText().toString();

                BancoController crud = new BancoController(getBaseContext());
                String resultado = crud.insereDado(nomeString,bairroString,emailString,nomepetString,racapetString,corpetString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
