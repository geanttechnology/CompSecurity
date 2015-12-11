// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.File;

public class AndroidUtils
{

    public static final String PI_CACHE_ROOT_DIRECTORY = "PI";

    public AndroidUtils()
    {
    }

    public static void clearCacheDir(Context context)
    {
        context = context.getCacheDir();
        if (context == null || !context.isDirectory()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        context = context.listFiles();
        j = context.length;
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        File file = context[i];
        if (!"PI".equals(file.getName())) goto _L5; else goto _L4
_L4:
        removeDir(file);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static float getDisplayWidth(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
    }

    public static int getGLESVersion(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
    }

    public static boolean isEmulator()
    {
        return Build.HARDWARE.contains("goldfish");
    }

    public static boolean isIceCreamSandwich()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public static boolean isJellyBean()
    {
        return android.os.Build.VERSION.SDK_INT >= 16;
    }

    private static void removeDir(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                removeDir(afile[i]);
            }

        }
        file.delete();
    }
}
