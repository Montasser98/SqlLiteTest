package com.example.sqllitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProd extends AppCompatActivity {
    EditText elib,eprixa,eprixv;
    Spinner efam;
    MyDBProduit db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prod);
        db=new MyDBProduit(this);
        elib=findViewById(R.id.elib);
        efam=findViewById(R.id.efam);
        eprixa=findViewById(R.id.eprixa);
        eprixv=findViewById(R.id.eprixv);

    }

    public void ajouter (View view) {
        Produit p = new Produit();
        p.setLibelle(elib.getText().toString());
        p.setFamille(efam.getSelectedItem().toString());
        p.setPrixAchat(Double.parseDouble(eprixa.getText().toString()));
        p.setPrixVente(Double.parseDouble(eprixv.getText().toString()));

        if (MyDBProduit.insert_produit(db.getWritableDatabase(),p)==-1)
            Toast.makeText(this,"Insertion Echoue",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Insertion Echoue",Toast.LENGTH_LONG).show();

    }

}