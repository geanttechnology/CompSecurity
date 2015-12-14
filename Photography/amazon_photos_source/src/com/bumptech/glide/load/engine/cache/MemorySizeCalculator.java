// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class MemorySizeCalculator
{
    private static class DisplayMetricsScreenDimensions
        implements ScreenDimensions
    {

        private final DisplayMetrics displayMetrics;

        public int getHeightPixels()
        {
            return displayMetrics.heightPixels;
        }

        public int getWidthPixels()
        {
            return displayMetrics.widthPixels;
        }

        public DisplayMetricsScreenDimensions(DisplayMetrics displaymetrics)
        {
            displayMetrics = displaymetrics;
        }
    }

    static interface ScreenDimensions
    {

        public abstract int getHeightPixels();

        public abstract int getWidthPixels();
    }


    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public MemorySizeCalculator(Context context1)
    {
        this(context1, (ActivityManager)context1.getSystemService("activity"), ((ScreenDimensions) (new DisplayMetricsScreenDimensions(context1.getResources().getDisplayMetrics()))));
    }

    MemorySizeCalculator(Context context1, ActivityManager activitymanager, ScreenDimensions screendimensions)
    {
        context = context1;
        int i = getMaxSize(activitymanager);
        int k = screendimensions.getWidthPixels() * screendimensions.getHeightPixels() * 4;
        int j = k * 4;
        k *= 2;
        if (k + j <= i)
        {
            memoryCacheSize = k;
            bitmapPoolSize = j;
        } else
        {
            int l = Math.round((float)i / 6F);
            memoryCacheSize = l * 2;
            bitmapPoolSize = l * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3))
        {
            context1 = (new StringBuilder()).append("Calculated memory cache size: ").append(toMb(memoryCacheSize)).append(" pool size: ").append(toMb(bitmapPoolSize)).append(" memory class limited? ");
            boolean flag;
            if (k + j > i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Log.d("MemorySizeCalculator", context1.append(flag).append(" max size: ").append(toMb(i)).append(" memoryClass: ").append(activitymanager.getMemoryClass()).append(" isLowMemoryDevice: ").append(isLowMemoryDevice(activitymanager)).toString());
        }
    }

    private static int getMaxSize(ActivityManager activitymanager)
    {
        int i = activitymanager.getMemoryClass();
        boolean flag = isLowMemoryDevice(activitymanager);
        float f1 = i * 1024 * 1024;
        float f;
        if (flag)
        {
            f = 0.33F;
        } else
        {
            f = 0.4F;
        }
        return Math.round(f * f1);
    }

    private static boolean isLowMemoryDevice(ActivityManager activitymanager)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        return i < 11 || i >= 19 && activitymanager.isLowRamDevice();
    }

    private String toMb(int i)
    {
        return Formatter.formatFileSize(context, i);
    }

    public int getBitmapPoolSize()
    {
        return bitmapPoolSize;
    }

    public int getMemoryCacheSize()
    {
        return memoryCacheSize;
    }
}
