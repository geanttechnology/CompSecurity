// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil
{

    private Context a;
    private Configuration b;
    private DisplayMetrics c;

    public TapjoyDisplayMetricsUtil(Context context)
    {
        a = context;
        c = new DisplayMetrics();
        ((WindowManager)a.getSystemService("window")).getDefaultDisplay().getMetrics(c);
        b = a.getResources().getConfiguration();
    }

    public int getScreenDensityDPI()
    {
        return c.densityDpi;
    }

    public float getScreenDensityScale()
    {
        return c.density;
    }

    public int getScreenLayoutSize()
    {
        return b.screenLayout & 0xf;
    }
}
