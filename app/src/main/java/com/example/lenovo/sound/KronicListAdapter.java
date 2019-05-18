package com.example.lenovo.sound;



import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.List;

public class KronicListAdapter extends BaseAdapter {


    List<KronicFragment.MenuItem> list;
    LayoutInflater mInflater;
    Activity mActivity;
    FragmentManager fragmentManager;

    public KronicListAdapter(Activity activity, List<KronicFragment.MenuItem> list, FragmentManager fragmentManager)
    {
        this.mActivity = activity;
        this.list = list;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.fragmentManager = fragmentManager;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView;
        KronicFragment.MenuItem item = list.get(position);
        rowView = mInflater.inflate(R.layout.kronic_row_layout, null);
        TextView text = rowView.findViewById(R.id.kronic_row_txt);
        final CheckBox checkBox = rowView.findViewById(R.id.kronic_row_check);
        checkBox.setChecked(item.isSelected);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).setSelected(isChecked);
            }
        });
        rowView.setTag(item.getTag());
        text.setText(item.getTitle());
        rowView.setTag(item.getTag());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rowView;
    }



}


