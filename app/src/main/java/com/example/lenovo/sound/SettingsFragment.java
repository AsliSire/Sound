package com.example.lenovo.sound;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class SettingsFragment extends Fragment {

    private FragmentActivity context;
    FragmentManager fragmentManager;
    RelativeLayout lyUser;
    RelativeLayout lyPass;
    RelativeLayout lyEducation;
    RelativeLayout lyJob;
    RelativeLayout lyGender;
    RelativeLayout lyMaritalStatus;
    RelativeLayout lyDob;
    RelativeLayout lyGuideBook;
    RelativeLayout lyKronic;
    RelativeLayout lyBlood;
    RelativeLayout lyNotify;
    RelativeLayout lyReminder;
    RelativeLayout lyDeleteAll;
    RelativeLayout lyExit;
    Switch switchNotify;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (FragmentActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        ImageView imgView = (ImageView)v.findViewById(R.id.img_reminder);

        switchNotify = v.findViewById(R.id.SwitchNotify);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            switchNotify.getTrackDrawable().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.MULTIPLY);
        }
        switchNotify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                    //switchNotify.getThumbDrawable().setColorFilter(isChecked ? Color.WHITE : Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    //switchNotify.getThumbDrawable().setColorFilter(!isChecked ? Color.WHITE : Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    switchNotify.getTrackDrawable().setColorFilter(isChecked ? getResources().getColor(R.color.colorToggle) : Color.BLACK, PorterDuff.Mode.MULTIPLY);
                }
            }
        });

        //Username Layout onClickmetod
        lyUser = v.findViewById(R.id.lyUser);
        lyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateUserNameDialogFragment newFragment = new UpdateUserNameDialogFragment();
                newFragment.show(getFragmentManager(), "username");
            }
        });

        //Password Layout onClickmetod
        lyPass =v.findViewById(R.id.lyPass);
        lyPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePasswordDialogFragment newFragment =new UpdatePasswordDialogFragment();
                newFragment.show(getFragmentManager(), "password");
            }
        });

        //Education Layout onClickmetod
        lyEducation =v.findViewById(R.id.lyEducation);
        lyEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateEducationDialogFragment newFragment =new UpdateEducationDialogFragment();
                newFragment.show(getFragmentManager(),"education");
            }
        });

        //Job Layout onClickmetod
        lyJob =v.findViewById(R.id.lyJob);
        lyJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateJobDialogFragment newFragment =new UpdateJobDialogFragment();
                newFragment.show(getFragmentManager(),"job");
            }
        });

        //Gender Layout onClickmetod
        lyGender=v.findViewById(R.id.lyGender);
        lyGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateGenderDialogFragment newFragment =new UpdateGenderDialogFragment();
                newFragment.show(getFragmentManager(),"gender");
            }
        });


        //MaritalStatus Layout onClickmetod
        lyMaritalStatus =v.findViewById(R.id.lyMaritalStatus);
        lyMaritalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateMaritalStatusDialogFragment newFragment =new UpdateMaritalStatusDialogFragment();
                newFragment.show(getFragmentManager(),"marital_status");
            }
        });

        //fragment AddToGuideBook
        lyGuideBook=v.findViewById(R.id.lyGuideBook);
        lyGuideBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment =new AddToGuideFragment();
                loadFragment(fragment);
            }
        });

        //fragment kronic
        lyKronic =v.findViewById(R.id.lyKronic);
        lyKronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment =new KronicFragment();
                loadFragment(fragment);
            }
        });


        //Bloodgroup Layout onClickmetod
        lyBlood = v.findViewById(R.id.lyBloodGroup);
        lyBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateBloodDialogFragment newFragment = new UpdateBloodDialogFragment();
                newFragment.show(getFragmentManager(), "bloodgroup");
            }
        });

        //fragment reminder
        lyReminder =v.findViewById(R.id.lyReminder);
        lyReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment =new ReminderFragment();
                loadFragment(fragment);
            }
        });

        return v;


    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            this.context.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }

        return false;
    }
}

