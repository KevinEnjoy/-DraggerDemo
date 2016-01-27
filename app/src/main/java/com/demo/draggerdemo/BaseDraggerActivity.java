package com.demo.draggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.ppamorim.dragger.DraggerView;

public class BaseDraggerActivity extends AppCompatActivity {
    DraggerView draggerView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public void initDraggerView(){
        draggerView = (DraggerView) findViewById(R.id.dragger_view);

    }

    public void initToolbar(String title){

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(draggerView!=null){
                    draggerView.closeActivity();
                }else {
                    finish();
                }
            }
        });
    }
}
