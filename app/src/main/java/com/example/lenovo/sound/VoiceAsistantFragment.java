package com.example.lenovo.sound;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class VoiceAsistantFragment extends Fragment {



    public Button openMic;
    public TextView showVoiceText;
    private final int REQ_CODE_SPEECH_OUTPUT = 143;


    MediaPlayer mPlayer = new MediaPlayer();
    public boolean isPlaying = false;
    public boolean isPaused = false;
    int result;
    TextToSpeech t1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voice_asistant, container, false);

        showVoiceText =(TextView) view.findViewById(R.id.showVoiceOutput);

        openMic = (Button) view.findViewById(R.id.buttonMic);

        openMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnToOpenMic();
            }
        });

        t1 = new TextToSpeech(getActivity().getApplicationContext(), new android.speech.tts.TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = t1.setLanguage(Locale.getDefault());
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Özellik desteklenmiyor", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity().setContentView(R.layout.fragment_voice_asistant);



    }



    private void btnToOpenMic() {
        speechStandby();
    }

    void speechStandby() {
        if (isPlaying) {
            mPlayer.pause();
            isPaused = true;
        }
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Şimdi konuşun...");

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_OUTPUT);
        } catch (ActivityNotFoundException tim) {

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_OUTPUT: {
                if (resultCode == Activity.RESULT_OK && null != data) {

                    ArrayList voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String keyword = voiceInText.get(0).toString().toLowerCase();


                    if (keyword.contains("acil") || keyword.contains("durum") || keyword.contains("başım dertte")) {
                        Toast.makeText(this.getActivity(), "alarm", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("neredeyim") || keyword.contains("kayboldum")) {
                        Toast.makeText(this.getActivity(), "maps aç", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("konum gönder") && keyword.contains("kişi bir")) {
                        Toast.makeText(this.getActivity(), "konum bir", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("konum gönder") && keyword.contains("kişi 2")) {
                        Toast.makeText(this.getActivity(), "konum iki", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("konum gönder") && keyword.contains("kişi 3")) {
                        Toast.makeText(this.getActivity(), "konum üç", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("ara") && keyword.contains("bir")) {
                        Toast.makeText(this.getActivity(), "ara bir", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("ara") && (keyword.contains("2"))) {
                        Toast.makeText(this.getActivity(), "ara iki", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("ara") && keyword.contains("3")) {
                        Toast.makeText(this.getActivity(), "ara üç", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("hava")) {
                        Toast.makeText(this.getActivity(), "openweather", Toast.LENGTH_LONG).show();
                    }

                    else if (keyword.contains("saat kaç")) {
                        time();
                    }

                    else if (keyword.contains("gün")) {
                        date();
                    }

                }
            }
        }
    }

    public void toSpeak (String toSpeak){
        Toast.makeText(getActivity().getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
        int speak = t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void time () {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strTime =mdformat.format(calendar.getTime());
        toSpeak(strTime);
    }


    public void date () {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MMM-yyyy EEEE");
        String strDate = "bugün : " + mdformat.format(calendar.getTime());
        toSpeak(strDate);
    }












}
