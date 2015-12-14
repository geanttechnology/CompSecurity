// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import android.os.StrictMode;

public class DebugAssert
{

    public static boolean isDebugBuild;
    private static boolean isRobolectric;
    public static boolean isUserBuild;

    public static void assertFalse(boolean flag, String s)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        assertTrue(flag, s);
    }

    public static void assertMsg(String s)
    {
        if (isDebugBuild)
        {
            throw new AssertionError(s);
        } else
        {
            return;
        }
    }

    public static void assertTrue(boolean flag)
    {
        assertTrue(flag, null);
    }

    public static void assertTrue(boolean flag, String s)
    {
        if (isDebugBuild && !flag)
        {
            if (s == null)
            {
                s = Boolean.valueOf(flag);
            }
            throw new AssertionError(s);
        } else
        {
            return;
        }
    }

    public static void enableStrictMode()
    {
        if (isDebugBuild && !isRobolectric)
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().penaltyFlashScreen().penaltyLog().build());
            StrictMode.setVmPolicy((new android.os.StrictMode.VmPolicy.Builder()).detectAll().penaltyLog().build());
            return;
        } else
        {
            StrictMode.setThreadPolicy(android.os.StrictMode.ThreadPolicy.LAX);
            StrictMode.setVmPolicy(android.os.StrictMode.VmPolicy.LAX);
            return;
        }
    }

    public static void verifyOnTheMainThread()
    {
        if (isDebugBuild && !Thread.currentThread().getName().equals("main"))
        {
            throw new AssertionError("You MUST execute this request on the main thread");
        } else
        {
            return;
        }
    }

    static 
    {
        boolean flag;
        boolean flag1 = true;
        if (android.os.Build.VERSION.INCREMENTAL == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isRobolectric = flag;
        if (android.os.Build.VERSION.INCREMENTAL == null || android.os.Build.VERSION.INCREMENTAL.contains("_eng_") || android.os.Build.VERSION.INCREMENTAL.endsWith("-eng"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isDebugBuild = flag;
        if (android.os.Build.VERSION.INCREMENTAL == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (android.os.Build.VERSION.INCREMENTAL.contains("_user_")) goto _L4; else goto _L3
_L3:
        if (!android.os.Build.VERSION.INCREMENTAL.endsWith("-user")) goto _L2; else goto _L5
_L5:
        flag = flag1;
_L4:
        isUserBuild = flag;
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L6
_L6:
    }
}
