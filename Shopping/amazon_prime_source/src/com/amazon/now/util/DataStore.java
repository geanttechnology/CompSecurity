// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.now.platform.AndroidPlatform;

public class DataStore
{

    public DataStore()
    {
    }

    public static boolean getBoolean(String s)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        boolean flag = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).getBoolean(s, false);
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public static long getLong(String s)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        long l = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).getLong(s, 0L);
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public static String getString(String s)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        s = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).getString(s, null);
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public static boolean hasKey(String s)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        boolean flag = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).contains(s);
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public static void putBoolean(String s, boolean flag)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).edit();
        editor.putBoolean(s, flag);
        editor.commit();
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void putLong(String s, long l)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).edit();
        editor.putLong(s, l);
        editor.commit();
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void putString(String s, String s1)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).edit();
        editor.putString(s, s1);
        editor.commit();
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void removeKey(String s)
    {
        com/amazon/now/util/DataStore;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = AndroidPlatform.getInstance().getApplicationContext().getSharedPreferences("DataStore", 0).edit();
        editor.remove(s);
        editor.commit();
        com/amazon/now/util/DataStore;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
