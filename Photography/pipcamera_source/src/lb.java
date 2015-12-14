// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.pipcamera.application.PIPCameraApplication;

public class lb
{

    public static int a(String s, int i)
    {
        return a().getInt(s, i);
    }

    public static SharedPreferences a()
    {
        return PIPCameraApplication.a.getSharedPreferences("sysconfig", 0);
    }

    public static String a(String s, String s1)
    {
        return a().getString(s, s1);
    }

    public static boolean a(String s, boolean flag)
    {
        return a().getBoolean(s, flag);
    }

    public static void b(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = a().edit();
        editor.putInt(s, i);
        editor.apply();
    }

    public static void b(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = a().edit();
        editor.putString(s, s1);
        editor.apply();
    }

    public static void b(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = a().edit();
        editor.putBoolean(s, flag);
        editor.apply();
    }
}
