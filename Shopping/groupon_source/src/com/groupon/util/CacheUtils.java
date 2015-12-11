// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class CacheUtils
{

    public CacheUtils()
    {
    }

    public static void clearCacheDir(Context context)
    {
        context = context.getCacheDir().listFiles();
        int j = context.length;
        for (int i = 0; i < j; i++)
        {
            clearItem(context[i]);
        }

    }

    private static void clearItem(File file)
    {
        if (!file.isFile()) goto _L2; else goto _L1
_L1:
        file.delete();
_L4:
        return;
_L2:
        if (file.isDirectory())
        {
            file = file.listFiles();
            int j = file.length;
            int i = 0;
            while (i < j) 
            {
                clearItem(file[i]);
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static File getCacheDir(Context context)
    {
        return context.getCacheDir();
    }

    public static File getImageCacheDirWithNewFile(String s)
    {
        return new File(Environment.getExternalStorageDirectory(), s);
    }

    public static File getScreenshotCacheDir(Context context)
    {
        context = new File(context.getCacheDir(), "screenshot-cache");
        if (!context.exists())
        {
            context.mkdirs();
        }
        return context;
    }

    public static File getScreenshotCacheDirWithNewFile(String s, Context context)
    {
        return new File(getScreenshotCacheDir(context), s);
    }
}
