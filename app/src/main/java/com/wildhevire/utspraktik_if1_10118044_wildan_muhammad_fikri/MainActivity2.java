package com.wildhevire.utspraktik_if1_10118044_wildan_muhammad_fikri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

//Nama : Wildan Muhammad Fikri
//NIM: 10118044
//Kelas : IF1

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIK = "nik";
    public static final String EXTRA_TGL = "tgl";
    public static final String EXTRA_KELAMIN = "kelamin";
    public static final String EXTRA_HUBUNGAN = "hubungan";
    public static final String EXTRA_STATUS = "status";

    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String nik = intent.getStringExtra(MainActivity.EXTRA_NIK);
        String nama = intent.getStringExtra(MainActivity.EXTRA_NAMA);
        String jk = intent.getStringExtra(MainActivity.EXTRA_KELAMIN);
        String tgl = intent.getStringExtra(MainActivity.EXTRA_TGL);
        String hub = intent.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

        TextView tvNik = findViewById(R.id.j_nik);
        TextView tvNama = findViewById(R.id.j_nama);
        TextView tvTgl = findViewById(R.id.j_tgl);
        TextView tvHub = findViewById(R.id.j_hub);
        TextView tvJk = findViewById(R.id.j_jk);
        Button btn_simpan= findViewById(R.id.btn_simpan);
        Button btn_ubah= findViewById(R.id.btn_ubah);



        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTgl.setText(tgl);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra(EXTRA_STATUS,"ubah");
                intent2.putExtra(EXTRA_NIK,nik);
                intent2.putExtra(EXTRA_NAMA,nama);
                intent2.putExtra(EXTRA_TGL,tgl);
                intent2.putExtra(EXTRA_KELAMIN,jk);
                intent2.putExtra(EXTRA_HUBUNGAN,hub);

//                if (hub == "Orang Tua"){
//                    intent2.putExtra(Extra_hub,"hbg_ort");
//                }

                startActivity(intent2);
            }
        });
    }

    private void initCustomDialog(){

        customDialog = new Dialog(MainActivity2.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_main3);
        customDialog.setCancelable(true);



        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();
            }
        });
    }
}