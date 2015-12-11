// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.arellomobile.android.push.preference.SoundType;
import com.arellomobile.android.push.preference.VibrateType;

public class PreferenceUtils
{

    private static final String LAST_REGISTRATION = "last_registration_change";
    private static final String PREFERENCE = "com.pushwoosh.pushnotifications";

    public PreferenceUtils()
    {
    }

    public static String getApplicationId(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getString("dm_pwapp", "");
    }

    public static String getBaseUrl(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getString("pw_base_url", "");
    }

    public static boolean getEnableLED(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getBoolean("dm_ledon", false);
    }

    public static boolean getForceRegister(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getBoolean("pw_forceregister", false);
    }

    public static long getLastRegistration(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getLong("last_registration_change", 0L);
    }

    public static boolean getLightScreenOnNotification(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getBoolean("dm_lightson", false);
    }

    public static int getMessageId(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getInt("dm_messageid", 1001);
    }

    public static boolean getMultiMode(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getBoolean("dm_multimode", false);
    }

    public static String getProjectId(Context context)
    {
        return context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getString("dm_sender_id", "");
    }

    public static SoundType getSoundType(Context context)
    {
        return SoundType.fromInt(Integer.valueOf(context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getInt("dm_soundtype", 0)).intValue());
    }

    public static VibrateType getVibrateType(Context context)
    {
        return VibrateType.fromInt(Integer.valueOf(context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).getInt("dm_vibratetype", 0)).intValue());
    }

    public static void resetLastRegistration(Context context)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.remove("last_registration_change");
        context.commit();
    }

    public static void setApplicationId(Context context, String s)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putString("dm_pwapp", s);
        context.commit();
    }

    public static void setBaseUrl(Context context, String s)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putString("pw_base_url", s);
        context.commit();
    }

    public static void setEnableLED(Context context, boolean flag)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putBoolean("dm_ledon", flag);
        context.commit();
    }

    public static void setForceRegister(Context context, boolean flag)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putBoolean("pw_forceregister", flag);
        context.commit();
    }

    public static void setLastRegistration(Context context, long l)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putLong("last_registration_change", l);
        context.commit();
    }

    public static void setLightScreenOnNotification(Context context, boolean flag)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putBoolean("dm_lightson", flag);
        context.commit();
    }

    public static void setMessageId(Context context, int i)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putInt("dm_messageid", i);
        context.commit();
    }

    public static void setMultiMode(Context context, boolean flag)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putBoolean("dm_multimode", flag);
        context.commit();
    }

    public static void setProjectId(Context context, String s)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putString("dm_sender_id", s);
        context.commit();
    }

    public static void setSoundType(Context context, SoundType soundtype)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putInt("dm_soundtype", soundtype.getValue());
        context.commit();
    }

    public static void setVibrateType(Context context, VibrateType vibratetype)
    {
        context = context.getSharedPreferences("com.pushwoosh.pushnotifications", 0).edit();
        context.putInt("dm_vibratetype", vibratetype.getValue());
        context.commit();
    }
}
