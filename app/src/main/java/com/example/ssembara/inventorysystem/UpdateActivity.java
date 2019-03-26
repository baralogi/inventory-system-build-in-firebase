package com.example.ssembara.inventorysystem;

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
public class UpdateActivity extends AppCompatActivity {
    Button jEditBarang;
    EditText jetEditIdBarang, jetEditNamaBarang, jetEditHargaBarang,
            jetEditStokBarang;
    private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        jetEditIdBarang = (EditText) findViewById(R.id.editIdBahanBaku);
        jetEditNamaBarang = (EditText) findViewById(R.id.editNamaBahanBaku);
        jetEditHargaBarang = (EditText)
                findViewById(R.id.editHargaBahanBaku);
        jetEditStokBarang = (EditText) findViewById(R.id.editStokBahanBaku);

        jEditBarang = (Button) findViewById(R.id.editBahanBaku);
        jetEditIdBarang.setEnabled(false);
        database = FirebaseDatabase.getInstance().getReference();
        getData();
        jEditBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getId = jetEditIdBarang.getText().toString();
                String getNama = jetEditNamaBarang.getText().toString();
                String getHarga = jetEditHargaBarang.getText().toString();
                String getStok = jetEditStokBarang.getText().toString();
                if(getId.isEmpty() || getNama.isEmpty() ||
                        getHarga.isEmpty() || getStok.isEmpty()){
                    Toast.makeText(UpdateActivity.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {

                    ListModel setBarang = new ListModel();
                    setBarang.setId_barang(jetEditIdBarang.getText().toString());
                    setBarang.setNama_barang(jetEditNamaBarang.getText().toString());
                    setBarang.setHarga_barang(jetEditHargaBarang.getText().toString());
                    setBarang.setStok_barang(jetEditStokBarang.getText().toString());
                    updateBarang(setBarang);
                }
            }
        });
    }
    private void getData(){
        final String intentId =
                getIntent().getExtras().getString("dataId");
        final String intentNama =
                getIntent().getExtras().getString("dataNama");
        final String intentHarga =
                getIntent().getExtras().getString("dataHarga");
        final String intentStok =
                getIntent().getExtras().getString("dataStok");
        jetEditIdBarang.setText(intentId);
        jetEditNamaBarang.setText(intentNama);
        jetEditHargaBarang.setText(intentHarga);
        jetEditStokBarang.setText(intentStok);
    }
    private void updateBarang(ListModel barang){
        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("Barang")
                .child(getKey)
                .setValue(barang)
                .addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        jetEditIdBarang.setText("");
                        jetEditNamaBarang.setText("");
                        jetEditHargaBarang.setText("");
                        jetEditStokBarang.setText("");
                        Toast.makeText(UpdateActivity.this, "Data Berhasil diubah", Toast.LENGTH_SHORT).show();
                                finish();
                    }
                });
    }
}