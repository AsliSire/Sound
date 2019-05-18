package com.example.lenovo.sound;

import android.app.Application;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FontApp extends Application   {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/CinzelDecorative-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()

        );
    }
}
