// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;

// Referenced classes of package com.socialin.android.photo.freecrop:
//            b

public final class c
{

    public Path a;
    public float b;
    public boolean c;
    public int d;
    public float e;
    public float f;
    private b g;

    public c(b b1)
    {
        g = b1;
        super();
        d = 0;
    }

    public final void a(Canvas canvas, Paint paint, Paint paint1)
    {
        a(canvas, paint, paint1, 1.0F);
    }

    public final void a(Canvas canvas, Paint paint, Paint paint1, float f1)
    {
        Path path = a;
        if (f1 != 1.0F)
        {
            path = new Path();
            Matrix matrix = new Matrix();
            matrix.postScale(f1, f1);
            a.transform(matrix, path);
        }
        if (d == 0)
        {
            f1 = b * f1;
            if (c)
            {
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
                paint.setColor(Color.argb(255, 255, 255, 255));
                paint.setStrokeWidth(f1);
                canvas.drawPath(path, paint);
                return;
            } else
            {
                paint.setColor(0xff000000);
                paint.setAlpha(255);
                paint.setXfermode(null);
                paint.setStrokeWidth(f1);
                canvas.drawPath(path, paint);
                return;
            }
        }
        if (c)
        {
            paint1.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            paint1.setColor(Color.argb(255, 255, 255, 255));
            paint1.setAlpha(255);
            canvas.drawPath(path, paint1);
            return;
        } else
        {
            paint1.setXfermode(null);
            paint1.setColor(0xff000000);
            paint1.setAlpha(255);
            canvas.drawPath(path, paint1);
            return;
        }
    }

    public final Object clone()
    {
        c c1 = new c(g);
        c1.a = new Path(a);
        c1.b = b;
        c1.d = d;
        c1.e = e;
        c1.f = f;
        return c1;
    }
}
