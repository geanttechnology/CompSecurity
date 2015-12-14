// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public abstract class r
{

    public static String a(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static void a(String s, Long long1, Context context)
    {
        if (s != null && context != null)
        {
            context = context.getSharedPreferences("U", 0);
            Log.d("PrefHelper", (new StringBuilder()).append("putLong(").append(s).append(",").append(long1).append(")").toString());
            context.edit().putLong(s, long1.longValue()).apply();
        }
    }

    public static void a(String s, String s1, Context context)
    {
        if (s != null && s1 != null && context != null)
        {
            context = context.getSharedPreferences("U", 0);
            Log.d("PrefHelper", (new StringBuilder()).append("putString(").append(s).append(",").append(s1).append(")").toString());
            context.edit().putString(s, s1).apply();
        }
    }

    public static Long b(String s, Long long1, Context context)
    {
        if (s == null || context == null)
        {
            throw new IllegalArgumentException("Parameter can not be null.");
        } else
        {
            context = context.getSharedPreferences("U", 0);
            Log.v("PrefHelper", (new StringBuilder()).append("getLong(").append(s).append(",").append(long1).append(")").toString());
            return Long.valueOf(context.getLong(s, long1.longValue()));
        }
    }

    public static String b(String s, String s1, Context context)
    {
        if (s != null && s1 != null && context != null)
        {
            context = context.getSharedPreferences("U", 0);
            Log.v("PrefHelper", (new StringBuilder()).append("getString(").append(s).append(",").append(s1).append(")").toString());
            return context.getString(s, s1);
        } else
        {
            throw new NullPointerException("Parameter can not be null.");
        }
    }
}
