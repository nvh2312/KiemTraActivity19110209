package com.android.s19110209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtSoTienGui , edtLaiSuatGui , edtKyHanGui;
    Button btnXemKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        btnXemKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                if (edtSoTienGui.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập số tiền gửi", Toast.LENGTH_SHORT).show();
                } else if (edtLaiSuatGui.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập lãi suất gửi", Toast.LENGTH_SHORT).show();
                } else if (edtKyHanGui.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập kì hạn gửi", Toast.LENGTH_SHORT).show();
                } else {
                    double soTienGui = Double.parseDouble(edtSoTienGui.getText().toString());
                    double laiXuatGui = Double.parseDouble(edtLaiSuatGui.getText().toString());
                    double kyHanGui = Double.parseDouble(edtKyHanGui.getText().toString());

                    if (soTienGui == 0 || laiXuatGui == 0 || kyHanGui == 0) {
                        Toast.makeText(MainActivity.this, "Dữ liệu nhập vào phải lớn hơn không", Toast.LENGTH_SHORT).show();
                    }
                    else {


                        double soTienLai = soTienGui * (laiXuatGui / 100) * (kyHanGui / 12);
                        double tongSoTienNhan = soTienLai + soTienGui;


                        Bundle bundle = new Bundle();
                        bundle.putDouble("soTienLai", soTienLai);
                        bundle.putDouble("tongSoTienNhan", tongSoTienNhan);

                        intent.putExtra("dulieu", bundle);
                        startActivity(intent);
                    }
                }
            }
        });


    }
    void AnhXa(){
        edtSoTienGui = (EditText) findViewById(R.id.edtSoTienGui);
        edtLaiSuatGui = (EditText) findViewById(R.id.edtLaiSuatGui);
        edtKyHanGui= (EditText) findViewById(R.id.edtKyHanGui);
        btnXemKetQua=(Button) findViewById(R.id.btnXemKetQua);
    }
}