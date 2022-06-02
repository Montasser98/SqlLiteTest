package com.example.sqllitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListProd extends AppCompatActivity {
    MyDBProduit db;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prod);
        db=new MyDBProduit(this);
        lst=findViewById(R.id.lst);
        ArrayList<Produit> prds=MyDBProduit.getAllProds(db.getReadableDatabase());

        ArrayList<String> nomsProds=new ArrayList<>();
        for(Produit pp:prds)
            nomsProds.add(pp.getId()+"_"+pp.getLibelle());
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,nomsProds);
        lst.setAdapter(ad);
    }
}