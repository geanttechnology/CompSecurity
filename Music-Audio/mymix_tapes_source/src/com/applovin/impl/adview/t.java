// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.res.Resources;
import android.util.DisplayMetrics;

class t
{

    public static float a(Resources resources, float f)
    {
        return resources.getDisplayMetrics().density * f + 0.5F;
    }

    public static float b(Resources resources, float f)
    {
        return resources.getDisplayMetrics().scaledDensity * f;
    }
}
