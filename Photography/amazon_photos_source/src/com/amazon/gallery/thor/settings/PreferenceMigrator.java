// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;

public class PreferenceMigrator
{

    public static int CURRENT_VERSION = 2;
    public static String VERSION_PREFERENCE = "preferences_version_code";

    private static void migratePreferencesFromTruth(Context context)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedpreferences1 = context.getSharedPreferences("SharedPrefs", 0);
        Object obj = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        AospPreferences aosppreferences = new AospPreferences(context);
        String s = sharedpreferences1.getString("sso_account", null);
        if (s == null)
        {
            return;
        }
        aosppreferences.setSignedInAccount(s);
        if (aosppreferences.signedIn())
        {
            ((MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO)).onAccountRegistered();
        }
        aosppreferences.setCustomerId(sharedpreferences1.getString("customerId", ""));
        aosppreferences.setDeviceUUID(sharedpreferences1.getString("deviceUuid", null));
        aosppreferences.setTruthDatabaseId(sharedpreferences1.getString("signin_id", null));
        boolean flag = sharedpreferences1.getBoolean("ack_auto_save", false);
        ((SharedPreferences) (obj)).edit().putBoolean("auto_upload_notification_key", flag).apply();
        flag = sharedpreferences.getBoolean("key_autosave", false);
        aosppreferences.setAutoSaveEnabled(flag);
        if (!flag)
        {
            sharedpreferences.edit().putBoolean("auto_upload_photos_key", false).apply();
            sharedpreferences.edit().putBoolean("auto_upload_videos_key", false).apply();
        } else
        {
            flag = sharedpreferences.getBoolean("key_autosave_photos", true);
            sharedpreferences.edit().putBoolean("auto_upload_photos_key", flag).apply();
            flag = sharedpreferences.getBoolean("key_autosave_videos", true);
            sharedpreferences.edit().putBoolean("auto_upload_videos_key", flag).apply();
        }
        flag = sharedpreferences.getBoolean("key_autosave_wifi_only", true);
        obj = sharedpreferences.edit();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("wan_allowed_key", flag).apply();
        context.getSharedPreferences("authentication_shared_prefs_file_key", 0).edit().putBoolean("truth_upgrade_key", true).apply();
        sharedpreferences1.edit().clear().apply();
        sharedpreferences.edit().remove("key_autosave").remove("key_autosave_wifi_only").remove("key_autosave_photos").remove("key_autosave_videos").apply();
    }

    public static void updatePreferences(Context context)
    {
        SharedPreferences sharedpreferences;
        int i;
        boolean flag;
        flag = true;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        i = sharedpreferences.getInt(VERSION_PREFERENCE, 0);
        if (i == CURRENT_VERSION)
        {
            return;
        }
        i;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 71
    //                   1 81;
           goto _L1 _L2 _L3
_L1:
        sharedpreferences.edit().putInt(VERSION_PREFERENCE, CURRENT_VERSION).apply();
        return;
_L2:
        if (BuildFlavors.isAosp())
        {
            migratePreferencesFromTruth(context);
        } else
        if (sharedpreferences.contains("auto_upload_key"))
        {
            if (sharedpreferences.getBoolean("auto_upload_key", false))
            {
                sharedpreferences.edit().putBoolean("auto_upload_photos_key", true).putBoolean("auto_upload_videos_key", true).apply();
            }
            sharedpreferences.edit().remove("auto_upload_key").apply();
            sharedpreferences.edit().putBoolean("auto_upload_update_key", true).apply();
        }
_L3:
        if (sharedpreferences.contains("wifi_only_key"))
        {
            context = sharedpreferences.edit();
            if (sharedpreferences.getBoolean("wifi_only_key", true))
            {
                flag = false;
            }
            context.putBoolean("wan_allowed_key", flag).remove("wifi_only_key").apply();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

}
