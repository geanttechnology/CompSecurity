// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class WindowManagerWrapper
{

    private WindowManager mInner;

    public WindowManagerWrapper(Context context)
    {
        mInner = (WindowManager)context.getSystemService("window");
    }

    public DisplayMetrics getWindowMetric()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Display display = mInner.getDefaultDisplay();
        if (display != null)
        {
            display.getMetrics(displaymetrics);
        }
        return displaymetrics;
    }
}
