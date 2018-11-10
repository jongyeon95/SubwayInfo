package com.example.jongyepn.subwayinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, View.OnTouchListener*/ {
static StaionAdapter adapter;
    private static HorizontalScrollView Scroll_Horizontal;
    private static ScrollView Scroll_Vertical;
    protected static int currentX = 0;
    protected static int currentY = 0;

    AllSubwayInfo allSubwayInfo = AllSubwayInfo.getInstance();  // 원하는 역의 정보를 셋하기 위해 호출하는 역정보 클래스객체
    Variable variable = Variable.getInstance();  // 역정보클래스 객체의 arrayList를 사용하기위한 클래스객체


private Bitmap imagebitmap = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allSubwayInfo.setStatnNm("쌍문");  // 역정보를 받아오는 메서드
        new GetData().execute();


        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.replace , null, false);
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        AsyncTask.execute(new Runnable() { // 네트워크작업을 수행하기 위한 asyncTask사용
            @Override
            public void run() {
                // All your networking logic
                // should be here
            }
        });


//줌뷰 객체 생성후
        ZoomView zoomView = new ZoomView(this);

//줌컨텐츠를 줌뷰에 넣어준다
        zoomView.addView(v);

//줌뷰를 컨테이너에 붙여준다
        RelativeLayout main_container = (RelativeLayout) findViewById(R.id.container);
        main_container.addView(zoomView);

        Scroll_Vertical = (ScrollView) findViewById(R.id.ScrollView);
        Scroll_Horizontal = (HorizontalScrollView) findViewById(R.id.horScrollView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Scroll_Horizontal.scrollTo((int)Scroll_Horizontal.getWidth()/2, 0);
            }
        }, 100);

       /* Scroll_Vertical.setOnTouchListener(this);
        Scroll_Horizontal.setOnTouchListener(this);*/

        Resources res=getResources();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        zoomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unseeButton();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final Button ibtn2 = (Button)findViewById(R.id.ibtn2);
        final Button ibtn1 = (Button)findViewById(R.id.ibtn1);
        final Button ibtn3 = (Button)findViewById(R.id.ibtn3);
        final Button b1 = (Button)findViewById(R.id.btn1);
        final Button b2 = (Button)findViewById(R.id.btn2);
        final Button b3 = (Button)findViewById(R.id.btn3);
        final Button b4 = (Button)findViewById(R.id.btn4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeButton(b1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeButton(b2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeButton(b3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeButton(b4);
            }
        });
        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        DetailLineinfo.class);
                startActivity(intent);
            }
        });

    }
    public void seeButton(Button a){
        final Button ibtn2 = (Button)findViewById(R.id.ibtn2);
        final Button ibtn1 = (Button)findViewById(R.id.ibtn1);
        final Button ibtn3 = (Button)findViewById(R.id.ibtn3);
        ibtn1.setVisibility(View.VISIBLE);
        ibtn2.setVisibility(View.VISIBLE);
        ibtn3.setVisibility(View.VISIBLE);
        ibtn1.setEnabled(true);
        ibtn2.setEnabled(true);
        ibtn3.setEnabled(true);
        ibtn2.setText(a.getText());
    }
    public void unseeButton(){
        final Button ibtn2 = (Button)findViewById(R.id.ibtn2);
        final Button ibtn1 = (Button)findViewById(R.id.ibtn1);
        final Button ibtn3 = (Button)findViewById(R.id.ibtn3);
        ibtn1.setVisibility(View.INVISIBLE);
        ibtn2.setVisibility(View.INVISIBLE);
        ibtn3.setVisibility(View.INVISIBLE);
        ibtn1.setEnabled(false);
        ibtn2.setEnabled(false);
        ibtn3.setEnabled(false);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /// if (id == R.id.action_settings) {
         //   return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(getApplicationContext(),
                    FindStaion.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent1 = new Intent(getApplicationContext(),
                    SeeLine.class);
            startActivity(intent1);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

  /*  public static void scrollBy(int x, int y)
    {
        Scroll_Horizontal.scrollBy(x, 0);
        Scroll_Vertical.scrollBy(0, y);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                currentX = (int)event.getRawX();
                currentY = (int)event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x2 = (int)event.getRawX();
                int y2 = (int)event.getRawY();
                scrollBy(currentX-x2, currentY-y2);
                currentX = x2;
                currentY = y2;
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                currentX = (int)event.getRawX();
                currentY = (int)event.getRawY();
                break;
        }
        currentX = (int)event.getRawX();
        currentY = (int)event.getRawY();
        return true;
    }*/

}
