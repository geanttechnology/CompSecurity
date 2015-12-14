// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Point;
import android.graphics.RectF;

public class g
{

    public static Point a(int i, int j, int k, int l)
    {
        float f1 = 1.0F;
        float f = (float)i / (float)k;
        float f2 = (float)j / (float)l;
        if (f < f2)
        {
            f /= f2;
        } else
        if (f > f2)
        {
            f1 = f2 / f;
            f = 1.0F;
        } else
        {
            f = 1.0F;
        }
        return new Point(Math.round(f1 * (float)i), Math.round(f * (float)j));
    }

    public static RectF b(int i, int j, int k, int l)
    {
        Point point = a(i, j, k, l);
        float f = Math.round((float)(i - point.x) / 2.0F);
        float f1 = Math.round((float)(j - point.y) / 2.0F);
        return new RectF(f, f1, (float)point.x + f, (float)point.y + f1);
    }
}
