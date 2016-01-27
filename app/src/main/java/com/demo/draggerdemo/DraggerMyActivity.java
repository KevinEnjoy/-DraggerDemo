package com.demo.draggerdemo;

import android.os.Bundle;

public class DraggerMyActivity extends BaseDraggerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger_my);

        initDraggerView();
        initToolbar("Dragger");
    }
}
