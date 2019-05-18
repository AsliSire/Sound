package com.example.lenovo.sound;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuListAdapter extends BaseAdapter {

    List<MenuFragment.MenuItem> list;
    LayoutInflater mInflater;
    Activity mActivity;
    FragmentManager fragmentManager;

    public MenuListAdapter(Activity activity, List<MenuFragment.MenuItem> list, FragmentManager fragmentManager)
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;
        MenuFragment.MenuItem item = list.get(position);
        rowView = mInflater.inflate(R.layout.drawer_menu_row_layout, null);

        ImageView img = rowView.findViewById(R.id.menu_row_img);
        TextView text = rowView.findViewById(R.id.menu_row_text);
        //rowView.setTag(item.getTag());

        img.setBackgroundResource(item.getImg());
        text.setText(item.getTitle());
        rowView.setTag(item.getTag());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                switch (v.getTag().toString()) {
                    case "message" : {
                        fragment = new ProfileFragment();
                        Log.d("menu_log", "message fragment");
                        break;
                    }

                    case "location" : {
                        fragment = new ProfileFragment();
                        Log.d("menu_log", "location fragment");
                        break;
                    }

                    case "call" : {
                        fragment = new ProfileFragment();
                        Log.d("menu_log", "call fragment");
                        break;
                    }

                    case "blog" : {
                        fragment = new BlogFragment();
                        Log.d("menu_log", "blog fragment");
                        break;

                    }

                    case "gallery" : {
                        fragment = new GalleryFragment();
                        Log.d("menu_log", "gallery fragment");
                        break;
                    }

                    case "pills" : {
                        fragment = new PillFragment();
                        Log.d("menu_log", "pill fragment");
                        break;
                    }

                    case "settings" : {
                        fragment = new SettingsFragment();
                        Log.d("menu_log", "settings fragment");
                        break;

                    }


                }
                loadFragment(fragment);

            }
        });

        return rowView;
    }

    private boolean loadFragment(Fragment fragment)
    {
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }

        return false;
    }

}
