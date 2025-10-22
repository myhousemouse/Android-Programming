package com.example.gallery;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
// ❌ 이전 코드: import android.support.v7.app.AppCompatActivity;
// ✅ 수정된 코드: AndroidX로 변경
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureDesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        TextView tv_title  = (TextView)findViewById(R.id.title);
        TextView tv_author = (TextView)findViewById(R.id.artist);
        ImageView iv_picture  = (ImageView)findViewById(R.id.picture);

        Intent it = getIntent();
        String tag  = it.getStringExtra("it_tag");

        Resources res = getResources();

        // 리소스 ID 가져오기 (문자열 리소스를 사용하여 동적으로 처리)
        int id_title = res.getIdentifier("title" + tag, "string", getPackageName());
        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_author = res.getIdentifier("artist" + tag, "string", getPackageName());
        String author = res.getString(id_author);
        tv_author.setText(author);

        // 이미지 파일 이름(문자열 리소스)을 가져와 Drawable 리소스 ID로 변환 후 배경 설정
        int id_picture = res.getIdentifier("picture" + tag, "string", getPackageName());
        String picture = res.getString(id_picture);
        int id_img = res.getIdentifier(picture, "drawable", getPackageName());

        // getDrawable(int)는 API 21(Lollipop)부터 Deprecated되었습니다.
        // API 레벨에 따라 ContextCompat.getDrawable() 또는 getDrawable(id, theme)을 권장하지만,
        // 이 코드를 유지하면서 API 21 이상에서 경고를 피하려면 getDrawable(id, null)을 사용합니다.
        // 프로젝트 targetSdkVersion이 높으므로 getDrawable(id, null)로 변경하여 잠재적 오류를 방지합니다.
        // 또는, 현재 프로젝트가 minSdk 22를 사용하므로 getDrawable(id, null)이 적절합니다.

        Drawable drawable = res.getDrawable(id_img, null); // API 21+ 호환성을 위해 null 추가
        iv_picture.setBackground(drawable);
    }

    public void closePicture(View v) {
        finish();
    }
}