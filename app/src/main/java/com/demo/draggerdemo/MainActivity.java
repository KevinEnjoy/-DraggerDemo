package com.demo.draggerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.ppamorim.dragger.DraggerPosition;

import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClickBtn(View view){
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        switch (view.getId()){
            case R.id.btn_dragger:
                intent.setClass(this,DraggerMyActivity.class);
                break;
            case R.id.btn_prismview:
                intent.setClass(this,PrismviewMyActivity.class);

                break;
            case R.id.btn_rebound:
                intent.setClass(this,ReboundMyActivity.class);

                break;
        }
        startActivity(intent);
    }
}
