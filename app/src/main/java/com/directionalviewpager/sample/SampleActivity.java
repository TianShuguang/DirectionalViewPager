package com.directionalviewpager.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.directionalviewpager.DirectionalViewPager;
import com.directionalviewpager.R;

public class SampleActivity extends FragmentActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar= (Toolbar) this.findViewById(R.id.toolbar);

        mToolbar.setTitle("HORIZONTAL");

        //Set up the pager
        final DirectionalViewPager pager = (DirectionalViewPager)findViewById(R.id.pager);
        pager.setAdapter(new TestFragmentAdapter(getSupportFragmentManager()));

        //Bind to control buttons
        ((Button)findViewById(R.id.horizontal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setTitle("HORIZONTAL");
                pager.setOrientation(DirectionalViewPager.HORIZONTAL);
            }
        });
        ((Button)findViewById(R.id.vertical)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setTitle("VERTICAL");
                pager.setOrientation(DirectionalViewPager.VERTICAL);
            }
        });
    }
}
