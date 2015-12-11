// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedConfig
{

    private static SharedConfig instance;
    private static SharedPreferences shared;

    private SharedConfig(Context context)
    {
        shared = context.getSharedPreferences("config", 0);
    }

    public static void ClearConfig()
    {
        shared.edit().clear().commit();
    }

    public static SharedPreferences GetConfig()
    {
        return shared;
    }

    public static android.content.SharedPreferences.Editor GetEditor()
    {
        return shared.edit();
    }

    public static SharedConfig getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new SharedConfig(context);
        }
        return instance;
    }
}
