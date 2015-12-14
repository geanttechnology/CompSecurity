// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;
import junit.framework.Assert;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class l extends Brush
{

    private Path c;
    private Paint d;
    private Brush.Params e;
    private float f[];
    private float g[];

    l()
    {
        c = new Path();
        d = new Paint();
        e = (new Brush.Params()).setSpacing(1.5F).setThickness(3F);
        f = new float[2];
        g = new float[2];
        d.setColor(0xff00ff00);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setStrokeWidth(3F);
        d.setAntiAlias(true);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setSpacing(1.5F).setThickness(3F);
    }

    private float g()
    {
        return 10F + ((e.getSpacing() - 0.02F) * 40F) / 1.98F;
    }

    public final void a(float f1, float f2, Stroke stroke, Canvas canvas, RectF rectf)
    {
        float f3;
        int i;
        int j;
        int i1;
        boolean flag;
        if (f2 >= f1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        if (f1 >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        f3 = a * g();
        d.setColor(e.getColor());
        d.setStrokeWidth((a * e.getThickness()) / 25F);
        i1 = (int)(f2 / f3);
        j = (int)(f1 / f3);
        i = j;
        if ((float)j * f3 < f1)
        {
            i = j;
            if (j < i1)
            {
                i = j + 1;
            }
        }
        stroke.getPosTan((float)i * f3, f, null);
        rectf.set(f[0], f[1], f[0], f[1]);
        int k;
        for (; i <= i1; i++)
        {
            stroke.getPosTan((float)i * f3, f, null);
            rectf.union(f[0], f[1]);
            if (i < 6)
            {
                k = i;
            } else
            {
                k = 6;
            }
            for (k = i - k; k < i; k++)
            {
                stroke.getPosTan((float)k * f3, g, null);
                canvas.drawLine(f[0], f[1], g[0], g[1], d);
                rectf.union(g[0], g[1]);
            }

        }

    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        stroke.computeBounds(rectf, true);
    }

    public final void a(Xfermode xfermode)
    {
        d.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        e.set(params);
        d.setStrokeWidth(params.getThickness());
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        c.rewind();
        float f1 = stroke.getLength();
        float f2 = a * g();
        int i = 0;
        do
        {
            float f3 = (float)i * f2;
            if (f3 < f1)
            {
                stroke.getPosTan(f3, f, null);
                int j;
                if (i < 6)
                {
                    j = i;
                } else
                {
                    j = 6;
                }
                for (j = i - j; j <= i; j++)
                {
                    stroke.getPosTan((float)j * f2, g, null);
                    c.moveTo(g[0], g[1]);
                    c.lineTo(f[0], f[1]);
                }

                i++;
            } else
            {
                d.setColor(e.getColor());
                d.setStrokeWidth((a * e.getThickness()) / 25F);
                canvas.drawPath(c, d);
                return;
            }
        } while (true);
    }

    public final void b(Brush.Params params)
    {
        params.set(e);
    }

    public final int c()
    {
        return 1;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        l l1 = new l();
        l1.d.set(d);
        l1.e.set(e);
        l1.a(b);
        l1.a(a);
        return l1;
    }

    public final String toString()
    {
        return "Webink";
    }
}
