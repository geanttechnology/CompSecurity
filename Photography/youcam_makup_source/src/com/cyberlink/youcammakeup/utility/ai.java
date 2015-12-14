// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.PointF;

public class ai
{

    public static final int a[] = {
        -100, 100
    };
    public static final int b[] = {
        2000, 50000
    };
    private static final int c[] = {
        2000, 2105, 2222, 2353, 2500, 2667, 2857, 3078, 3333, 3636, 
        4000, 4444, 5000, 5714, 6667, 8000, 10000, 11111, 12500, 14286, 
        16667, 20000, 25000, 33333, 50000
    };
    private static final int d[] = {
        2000, 2105, 2222, 2353, 2500, 2667, 2857, 3078, 3333, 3636, 
        4000, 4444, 5000, 5714, 6667, 8000, 10000, 11111, 12500, 14286, 
        16667, 20000, 25000, 33333, 50000
    };

    public static float a(float f, float f1, float f2, float f3)
    {
        if (f == 0.0F)
        {
            return f2;
        }
        if (f1 == 0.0F)
        {
            return f3;
        } else
        {
            return f2 + (f / (f + f1)) * (f3 - f2);
        }
    }

    public static float a(float f, float f1, float f2, float f3, float f4)
    {
        return a(f4 - f, f1 - f4, f2, f3);
    }

    public static void a(double d1, float f, float f1, PointF pointf)
    {
        double d2 = Math.toRadians(d1);
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        pointf.x = (float)((double)f * d2 - (double)f1 * d1);
        double d3 = f;
        pointf.y = (float)(d2 * (double)f1 + d1 * d3);
    }

}
