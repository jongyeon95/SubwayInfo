package com.example.jongyepn.subwayinfo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;
import uk.co.senab.photoview.PhotoViewAttacher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
static StaionAdapter adapter;
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
PhotoViewAttacher mAttacher;
private Bitmap imagebitmap = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView =(ScrollView)findViewById(R.id.ScrollView);
  //      imageView =(ImageView)findViewById(R.id.imageView);
       scrollView.setHorizontalScrollBarEnabled(true);
        Resources res=getResources();
     //   bitmap =(BitmapDrawable)res.getDrawable(R.drawable.seoulsubway);
      // int bitmapWidth=bitmap.getIntrinsicWidth();
      // int bitmapHeight=bitmap.getIntrinsicHeight();
//       imageView.setImageDrawable(bitmap);
    //   imageView.getLayoutParams().width=10000;
    //   imageView.getLayoutParams().height=10000;
       // loadBitmapImage(imageView,R.drawable.iiii);
       // imageView.setImageResource(R.drawable.seoulsubway);
      // mAttacher = new PhotoViewAttacher(imageView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
    private  void loadBitmapImage(ImageView imageView, int imageId){
        BitmapFactory.Options options =new BitmapFactory.Options();
        options.inPreferredConfig =Bitmap.Config.RGB_565;//디코딩될 포맷 지정
        options.inSampleSize=2;//축소해서 디코딩 가로세로 2로 나눔
        options.inMutable =true;// 변환가능한 mutable형태로 반환
        if(imagebitmap != null){
            options.inBitmap =imagebitmap;
        }
        imagebitmap =BitmapFactory.decodeResource(getResources(),imageId,options);
        if(imagebitmap==null){
            Toast.makeText(this,"Fail", Toast.LENGTH_SHORT);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),imagebitmap);
        imageView.setImageDrawable(bitmapDrawable);
    }

}
