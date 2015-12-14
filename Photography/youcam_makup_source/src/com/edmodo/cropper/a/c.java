// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

public class c
{

    public static Rect a(int i, int j, int k, int l)
    {
        return b(i, j, k, l);
    }

    public static Rect a(Bitmap bitmap, View view)
    {
        return b(bitmap.getWidth(), bitmap.getHeight(), view.getWidth(), view.getHeight());
    }

    private static Rect b(int i, int j, int k, int l)
    {
        boolean flag = false;
        if (i == 0 || j == 0 || k == 0 || l == 0)
        {
            return new Rect(0, 0, 0, 0);
        }
        float f = (float)k / (float)i;
        float f1 = (float)l / (float)j;
        double d;
        double d1;
        if (k < l)
        {
            if (f <= f1)
            {
                d1 = k;
                d = (float)j * ((float)k / (float)i);
                i = (int)Math.round(((double)l - d) / 2D);
                j = ((flag) ? 1 : 0);
            } else
            {
                d = l;
                d1 = (float)i * ((float)l / (float)j);
                j = (int)Math.round(((double)k - d1) / 2D);
                i = 0;
            }
        } else
        if (f1 <= f)
        {
            d = l;
            d1 = (float)i * ((float)l / (float)j);
            j = (int)Math.round(((double)k - d1) / 2D);
            i = 0;
        } else
        {
            d1 = k;
            d = (float)j * ((float)k / (float)i);
            i = (int)Math.round(((double)l - d) / 2D);
            j = ((flag) ? 1 : 0);
        }
        return new Rect(j, i, (int)Math.ceil(d1) + j, (int)Math.ceil(d) + i);
    }
}
