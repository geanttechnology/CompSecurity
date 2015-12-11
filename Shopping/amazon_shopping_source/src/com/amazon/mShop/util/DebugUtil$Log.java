// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;

// Referenced classes of package com.amazon.mShop.util:
//            DebugUtil

public static class 
{

    public static void d(String s, String s1, Throwable throwable)
    {
        if (DebugSettings.isDebugEnabled())
        {
            android.util.Log.d(s, s1, throwable);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (DebugSettings.isDebugEnabled())
        {
            android.util.Log.e(s, s1, throwable);
        }
    }

    public static void i(String s, String s1)
    {
        i(s, s1, null);
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        if (DebugSettings.isDebugEnabled())
        {
            android.util.Log.i(s, s1, throwable);
        }
    }

    public ()
    {
    }
}
