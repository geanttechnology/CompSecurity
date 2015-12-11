// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.e;

import android.content.Context;
import android.content.SharedPreferences;

public final class e
{

    public SharedPreferences a;
    public android.content.SharedPreferences.Editor b;
    private SharedPreferences c;
    private android.content.SharedPreferences.Editor d;

    private e()
    {
    }

    e(byte byte0)
    {
        this();
    }

    private static Boolean a()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
        NoClassDefFoundError noclassdeffounderror;
        noclassdeffounderror;
        return Boolean.valueOf(false);
    }

    public static void a(android.content.SharedPreferences.Editor editor)
    {
        if (a().booleanValue())
        {
            editor.apply();
            return;
        } else
        {
            editor.commit();
            return;
        }
    }

    public final String a(Context context)
    {
        if (context != null)
        {
            c = context.getSharedPreferences("net.hockeyapp.android.prefs_feedback_token", 0);
            if (c != null)
            {
                return c.getString("net.hockeyapp.android.prefs_key_feedback_token", null);
            }
        }
        return null;
    }

    public final void a(Context context, String s)
    {
        if (context != null)
        {
            c = context.getSharedPreferences("net.hockeyapp.android.prefs_feedback_token", 0);
            if (c != null)
            {
                d = c.edit();
                d.putString("net.hockeyapp.android.prefs_key_feedback_token", s);
                a(d);
            }
        }
    }
}
