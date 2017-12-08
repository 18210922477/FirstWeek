package com.jiyun.firstweek;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jiyun.firstweek.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mStartPager;
    private LinearLayout mLinearPoint;
    private int[] imgs;
    private Button mBtnStart;
    private List<ImageView> imageList;
    private List<ImageView> pointList;
    private MyPagerAdapter myPagerAdapter;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("1024", MODE_PRIVATE);
        int num = preferences.getInt("num", 3);
        if (num==2){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        }else{
            preferences = getSharedPreferences("1024", MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putInt("num",2);
            edit.commit();
            initView();
            initData();
        }

    }

    private void initView() {
        mStartPager = (ViewPager) findViewById(R.id.mStartPager);
        mLinearPoint = (LinearLayout) findViewById(R.id.mLinearPoint);
        mBtnStart = (Button) findViewById(R.id.mBtnStart);
        imageList=new ArrayList<>();
        myPagerAdapter = new MyPagerAdapter(imageList);
        mStartPager.setAdapter(myPagerAdapter);
        mBtnStart.setOnClickListener(this);
        mStartPager.addOnPageChangeListener(this);
    }
    private void initData(){
        imgs=new int[]{R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(imgs[i]);
            imageList.add(imageView);
        }
        myPagerAdapter.notifyDataSetChanged();
        pointList=new ArrayList<>();
        for (int i = 0; i < imageList.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(25,25));
            imageView.setPadding(20,0,20,0);
            if (i==0){
                imageView.setBackgroundResource(R.drawable.shape1);
            }else{
                imageView.setBackgroundResource(R.drawable.shape2);
            }
            mLinearPoint.addView(imageView);
            pointList.add(imageView);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBtnStart:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < imageList.size(); i++) {
            if (position==i){
                pointList.get(i).setBackgroundResource(R.drawable.shape1);
            }else{
                pointList.get(i).setBackgroundResource(R.drawable.shape2);
            }
        }
        if (position==imageList.size()-1){
            mBtnStart.setVisibility(View.VISIBLE);
            mLinearPoint.setVisibility(View.GONE);
        }else{
            mBtnStart.setVisibility(View.GONE);
            mLinearPoint.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
