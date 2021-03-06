package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawView;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //카테고리 네비게이션바
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawView = (View)findViewById(R.id.drawer);

        ImageView btn_open = (ImageView)findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawView);
            }
        });

        /* 카테고리 네비게이션바 버튼 닫기
        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });*/

        drawerLayout.setDrawerListener(listener);
        drawView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        // 바텀네비
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_addcloth:
                        setFrag(0);
                        break;
                    case R.id.action_review:
                        setFrag(1);
                        break;
                    case R.id.action_home:
                        setFrag(2);
                        break;
                    case R.id.action_favorites:
                        setFrag(3);
                        break;
                    case R.id.action_mypage:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0);//첫 프레그먼트 화면 지정

    }

    //카테고리 드로우리스너, 설정 안함, 필요하면 할 것
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    //바텀네비 프레그먼트 교체 일어나는 실행문
    private  void setFrag(int n) {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n) {
            case 0:
                ft.replace(R.id.bottomNavigationView, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.bottomNavigationView, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.bottomNavigationView, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.bottomNavigationView, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.bottomNavigationView, frag5);
                ft.commit();
                break;

        }

    }


}