package com.example.lenovo.sound;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    
    private FragmentActivity context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (FragmentActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView list = view.findViewById(R.id.list_menu);
        MenuListAdapter adapter = new MenuListAdapter(getActivity(), menuItems(), this.context.getSupportFragmentManager());
        list.setAdapter(adapter);
        return view;
    }

    public List<MenuItem> menuItems() {

        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(R.drawable.ic_message, R.string.menu_message, "message"));
        items.add(new MenuItem(R.drawable.ic_location, R.string.menu_location, "location"));
        items.add(new MenuItem(R.drawable.ic_mic, R.string.menu_call,"call"));
        items.add(new MenuItem(R.drawable.ic_quiz, R.string.menu_blog,"blog"));
        items.add(new MenuItem(R.drawable.ic_menu_gallery, R.string.menu_gallery,"gallery"));
        items.add(new MenuItem(R.drawable.ic_menu_manage, R.string.menu_settings,"settings"));
        items.add(new MenuItem(R.drawable.ic_menu_pill, R.string.menu_pill,"pills"));
        items.add(new MenuItem(R.drawable.ic_menu_share, R.string.menu_share,"share"));
        items.add(new MenuItem(R.drawable.ic_rate_us, R.string.menu_rate_us,"rate_us"));
        items.add(new MenuItem(R.drawable.ic_report_problem, R.string.menu_feedback,"feedback"));
        items.add(new MenuItem(R.drawable.ic_contact, R.string.menu_contact,"contact"));
        items.add(new MenuItem(R.drawable.ic_info, R.string.menu_about_us,"about_us"));
        return items;
    }

    class MenuItem {
        int img;
        int title;
        String tag;

        MenuItem(int drawable, int title, String tag) {
            this.img = drawable;
            this.title = title;
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }
    }
}
