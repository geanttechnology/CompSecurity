// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.math;

import android.graphics.RectF;

public class MathUtils
{

    private static final String TAG = com/amazon/gallery/foundation/utils/math/MathUtils.getName();

    public MathUtils()
    {
    }

    public static int roundPower2(int i)
    {
        i--;
        i |= i >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        return (i | i >> 16) + 1;
    }

    public static RectF scaleToFill(float f, float f1, RectF rectf)
    {
        float f2;
        float f3;
label0:
        {
            if (rectf.isEmpty())
            {
                return rectf;
            }
            f2 = f / rectf.width();
            float f5 = f1 / rectf.height();
            f3 = f2 * rectf.width();
            float f4 = f2 * rectf.height();
            if (f3 >= f)
            {
                f2 = f4;
                if (f4 >= f1)
                {
                    break label0;
                }
            }
            f3 = f5 * rectf.width();
            f2 = f5 * rectf.height();
        }
        rectf = new RectF();
        rectf.left = (f - f3) / 2.0F;
        rectf.top = (f1 - f2) / 2.0F;
        rectf.right = rectf.left + f3;
        rectf.bottom = rectf.top + f2;
        return rectf;
    }

    public static RectF scaleToFit(float f, float f1, RectF rectf, boolean flag)
    {
        if (rectf.isEmpty())
        {
            return rectf;
        }
        float f2 = rectf.width() / f;
        float f3 = rectf.height() / f1;
        int i = (int)(f2 * f);
        int j = (int)(f2 * f1);
        if ((float)i > rectf.width() || (float)j > rectf.height())
        {
            f2 = f3;
        }
        f3 = f2;
        if (flag)
        {
            f3 = Math.min(f2, 1.0F);
        }
        i = Math.max((int)(f3 * f), 1);
        j = Math.max((int)(f3 * f1), 1);
        RectF rectf1 = new RectF();
        rectf1.left = rectf.left + (rectf.width() - (float)i) / 2.0F;
        rectf1.top = rectf.top + (rectf.height() - (float)j) / 2.0F;
        rectf1.right = rectf1.left + (float)i;
        rectf1.bottom = rectf1.top + (float)j;
        return rectf1;
    }

}
