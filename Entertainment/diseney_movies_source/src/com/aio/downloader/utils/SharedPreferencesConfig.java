// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfig
{

    private static final String BATTERYLOW = "batterylow";
    private static final String CALLERIN = "callerin";
    private static final String CALLEROUT = "callerout";
    private static final String CHANGE = "change";
    private static final String CLEANER = "cleaner";
    private static final String CLEANERBOX = "cleanerbox";
    private static final String CLEANERRAM = "cleanerram";
    private static final String CLEANERUPDATE = "cleanerupdate";
    private static final String GALLARY_POP = "gallery_pop";
    private static final String GIFT = "gift_aio";
    private static final String NEITUI = "neitui_wyc";
    private static final String PIAD = "piad";
    private static final String PICK = "pick";
    private static final String PICK_BIG = "pick_bag";
    private static final String POWERAPP = "powerapp";
    private static final String POWERCHANGE = "powerchange";
    private static final String SIMULATECALL = "simulate_call";
    private static final String UPCLEANER = "upcleaner";
    private static final String UPDATE = "update";

    public SharedPreferencesConfig()
    {
    }

    public static long GetBatteryLowClickTime(Context context)
    {
        return context.getSharedPreferences("batterylow", 0).getLong("batterylow", 0L);
    }

    public static long GetCallerTime(Context context)
    {
        return context.getSharedPreferences("callerin", 0).getLong("caller", 0L);
    }

    public static long GetCalleroutTime(Context context)
    {
        return context.getSharedPreferences("callerout", 0).getLong("callerout", 0L);
    }

    public static long GetChangeTime(Context context)
    {
        return context.getSharedPreferences("change", 0).getLong("change", 0L);
    }

    public static long GetCleanerBoxTime(Context context)
    {
        return context.getSharedPreferences("cleanerbox", 0).getLong("cleanerbox", 0L);
    }

    public static long GetCleanerRamClickTime(Context context)
    {
        return context.getSharedPreferences("cleanerram", 0).getLong("cleanerram", 0L);
    }

    public static long GetCleanerTime(Context context)
    {
        return context.getSharedPreferences("cleaner", 0).getLong("cleaner", 0L);
    }

    public static long GetCleanerUpdateTime(Context context)
    {
        return context.getSharedPreferences("cleanerupdate", 0).getLong("cleanerupdate", 0L);
    }

    public static long GetClickTime(Context context)
    {
        return context.getSharedPreferences("gift_aio", 0).getLong("gift_aio", 0L);
    }

    public static long GetGalleryClickTime(Context context)
    {
        return context.getSharedPreferences("gallery_pop", 0).getLong("gallery_pop", 0L);
    }

    public static long GetPiadTime(Context context)
    {
        return context.getSharedPreferences("piad", 0).getLong("piad", 0L);
    }

    public static long GetPickClickTime(Context context)
    {
        return context.getSharedPreferences("pick", 0).getLong("pick", 0L);
    }

    public static long GetPick_bigTime(Context context)
    {
        return context.getSharedPreferences("pick_bag", 0).getLong("pick_big", 0L);
    }

    public static long GetPowerAPPClickTime(Context context)
    {
        return context.getSharedPreferences("powerapp", 0).getLong("powerapp", 0L);
    }

    public static long GetPowerChangeClickTime(Context context)
    {
        return context.getSharedPreferences("powerchange", 0).getLong("powerchange", 0L);
    }

    public static long GetUpcleanerTime(Context context)
    {
        return context.getSharedPreferences("upcleaner", 0).getLong("upcleaner", 0L);
    }

    public static long GetUpdateTime(Context context)
    {
        return context.getSharedPreferences("update", 0).getLong("update", 0L);
    }

    public static long Getneitui(Context context)
    {
        return context.getSharedPreferences("neitui_wyc", 0).getLong("neitui_wyc", 0L);
    }

    public static long Getsimulate_callTime(Context context)
    {
        return context.getSharedPreferences("simulate_call", 0).getLong("simulate_call", 0L);
    }

    public static void SetBatteryLowClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("batterylow", 0).edit();
        context.putLong("batterylow", l);
        context.commit();
    }

    public static void SetCallerTime(Context context, long l)
    {
        context = context.getSharedPreferences("callerin", 0).edit();
        context.putLong("caller", l);
        context.commit();
    }

    public static void SetCalleroutTime(Context context, long l)
    {
        context = context.getSharedPreferences("callerout", 0).edit();
        context.putLong("callerout", l);
        context.commit();
    }

    public static void SetChangeTime(Context context, long l)
    {
        context = context.getSharedPreferences("change", 0).edit();
        context.putLong("change", l);
        context.commit();
    }

    public static void SetCleanerBoxTime(Context context, long l)
    {
        context = context.getSharedPreferences("cleanerbox", 0).edit();
        context.putLong("cleanerbox", l);
        context.commit();
    }

    public static void SetCleanerRamClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("cleanerram", 0).edit();
        context.putLong("cleanerram", l);
        context.commit();
    }

    public static void SetCleanerTime(Context context, long l)
    {
        context = context.getSharedPreferences("cleaner", 0).edit();
        context.putLong("cleaner", l);
        context.commit();
    }

    public static void SetCleanerUpdateTime(Context context, long l)
    {
        context = context.getSharedPreferences("cleanerupdate", 0).edit();
        context.putLong("cleanerupdate", l);
        context.commit();
    }

    public static void SetClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("gift_aio", 0).edit();
        context.putLong("gift_aio", l);
        context.commit();
    }

    public static void SetGalleryClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("gallery_pop", 0).edit();
        context.putLong("gallery_pop", l);
        context.commit();
    }

    public static void SetPiadTime(Context context, long l)
    {
        context = context.getSharedPreferences("piad", 0).edit();
        context.putLong("piad", l);
        context.commit();
    }

    public static void SetPickClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("pick", 0).edit();
        context.putLong("pick", l);
        context.commit();
    }

    public static void SetPick_bigTime(Context context, long l)
    {
        context = context.getSharedPreferences("pick_bag", 0).edit();
        context.putLong("pick_big", l);
        context.commit();
    }

    public static void SetPowerAPPClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("powerapp", 0).edit();
        context.putLong("powerapp", l);
        context.commit();
    }

    public static void SetPowerChangeClickTime(Context context, long l)
    {
        context = context.getSharedPreferences("powerchange", 0).edit();
        context.putLong("powerchange", l);
        context.commit();
    }

    public static void SetUpcleanerTime(Context context, long l)
    {
        context = context.getSharedPreferences("upcleaner", 0).edit();
        context.putLong("upcleaner", l);
        context.commit();
    }

    public static void SetUpdateTime(Context context, long l)
    {
        context = context.getSharedPreferences("update", 0).edit();
        context.putLong("update", l);
        context.commit();
    }

    public static void Setneitui(Context context, long l)
    {
        context = context.getSharedPreferences("neitui_wyc", 0).edit();
        context.putLong("neitui_wyc", l);
        context.commit();
    }

    public static void Setsimulate_callTime(Context context, long l)
    {
        context = context.getSharedPreferences("simulate_call", 0).edit();
        context.putLong("simulate_call", l);
        context.commit();
    }
}
