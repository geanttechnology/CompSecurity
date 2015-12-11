// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.SharedPreferences;
import com.smule.android.f.p;

public class av
{

    public static int a(Context context)
    {
        return i(context).getInt("appVersion", 0);
    }

    public static void a(Context context, float f1)
    {
        p.a(i(context).edit().putFloat("SINGER_VOLUME_PREF", f1));
    }

    public static void a(Context context, int j)
    {
        p.a(i(context).edit().putInt("appVersion", j));
    }

    public static void a(Context context, Boolean boolean1)
    {
        p.a(i(context).edit().putBoolean("GameMode", boolean1.booleanValue()));
    }

    public static void a(Context context, boolean flag)
    {
        p.a(i(context).edit().putBoolean("SubscriptionExpired", flag));
    }

    public static Boolean b(Context context)
    {
        return Boolean.valueOf(i(context).getBoolean("GameMode", true));
    }

    public static void b(Context context, int j)
    {
        p.a(i(context).edit().putInt("SoundDelay", j));
    }

    public static void b(Context context, boolean flag)
    {
        p.a(i(context).edit().putBoolean("SoundDelayConfigured", flag));
    }

    public static void c(Context context, boolean flag)
    {
        p.a(i(context).edit().putBoolean("JamsDialogShown", flag));
    }

    public static boolean c(Context context)
    {
        return i(context).getBoolean("SubscriptionExpired", true);
    }

    public static int d(Context context)
    {
        return i(context).getInt("SoundDelay", 250);
    }

    public static void d(Context context, boolean flag)
    {
        p.a(i(context).edit().putBoolean("METRONOME_ENABLED_PREF", flag));
    }

    public static boolean e(Context context)
    {
        return i(context).getBoolean("SoundDelayConfigured", false);
    }

    public static boolean f(Context context)
    {
        return i(context).getBoolean("JamsDialogShown", false);
    }

    public static float g(Context context)
    {
        return i(context).getFloat("SINGER_VOLUME_PREF", 0.7F);
    }

    public static boolean h(Context context)
    {
        return i(context).getBoolean("METRONOME_ENABLED_PREF", false);
    }

    private static SharedPreferences i(Context context)
    {
        return context.getSharedPreferences("magic_piano_prefs", 0);
    }
}
