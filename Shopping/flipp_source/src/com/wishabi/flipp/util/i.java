// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.wishabi.flipp.app.FlippApplication;

public final class i
{

    public static int a()
    {
        Object obj = FlippApplication.b();
        if (obj == null)
        {
            return -1;
        } else
        {
            obj = ((Context) (obj)).getResources().getDisplayMetrics();
            return (int)((float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).density);
        }
    }

    public static int a(int j)
    {
        Object obj = FlippApplication.b();
        if (obj == null)
        {
            return -1;
        } else
        {
            obj = ((Context) (obj)).getResources().getDisplayMetrics();
            return (int)TypedValue.applyDimension(1, j, ((DisplayMetrics) (obj)));
        }
    }
}
