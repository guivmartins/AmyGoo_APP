package com.zomercorporation.android_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String BAIRRO = "bairro";
    public static final String EMAIL = "email";
    public static final String NOMEPET = "nomepet";
    public static final String RACAPET = "racapet";
    public static final String CORPET = "corpet";
    public static final int VERSAO =2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " +TABELA+ "("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + BAIRRO + " text,"
                + EMAIL + " text,"
                + NOMEPET + " text,"
                + RACAPET + " text,"
                + CORPET + " text"
                +" )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

}
