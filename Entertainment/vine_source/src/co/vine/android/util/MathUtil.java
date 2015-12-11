// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

public class MathUtil
{

    public MathUtil()
    {
    }

    public static int clamp(int i, int j, int k)
    {
        if (i > k)
        {
            return k;
        }
        if (i < j)
        {
            return j;
        } else
        {
            return i;
        }
    }

    public static void prepareMatrix(Matrix matrix, boolean flag, int i, int j, int k)
    {
        float f;
        if (flag)
        {
            f = -1F;
        } else
        {
            f = 1.0F;
        }
        matrix.setScale(f, 1.0F);
        matrix.postRotate(i);
        matrix.postScale((float)j / 2000F, (float)k / 2000F);
        matrix.postTranslate((float)j / 2.0F, (float)k / 2.0F);
    }

    public static void rectFToRect(RectF rectf, Rect rect)
    {
        rect.left = Math.round(rectf.left);
        rect.top = Math.round(rectf.top);
        rect.right = Math.round(rectf.right);
        rect.bottom = Math.round(rectf.bottom);
    }
}
