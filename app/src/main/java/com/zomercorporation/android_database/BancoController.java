package com.zomercorporation.android_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, String bairro, String email, String nomepet, String racapet, String corpet){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.BAIRRO, bairro);
        valores.put(CriaBanco.EMAIL, email);
        valores.put(CriaBanco.NOMEPET, nomepet);
        valores.put(CriaBanco.RACAPET, racapet);
        valores.put(CriaBanco.CORPET, corpet);


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro Inserido com sucesso";
        }
    }


    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.NOME, banco.BAIRRO, banco.EMAIL, banco.NOMEPET, banco.RACAPET, banco.CORPET};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
