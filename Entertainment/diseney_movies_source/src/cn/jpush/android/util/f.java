// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class f
{

    private static SharedPreferences a = null;
    private static android.content.SharedPreferences.Editor b = null;

    public static void a(Context context)
    {
        if (a == null)
        {
            a = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    protected static void a(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = a.edit();
        b = editor;
        editor.putString(s, s1);
        b.commit();
    }

    protected static String b(String s, String s1)
    {
        return a.getString(s, s1);
    }

}
