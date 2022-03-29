package com.android.s19110209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    TextView txtSoTienLai;
    TextView txtTongSoTien;
    Button btnCamara;
    int Request_Code_Camara = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        AnhXa();

        Bundle bundle = getIntent().getBundleExtra("dulieu");
        double soTienLai = bundle.getDouble("soTienLai");
        double tongSoTien = bundle.getDouble("tongSoTienNhan");

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String str1 = en.format(soTienLai) + " đ";
        String str2 = en.format(tongSoTien);

        txtSoTienLai.setText(str1);
        txtTongSoTien.setText(str2 + " đ");


        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Request_Code_Camara);
                finish();
            }
        });


    }

    void AnhXa() {
        txtSoTienLai = (TextView) findViewById(R.id.txtSoTienLai);
        txtTongSoTien = (TextView) findViewById(R.id.txtTongSoTien);
        btnCamara = (Button) findViewById(R.id.btnCamara);
    }
}