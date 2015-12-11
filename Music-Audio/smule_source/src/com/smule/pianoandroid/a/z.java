// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.smule.android.network.core.b;

public class z
{

    private static z a;
    private SharedPreferences b;

    private z()
    {
        b = com.smule.android.network.core.b.d().e().getSharedPreferences("game_prefs", 0);
    }

    public static z a()
    {
        if (a == null)
        {
            a = new z();
        }
        return a;
    }

    public SharedPreferences b()
    {
        return b;
    }

    public android.content.SharedPreferences.Editor c()
    {
        return b.edit();
    }
}
