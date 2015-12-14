// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import android.graphics.Matrix;
import android.graphics.PointF;

class e
{

    private static float a[] = new float[8];
    private static Matrix b = new Matrix();

    public static void a(Matrix matrix, PointF pointf)
    {
        if (matrix.invert(b))
        {
            a[0] = pointf.x;
            a[1] = pointf.y;
            b.mapPoints(a, 0, a, 0, 1);
            pointf.x = a[0];
            pointf.y = a[1];
        }
    }

}
