// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ac
{

    public static final float ASPECT_RATIO = 0.8F;
    public static final float FOOTER_HEIGHT_FRACTION = 0.2F;
    public static final int NUM_COLUMNS = 3;

    public static int a(Context context)
    {
        return Math.round((float)c(context) / 0.8F);
    }

    public static int a(Context context, int i)
        throws IllegalArgumentException
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("rows must be greater than 0");
        } else
        {
            return a(context) * i + (i - 1) * 2 * b(context);
        }
    }

    public static int b(Context context)
    {
        return context.getResources().getDimensionPixelSize(0x7f0a02b4);
    }

    public static int c(Context context)
    {
        int i = b(context);
        return Math.round((context.getResources().getDisplayMetrics().widthPixels - i * 2) / 3 - i * 2);
    }

    public static int d(Context context)
    {
        return Math.round(0.2F * (float)a(context));
    }
}
