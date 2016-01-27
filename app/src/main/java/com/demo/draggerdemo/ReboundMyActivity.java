package com.demo.draggerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.facebook.rebound.BaseSpringSystem;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class ReboundMyActivity extends BaseDraggerActivity {

    private final String TAG = getClass().getName();
    ImageView houzi;
    private  BaseSpringSystem mSpringSystem ;
    private  ExampleSpringListener mSpringListener ;
    private FrameLayout mRootView;
    private Spring mScaleSpring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebound_my);
        initToolbar("Rebound");
        houzi = (ImageView)findViewById(R.id.houzi);
        mRootView = (FrameLayout) findViewById(R.id.root_view);

        initRebound();
    }

    public void initRebound(){

        mSpringSystem = SpringSystem.create();
        mSpringListener = new ExampleSpringListener();

        // Create the animation spring.
        mScaleSpring = mSpringSystem.createSpring();

        //Config spring.
        SpringConfig config =  mScaleSpring.getSpringConfig();
        //config.tension = 230.2;//default value 230.2;
        //config.friction = 22.0;//default.value 22.0
        Log.d(TAG,"config default tension value ="+config.tension);
        Log.d(TAG,"config default friction value ="+config.friction);

        // Add an OnTouchListener to the root view.
        mRootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // When pressed start solving the spring to 1.
                        mScaleSpring.setEndValue(1);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // When released start solving the spring to 0.
                        mScaleSpring.setEndValue(0);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add a listener to the spring when the Activity resumes.
        mScaleSpring.addListener(mSpringListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Remove the listener to the spring when the Activity pauses.
        mScaleSpring.removeListener(mSpringListener);
    }
    private class ExampleSpringListener extends SimpleSpringListener {
        @Override
        public void onSpringUpdate(Spring spring) {
            // On each update of the spring value, we adjust the scale of the image view to match the
            // springs new value. We use the SpringUtil linear interpolation function mapValueFromRangeToRange
            // to translate the spring's 0 to 1 scale to a 100% to 50% scale range and apply that to the View
            // with setScaleX/Y. Note that rendering is an implementation detail of the application and not
            // Rebound itself. If you need Gingerbread compatibility consider using NineOldAndroids to update
            // your view properties in a backwards compatible manner.
            float mappedValue = (float) SpringUtil.mapValueFromRangeToRange(spring.getCurrentValue(), 0, 1, 1, 0.5);
            houzi.setScaleX(mappedValue);
            houzi.setScaleY(mappedValue);
        }
    }

}
