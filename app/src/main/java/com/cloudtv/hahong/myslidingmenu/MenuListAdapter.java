package com.cloudtv.hahong.myslidingmenu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MenuListAdapter extends BaseAdapter {
    private final String TAG = "MenuListAdapter";
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectItem = 0;
    private int[] sourceM;
    private int[] sourceM_select;
    private String[] sourceM_tittle;
    public MenuListAdapter(Context context)
    {
        super();
        mContext = context;
        mInflater = LayoutInflater.from(context);
        sourceM = new int[] {R.drawable.base_ziliao_unselected, R.drawable.shoucang_unselected,R.drawable.message_unselect,
                R.drawable.histort_task_unselected, R.drawable.un_do_task_unselected, R.drawable.qiandao_unselected,R.drawable.search_unselected};
        sourceM_select = new int[] {R.drawable.base_ziliao_selected, R.drawable.shoucang_selected,R.drawable.message_select,
                R.drawable.histort_task_selected, R.drawable.un_do_task_selected, R.drawable.qiandao_selected,R.drawable.search_selected};
        sourceM_tittle = new String[]{"基本资料","收    藏","消    息","历史任务","未完成任务","签    到","搜    索"};
    }

    @Override
    public int getCount()
    {
        if (null != sourceM_tittle)
        {
            return sourceM_tittle.length;
        } else
        {
            return 0;
        }
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public void setSelectItem(int index){
        selectItem = index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.menulist_item, null);
            viewHolder = new ViewHolder();
            viewHolder.bglayout = (RelativeLayout) convertView.findViewById(R.id.bglayout);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.menu_icon);

            viewHolder.title = (TextView) convertView.findViewById(R.id.tittle);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(selectItem == position){
            viewHolder.bglayout.setBackgroundResource(R.color.pagerslidinge_back);
            viewHolder.icon.setImageResource(sourceM_select[position]);
            viewHolder.title.setTextColor(0xffffffff);
        }else{
            viewHolder.bglayout.setBackgroundResource(R.color.transparent);
            viewHolder.icon.setImageResource(sourceM[position]);
            viewHolder.title.setTextColor(0xba000000);


        }

        Log.i(TAG, "MenuListAdapterposition:::" + position);

        viewHolder.title.setText(sourceM_tittle[position]);
        return convertView;
    }
    class ViewHolder{
        public TextView title;
        public ImageView icon;
        public RelativeLayout bglayout;

    }
}
