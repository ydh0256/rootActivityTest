package com.example.ktb.rootactivitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RootActivity extends AppCompatActivity {

    int[] tabIds = {R.id.btnTab1, R.id.btnTab2, R.id.btnTab3, R.id.btnTab4, R.id.btnTab5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // 자식뷰가 setContentView를 하면 호출
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //자식뷰의 xml 에 탭id가 있으면 탭 동작 클릭 리스너를 붙여준다
        for(int tab : tabIds) {
            View v = findViewById(tab);
            if(v != null) {
                v.setOnClickListener(onTabClick);
            }
        }
    }

    private View.OnClickListener onTabClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnTab1:
                    changeTab(Tab1Activity.class);
                    break;
                case R.id.btnTab2:
                    changeTab(Tab2Activity.class);
                    break;
                case R.id.btnTab3:
                    changeTab(Tab3Activity.class);
                    break;
                case R.id.btnTab4:
                    changeTab(Tab4Activity.class);
                    break;
                case R.id.btnTab5:
                    changeTab(Tab5Activity.class);
                    break;
            }
        }
    };

    private void changeTab(Class<?> cls) {
        // 화면전환시 애니메이션 없애기
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}
