package com.dhegit.latihancontrolinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etWhatsapp, etAlamat, etPassword, etPin;
    Button btnDaftar;
    String nama, jenisKelamin, whatsapp, alamat, password, pin;

    RadioGroup rgJenisKelamin;
    RadioButton rbJenisKelamin;
    int jenisKelaminID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etWhatsapp = findViewById(R.id.et_whatsapp);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);

        rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin);

        btnDaftar = findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jenisKelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(jenisKelaminID);

                nama = etNama.getText().toString();
                jenisKelamin = rbJenisKelamin.getText().toString();
                whatsapp = etWhatsapp.getText().toString();
                alamat = etAlamat.getText().toString();
                password = etPassword.getText().toString();
                pin = etPin.getText().toString();

                Intent kirim = new Intent(MainActivity.this, ConfirmActivity.class);

                kirim.putExtra("varNama", nama);
                kirim.putExtra("varJenisKelamin", jenisKelamin);
                kirim.putExtra("varWhatsapp", whatsapp);
                kirim.putExtra("varAlamat", alamat);
                startActivity(kirim);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");

        etNama.requestFocus();
    }
}