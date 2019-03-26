package com.example.ssembara.inventorysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    LinearLayout jbtnBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtnBarang = (LinearLayout) findViewById(R.id.MenuBarang);
        jbtnBarang.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.MenuBarang:
                Intent intent_barang = new Intent(MainActivity.this,
                        ListActivity.class);
                startActivity(intent_barang);
                break;
        }
    }
}