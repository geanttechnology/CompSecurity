// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class UploadPreferences
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent DisableAutoPhotoSave;
        public static final MetricsEvent DisableAutoVideoSave;
        public static final MetricsEvent EnableAutoPhotoSave;
        public static final MetricsEvent EnableAutoVideoSave;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/upload/UploadPreferences$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            EnableAutoPhotoSave = new MetricsEvent("EnableAutoPhotoSave", 0);
            DisableAutoPhotoSave = new MetricsEvent("DisableAutoPhotoSave", 1);
            EnableAutoVideoSave = new MetricsEvent("EnableAutoVideoSave", 2);
            DisableAutoVideoSave = new MetricsEvent("DisableAutoVideoSave", 3);
            $VALUES = (new MetricsEvent[] {
                EnableAutoPhotoSave, DisableAutoPhotoSave, EnableAutoVideoSave, DisableAutoVideoSave
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/upload/UploadPreferences.getName();
    private final SharedPreferences sharedPreferences;

    public UploadPreferences(Context context)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static void initializeBooleanPreference(SharedPreferences sharedpreferences, String s, boolean flag)
    {
        if (!sharedpreferences.contains(s))
        {
            GLogger.i(TAG, "Initializing %s to %b", new Object[] {
                s, Boolean.valueOf(flag)
            });
            sharedpreferences.edit().putBoolean(s, flag).apply();
        }
    }

    public static void initializeDefaultPreferences(Context context)
    {
        context = PreferenceManager.getDefaultSharedPreferences(context);
        initializeBooleanPreference(context, "auto_upload_photos_key", false);
        initializeBooleanPreference(context, "auto_upload_videos_key", false);
        initializeBooleanPreference(context, "auto_upload_only_when_charging_key", false);
        initializeBooleanPreference(context, "auto_save_all_future_tags", false);
        initializeBooleanPreference(context, "auto_save_all_future_removable_tags", false);
        initializeBooleanPreference(context, "wan_allowed_key", false);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        return sharedPreferences.getBoolean(s, flag);
    }

    public boolean isAutoUploadEnabled()
    {
        boolean flag = false;
        if (getBoolean("auto_upload_photos_key", false) || getBoolean("auto_upload_videos_key", false))
        {
            flag = true;
        }
        return flag;
    }

}
