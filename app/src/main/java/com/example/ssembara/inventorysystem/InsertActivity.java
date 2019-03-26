package com.example.ssembara.inventorysystem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssembara.inventorysystem.Model.ListModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class InsertActivity extends AppCompatActivity {
    Button jsimpanBarang;
    EditText jetidBarang, jetnamaBarang, jethargaBarang, jetstokBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        jsimpanBarang = (Button) findViewById(R.id.simpanBarang);
        jetidBarang = (EditText) findViewById(R.id.idBarang);
        jetnamaBarang = (EditText) findViewById(R.id.namaBarang);

        jethargaBarang = (EditText) findViewById(R.id.hargaBarang);
        jetstokBarang = (EditText) findViewById(R.id.stokBarang);
        jsimpanBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference getReference;
                String getId = jetidBarang.getText().toString();
                String getNama = jetnamaBarang.getText().toString();
                String getHarga = jethargaBarang.getText().toString();
                String getStok = jetstokBarang.getText().toString();
                getReference = database.getReference();
                if (getId.isEmpty() || getNama.isEmpty() ||
                        getHarga.isEmpty() || getStok.isEmpty()){

                    Toast.makeText(InsertActivity.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else{
                    getReference.child("Barang").push().setValue(new ListModel(getId, getNama, getHarga, getStok))
                            .addOnSuccessListener(InsertActivity.this
                                    , new OnSuccessListener() {
                                        @Override

                                        public void onSuccess(Object o) {
                                            jetidBarang.setText("");
                                            jetnamaBarang.setText("");
                                            jethargaBarang.setText("");
                                            jetstokBarang.setText("");
                                            Toast.makeText(InsertActivity.this, "Data Tersimpan",
                                                    Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    });
                }
            }
        });
    }
}