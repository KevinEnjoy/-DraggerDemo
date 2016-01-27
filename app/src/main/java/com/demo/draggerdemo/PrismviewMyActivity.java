package com.demo.draggerdemo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.demo.fragment.FragmentText;
import com.github.ppamorim.PrismPosition;
import com.github.ppamorim.SpringType;
import com.github.ppamorim.creator.FragmentViewItemAdapter;
import com.github.ppamorim.creator.FragmentViewItems;
import com.github.ppamorim.prismview.PrismActivity;

public class PrismviewMyActivity extends PrismActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prismview_my);


        setPrismPosition(PrismPosition.BOTTOM); //optional, Use: LEFT, RIGHT, TOP, BOTTOM
        setSpringType(SpringType.SPEEDBOUNCINESS); //optional, Use: ORIGAMI, SPEEDBOUNCINESS
        setBouncenessSpeed(2, 2); //optional


    }

    public void initToolbar(String title){

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 要在这里初始化View ，onCreate方法初始化View会出空指针错误。
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        initToolbar("Prismview");
        FragmentViewItemAdapter fragmentViewItemAdapter =
                new FragmentViewItemAdapter(FragmentViewItems.with(this)
                        .add("tag0", FragmentText.class)
                        .add("tag1", FragmentText.class)
                        .create());
        setAdapter(fragmentViewItemAdapter);
        findViewById(R.id.btn_red).setOnClickListener(this);
        findViewById(R.id.btn_blue).setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        if (isRevelead()) {
            hide();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_red:
                show(0);
                break;
            default:
                show(1);
                break;
        }
    }
}
