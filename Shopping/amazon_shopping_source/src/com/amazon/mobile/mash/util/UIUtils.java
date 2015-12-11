// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class UIUtils
{

    private UIUtils()
    {
    }

    public static DisplayMetrics getDeviceDisplayMetrics(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static int getPortraitHeight(Context context)
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (isPortrait(context))
        {
            return display.getHeight();
        } else
        {
            return display.getWidth();
        }
    }

    public static int getPortraitWidth(Context context)
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (isPortrait(context))
        {
            return display.getWidth();
        } else
        {
            return display.getHeight();
        }
    }

    public static boolean isPortrait(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        return context.getHeight() > context.getWidth();
    }
}
