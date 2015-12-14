// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

public final class ScreenUtils
{

    public static final double INCHES_TABLET = 6.5D;
    private static final String LOG_TAG = "screen-utils";

    private ScreenUtils()
    {
    }

    public static double getScreenInches(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        double d = (double)((DisplayMetrics) (context)).widthPixels / (double)((DisplayMetrics) (context)).densityDpi;
        double d1 = (double)((DisplayMetrics) (context)).heightPixels / (double)((DisplayMetrics) (context)).densityDpi;
        return Math.sqrt(Math.pow(d, 2D) + Math.pow(d1, 2D));
    }

    public static double[] getScreenSize(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (new double[] {
            (double)((DisplayMetrics) (context)).widthPixels / (double)((DisplayMetrics) (context)).densityDpi, (double)((DisplayMetrics) (context)).heightPixels / (double)((DisplayMetrics) (context)).densityDpi
        });
    }

    public static boolean isTablet(Context context)
    {
        double d = getScreenInches(context);
        Log.d("screen-utils", (new StringBuilder()).append("screen size: ").append(d).toString());
        return d >= 6.5D;
    }
}
