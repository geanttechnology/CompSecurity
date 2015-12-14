// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.core.a.a;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.assist.c;

public class y extends a
{

    public y(boolean flag)
    {
        super(flag);
    }

    protected Bitmap a(Bitmap bitmap, e e1, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        c c1 = new c(bitmap.getWidth(), bitmap.getHeight(), i);
        float f = com.nostra13.universalimageloader.b.a.b(c1, e1.c(), e1.e(), false);
        if (Float.compare(f, 1.0F) != 0)
        {
            matrix.setScale(f, f);
            if (a)
            {
                d.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] {
                    c1, c1.a(f), Float.valueOf(f), e1.a()
                });
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (a)
            {
                d.a("Flip image horizontally [%s]", new Object[] {
                    e1.a()
                });
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (a)
            {
                d.a("Rotate image on %1$d\260 [%2$s]", new Object[] {
                    Integer.valueOf(i), e1.a()
                });
            }
        }
        e1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (e1 != bitmap)
        {
            bitmap.recycle();
        }
        return e1;
    }
}
