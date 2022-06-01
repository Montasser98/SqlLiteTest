package com.example.sqllitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBProduit extends SQLiteOpenHelper {

    public static String DBNAME="DBProduit.db";
    public static String TableName= "PRODUIT";
    public static String Col1="ID";
    public static String Col2="LIBELLE";
    public static String Col3="FAMILLE";
    public static String Col4="PRIXACHAT";
    public static String Col5="PRIXVENTE";

    public MyDBProduit( Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql=" CREATE TABLE "+ TableName +"("+Col1+ "integer primary key autoincrement,"+Col2+"text,"+Col3+"text,"+Col4+"double," +Col5+"double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql="DROP TABLE "+TableName;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long insert_produit(SQLiteDatabase sqLiteDatabase,Produit p){
        ContentValues ct=new ContentValues();
        ct.put(Col2,p.getLibelle());
        ct.put(Col3,p.getFamille());
        ct.put(Col4,p.getPrixAchat());
        ct.put(Col5,p.getPrixVente());
        return sqLiteDatabase.insert(TableName,null,ct);
    }
    public static long update_produit(SQLiteDatabase sqLiteDatabase,Produit p){
        ContentValues ct=new ContentValues();
        ct.put(Col2,p.getLibelle());
        ct.put(Col3,p.getFamille());
        ct.put(Col4,p.getPrixAchat());
        ct.put(Col5,p.getPrixVente());
        return sqLiteDatabase.update(TableName,ct,"ID = "+p.getId(),null);
    }
    public static long delete_produit(SQLiteDatabase sqLiteDatabase,int id){
        return sqLiteDatabase.delete(TableName,"ID = "+id,null);
    }
}
