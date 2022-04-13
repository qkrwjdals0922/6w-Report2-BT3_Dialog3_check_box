package com.pjm0922;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Report2");
    }

    public void onClick1(View view) {
        alert_ex("알림");
    }

    public void onClick2(View view) {
        alert_ex("입력");
    }

    public void onClick3(View view) {
        alert_ex("리스트");
    }

    public void alert_ex(String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        switch (type) {
            case "알림":
                builder.setIcon(R.drawable.img1).setTitle("알림").setMessage("이번주 레포트는 Dialog입니다.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case "입력":
                final EditText input = new EditText(this);
                builder.setTitle("이름 입력").setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (input.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "입력해주세요.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, input.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                break;

            case "리스트":
                CharSequence[] hb = {"독서", "등산", "수영", "수집", "영화"};
                List list = new ArrayList<Integer>();

                builder.setIcon(R.drawable.img2).setTitle("당신의 취미는?");

                builder.setMultiChoiceItems(hb, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    list.add(hb[which]);

                                } else if (list.contains(hb[which])) {
                                    list.remove(String.valueOf(hb[which]));
                                }
                            }
                        });
                builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (list.isEmpty()) {
                            Toast.makeText(MainActivity.this, "취미를 선택해주세요", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "취미 : " + list, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}