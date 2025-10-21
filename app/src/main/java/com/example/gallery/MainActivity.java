package com.example.gallery;

import android.content.Intent;
import android.graphics.Picture;
// ❌ 오류 발생 지점: android.support.v7.app 대신 androidx.appcompat.app 사용
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // AppCompatActivity 문제 해결

    @Override // @Override 오류 해결 (AppCompatActivity를 상속받았으므로 유효해짐)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPicture(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

        //Toast.makeText(this, "클릭한 아이템: " + tag, Toast.LENGTH_LONG).show();

        Intent it = new Intent(this, PictureDesc.class);
        it.putExtra("it_tag",  tag);
        startActivity(it);
    }
}