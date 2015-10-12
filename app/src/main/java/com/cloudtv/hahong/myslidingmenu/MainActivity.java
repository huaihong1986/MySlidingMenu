package com.cloudtv.hahong.myslidingmenu;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import lib.SlidingMenu;
import lib.SlidingMenu.OnOpenListener;
import lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {

    private Fragment mContent;
    private static String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        // check if the content frame contains the menu frame
        if (findViewById(R.id.menu_frame) == null) {
            Log.v(TAG, "null");
            setBehindContentView(R.layout.menu_frame);
            getSlidingMenu().setSlidingEnabled(true);
            getSlidingMenu()
                    .setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        } else {


            // add a dummy view
            Log.v(TAG, "add a dummy view::");
            View v = new View(this);
            setBehindContentView(v);
            getSlidingMenu().setSlidingEnabled(false);
            getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }

        // set the Above View Fragment
        if (savedInstanceState != null) {
            mContent = getSupportFragmentManager().getFragment(
                    savedInstanceState, "mContent");
        }

        if (mContent == null) {
            mContent = new FilmsClassificationFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, mContent).commit();

        // set the Behind View Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, new MenuFragment()).commit();

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
//		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setBehindOffset(metric.widthPixels/3);
        sm.setFadeEnabled(false);
        sm.setBehindScrollScale(0.25f);
        sm.setFadeDegree(0.25f);
        sm.setOnOpenListener(openListener);

//		sm.setBackgroundImage(R.drawable.img_frame_background);
        sm.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
//				float scale = (float) (percentOpen * 0.25 + 0.75);
                float scale = (float) 1.0;
                canvas.scale(scale, scale, -canvas.getWidth() / 2,
                        canvas.getHeight() / 2);
            }
        });

        sm.setAboveCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
//				float scale = (float) (1 - percentOpen * 0.25);
                float scale = 1.0f;

                canvas.scale(scale, scale, 0, canvas.getHeight() / 2);
            }
        });

    }


    private OnOpenListener openListener = new OnOpenListener(){

        @Override
        public void onOpen() {
            // TODO Auto-generated method stub
            MenuFragment articleFrag = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.menu_frame);
            articleFrag.updateIpEdittext();
        }

    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);

        if (this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
            // Nothing need to be done here

        } else {
            // Nothing need to be done here

        }
    }


    @Override
    public void onClick(View view) {

    }
}
