package com.dhegit.latihancontrolinput;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {
    TextView tvNama, tvJenisKelamin, tvWhatsapp, tvAlamat, tvTanggal;
    Button btnTanggal, btnKonfirmasi;
    String nama, jenisKelamin, whatsapp, alamat;
    String choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJenisKelamin =findViewById(R.id.tv_jenis_kelamin);
        tvWhatsapp = findViewById(R.id.tv_whatsapp);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfifrmasi);

        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        jenisKelamin = terima.getStringExtra("varJenisKelamin");
        whatsapp = terima.getStringExtra("varWhatsapp");
        alamat = terima.getStringExtra("varAlamat");

        tvNama.setText(nama);
        tvJenisKelamin.setText(jenisKelamin);
        tvWhatsapp.setText(whatsapp);
        tvAlamat.setText(alamat);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment frgTanggal = new DatePickerFragment();
                frgTanggal.show(getSupportFragmentManager(), "datePicker");
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah Data yang Anda isi Telah Benar ?");

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this, "Terimakasih, Pendaftaran Anda Berhasil", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.show();
            }
        });
    }

    public void processDatePickerResult(int year, int month, int day) {
        String tahun = Integer.toString(year);
        String bulan = Integer.toString(month+1);
        String hari = Integer.toString(day);

        choosenDate = hari + " / " + bulan + " / " + tahun;
        tvTanggal.setText(choosenDate);
    }
}