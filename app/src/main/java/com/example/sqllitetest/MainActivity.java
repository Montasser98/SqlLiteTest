package com.example.sqllitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acces(View view) {
        Intent i=null;
        switch (view.getId()){
            case R.id.b1:i=new Intent(this,ListProd.class); break ;
            case R.id.b2:i=new Intent(this,FicheProd.class); break ;
            case R.id.b3:i=new Intent(this,AddProd.class); break ;
            case R.id.b4:i=new Intent(this,EditeProd.class); break ;

        }
        startActivity(i);

    }
}