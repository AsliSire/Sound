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

public class KronicFragment extends Fragment {

    private FragmentActivity context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (FragmentActivity) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.kronic_illnesses, container, false);

        ListView list = view.findViewById(R.id.list_menu);
        KronicListAdapter adapter = new KronicListAdapter(getActivity(), menuItems(), this.context.getSupportFragmentManager());
        list.setAdapter(adapter);
        return view;
    }

    public List<MenuItem> menuItems() {
        List<MenuItem> items = new ArrayList<>();



        items.add(new MenuItem(R.string.kronic_addison, "addison"));
        items.add(new MenuItem(R.string.kronic_astim, "astım"));
        items.add(new MenuItem(R.string.kronic_alzheimer, "alzheimer"));
        items.add(new MenuItem(R.string.kronic_behcet, "behcet"));
        items.add(new MenuItem(R.string.kronic_bobrek, "bobrek"));
        items.add(new MenuItem(R.string.kronic_cilt, "cilt"));
        items.add(new MenuItem(R.string.kronic_dismenore, "dismenore"));
        items.add(new MenuItem(R.string.kronic_endokrin, "endokrin"));
        items.add(new MenuItem(R.string.kronic_fibromyalji, "fibromyalji"));
        items.add(new MenuItem(R.string.kronic_gastrit, "gastrit"));
        items.add(new MenuItem(R.string.kronic_göz, "goz"));
        items.add(new MenuItem(R.string.kronic_hormon, "hormon"));
        items.add(new MenuItem(R.string.kronic_immun, "otoimmun"));
        items.add(new MenuItem(R.string.kronic_kalpdamar, "kalpdamar"));
        items.add(new MenuItem(R.string.kronic_kanser, "kanser"));
        items.add(new MenuItem(R.string.kronic_karaciğer, "karaciger"));
        items.add(new MenuItem(R.string.kronic_kas, "kas"));
        items.add(new MenuItem(R.string.kronic_kulak, "kulak"));
        items.add(new MenuItem(R.string.kronic_kusing, "exit"));
        items.add(new MenuItem(R.string.kronic_lyme, "exit"));
        items.add(new MenuItem(R.string.kronic_meniere, "meniere"));
        items.add(new MenuItem(R.string.kronic_migren, "migren"));
        items.add(new MenuItem(R.string.kronic_ms, "ms"));
        items.add(new MenuItem(R.string.kronic_norolojik, "norolojik"));
        items.add(new MenuItem(R.string.kronic_parkinson, "parkinson"));
        items.add(new MenuItem(R.string.kronic_psyco, "psikiyatrik"));
        items.add(new MenuItem(R.string.kronic_romatizma, "romatizmal"));
        items.add(new MenuItem(R.string.kronic_sle, "sle"));
        items.add(new MenuItem(R.string.kronic_solunum, "solunum"));
        items.add(new MenuItem(R.string.kronic_tiroid, "tiroid"));
        items.add(new MenuItem(R.string.kronic_tuberkuloz, "tuberkuloz"));
        items.add(new MenuItem(R.string.kronic_ulser, "peptikulser"));
        items.add(new MenuItem(R.string.kronic_verem, "verem"));
        items.add(new MenuItem(R.string.kronic_yuksek_tansiyon, "yuksektansiyon"));

        return items;
    }


    class MenuItem {

        int title;
        String tag;
        boolean isSelected;


        MenuItem(int title, String tag) {
            this.title = title;
            this.tag = tag;
            this.isSelected = false;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }


        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }
    }
}

