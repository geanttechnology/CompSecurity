// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenSizeHelper
{

    public ScreenSizeHelper()
    {
    }

    public static boolean isTabletDevice(Context context)
    {
        DisplayMetrics displaymetrics;
        int i;
        if ((context.getResources().getConfiguration().screenLayout & 0xf) == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        displaymetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        if (displaymetrics.densityDpi == 160 || displaymetrics.densityDpi == 240 || displaymetrics.densityDpi == 160 || displaymetrics.densityDpi == 213)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        i = displaymetrics.densityDpi;
        if (i != 320)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        return true;
        context;
        context.printStackTrace();
        return false;
    }
}
