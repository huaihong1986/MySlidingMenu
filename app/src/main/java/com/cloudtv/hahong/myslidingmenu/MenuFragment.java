package com.cloudtv.hahong.myslidingmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib.app.SlidingFragmentActivity;

public class MenuFragment extends Fragment implements OnClickListener {

    private ListView mListView;
    private Context mContext;
    private MenuListAdapter menuListAdapter;
    private View mView;
    private EditText ip_edittext;
    private TextView ip_sure;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.layout_menu, null);
        mContext = this.getActivity();
        initLayout();
        return mView;
    }

    private void initLayout(){
        ip_edittext = (EditText) mView.findViewById(R.id.ip_edittext);
        ip_sure = (TextView) mView.findViewById(R.id.ip_sure);
        ip_sure.setOnClickListener(this);

        mListView = (ListView) mView.findViewById(R.id.menulistview);
        menuListAdapter = new MenuListAdapter(mContext);
        mListView.setAdapter(menuListAdapter);
        mListView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                menuListAdapter.setSelectItem(position);
                menuListAdapter.notifyDataSetChanged();
            }

        });
    }

    public void updateIpEdittext(){
        ip_edittext.setText(Constant.BASE_IP);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.ip_sure:
                String[] spStr = ip_edittext.getText().toString().split(":");


                Pattern pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");

                Matcher matcher = pattern.matcher(spStr[0]); //以验证127.400.600.2为例



                if(matcher.matches()) {
                    Constant.setBase_Ip(ip_edittext.getText().toString());
                    Log.i("yang", "onClick::Constant.BASE_IP::" + Constant.BASE_IP);
                    ((SlidingFragmentActivity) mContext).getSlidingMenu().showContent();
//                    FilmsClassificationFragment articleFrag = (FilmsClassificationFragment)
//                            ((FragmentActivity) mContext).getSupportFragmentManager().findFragmentById(R.id.content_frame);
//                    articleFrag.obtainCloudTviCategory(1);
//                    articleFrag.creatNewBaseIpConfig();
                }
                else {

                    Toast.makeText(mContext, "IP地址格式错误", Toast.LENGTH_SHORT).show();

                }
                break;

        }

    }
}