// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.DisplayMetrics;

public final class e
{

    private static int a(Context context, float f, int i)
    {
        int j = i;
        if ((context.getApplicationInfo().flags & 0x2000) != 0)
        {
            j = (int)((float)i / f);
        }
        return j;
    }

    public static int a(Context context, DisplayMetrics displaymetrics)
    {
        return a(context, displaymetrics.density, displaymetrics.heightPixels);
    }

    public static void a(Intent intent, String s)
    {
        intent.setPackage(s);
    }

    public static int b(Context context, DisplayMetrics displaymetrics)
    {
        return a(context, displaymetrics.density, displaymetrics.widthPixels);
    }
}
