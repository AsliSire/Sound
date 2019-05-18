package com.example.lenovo.sound;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ReminderRecyclerAdapterColumn2 extends BaseAdapter {

    List<ReminderFragment.ColumnItem> Column2;
    LayoutInflater mInflater;
    Activity mActivity;
    FragmentManager fragmentManager;

    public ReminderRecyclerAdapterColumn2(Activity activity,List<ReminderFragment.ColumnItem> Column2, FragmentManager fragmentManager){

        this.mActivity = activity;
        this.Column2 = Column2;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return Column2.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
