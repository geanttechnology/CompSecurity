// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support;

import java.lang.reflect.Field;

public class IgnitedDiagnostics
{

    public static final int ANDROID_API_LEVEL;
    public static final boolean SUPPORTS_CUPCAKE;
    public static final boolean SUPPORTS_DONUT;
    public static final boolean SUPPORTS_ECLAIR;
    public static final boolean SUPPORTS_FROYO;
    public static final boolean SUPPORTS_GINGERBREAD;
    public static final boolean SUPPORTS_HONEYCOMB;
    public static final boolean SUPPORTS_ICS;
    private static boolean test = false;

    static 
    {
        boolean flag1 = true;
        int i;
        boolean flag;
        try
        {
            i = android/os/Build$VERSION.getField("SDK_INT").getInt(null);
        }
        catch (Exception exception)
        {
            i = Integer.parseInt(android.os.Build.VERSION.SDK);
        }
        ANDROID_API_LEVEL = i;
        if (ANDROID_API_LEVEL >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_ICS = flag;
        if (ANDROID_API_LEVEL >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_HONEYCOMB = flag;
        if (ANDROID_API_LEVEL >= 9)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_GINGERBREAD = flag;
        if (ANDROID_API_LEVEL >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_FROYO = flag;
        if (ANDROID_API_LEVEL >= 7)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_ECLAIR = flag;
        if (ANDROID_API_LEVEL >= 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_DONUT = flag;
        if (ANDROID_API_LEVEL >= 3)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        SUPPORTS_CUPCAKE = flag;
    }
}
