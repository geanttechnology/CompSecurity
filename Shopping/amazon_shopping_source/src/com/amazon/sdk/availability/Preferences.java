// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.amazon.sdk.availability:
//            StringUtil

public class Preferences
{

    private final Context context;

    public Preferences(Context context1)
    {
        context = context1;
    }

    public boolean contains(String s)
    {
        return context.getSharedPreferences("measurement-preferences", 0).contains(s);
    }

    public String get(String s)
    {
        if (StringUtil.isEmpty(s))
        {
            return null;
        } else
        {
            return context.getSharedPreferences("measurement-preferences", 0).getString(s, null);
        }
    }

    public String get(String s, String s1)
    {
        if (StringUtil.isEmpty(s))
        {
            return null;
        } else
        {
            return context.getSharedPreferences("measurement-preferences", 0).getString(s, s1);
        }
    }

    public void put(String s, String s1)
    {
        if (StringUtil.isEmpty(s) || StringUtil.isEmpty(s1))
        {
            return;
        }
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("measurement-preferences", 0).edit();
        editor.putString(s, s1);
        if (android.os.Build.VERSION.SDK_INT <= 8)
        {
            editor.commit();
            return;
        } else
        {
            editor.apply();
            return;
        }
    }

    public void remove(String s)
    {
        if (StringUtil.isEmpty(s))
        {
            return;
        }
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("measurement-preferences", 0).edit();
        editor.remove(s);
        if (android.os.Build.VERSION.SDK_INT <= 8)
        {
            editor.commit();
            return;
        } else
        {
            editor.apply();
            return;
        }
    }
}
