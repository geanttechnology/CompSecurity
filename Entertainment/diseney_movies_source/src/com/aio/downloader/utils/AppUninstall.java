// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppUninstall
{

    public AppUninstall()
    {
    }

    private static native void onUninstall(String s, String s1, String s2, String s3);

    public static void openUrlWhenUninstall(Context context, String s)
    {
        onUninstall(context.getApplicationInfo().dataDir, "com.android.browser/com.android.browser.BrowserActivity", "android.intent.action.VIEW", s);
    }

    public static void startActionWhenUninstall(Context context, String s, String s1)
    {
        onUninstall(context.getApplicationInfo().dataDir, null, s, s1);
    }

    public static void startActivityWhenUninstall(Context context, String s, String s1)
    {
        onUninstall(context.getApplicationInfo().dataDir, String.format("%s/%s", new Object[] {
            s, s1
        }), null, null);
    }

    static 
    {
        System.loadLibrary("feedback-uninstall");
    }
}
