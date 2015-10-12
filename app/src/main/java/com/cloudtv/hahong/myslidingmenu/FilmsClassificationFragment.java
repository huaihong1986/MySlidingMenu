package com.cloudtv.hahong.myslidingmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hahong on 15-10-12.
 */
public class FilmsClassificationFragment extends android.support.v4.app.Fragment {
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.layout_helloworld,
                container, false);

        return mView;
    }
}
