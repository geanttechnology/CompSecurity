// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class bgs
{

    public SharedPreferences a;

    public bgs(SharedPreferences sharedpreferences)
    {
        a = (SharedPreferences)b.a(sharedpreferences);
    }

    public void a(String s, boolean flag)
    {
        a.edit().putBoolean(s, flag).commit();
    }

    public final boolean a()
    {
        return a.getBoolean("debugAdEnable", false);
    }

    public final boolean b()
    {
        return a.getBoolean("debugAdEnableFreqCap", true);
    }

    public final boolean c()
    {
        return a.getBoolean("forceWatchAdEnable", false);
    }

    public final String d()
    {
        return a.getString("forceWatchAdUrl", null);
    }

    public final String e()
    {
        return a.getString("forceBrowseAdUrl", null);
    }
}
