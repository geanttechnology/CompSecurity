// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.util.g;
import com.socialin.android.brushlib.util.h;
import com.socialin.android.util.l;
import java.util.Random;
import junit.framework.Assert;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class e extends Brush
{

    private Paint c;
    private Brush.Params d;
    private float e[];
    private float f[];
    private int g;
    private int h;
    private int i;
    private g j;
    private h k;
    private h l;

    e()
    {
        c = new Paint();
        d = (new Brush.Params()).setThickness(1.0F).setSpacing(0.02F);
        e = new float[2];
        f = new float[2];
        j = new g(0.8F);
        k = new h(25F, 50F);
        l = new h(0.2F, 1.0F);
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(1.0F);
        c.setAntiAlias(true);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        Random random = new Random();
        g = random.nextInt();
        h = random.nextInt();
        i = random.nextInt();
        k.a(g);
        j.a(h);
        l.a(i);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(1.0F).setSpacing(0.02F);
    }

    private float g()
    {
        return 10F + ((d.getSpacing() - 0.02F) * 40F) / 1.98F;
    }

    public final void a(float f1, float f2, Stroke stroke, Canvas canvas, RectF rectf)
    {
        c.setColor(d.getColor());
        c.setStrokeWidth((a * d.getThickness()) / 25F);
        float f3 = a * g();
        int i2 = (int)(f2 / f3);
        int k1 = (int)(f1 / f3);
        int i1 = k1;
        if ((float)k1 * f3 < f1)
        {
            i1 = k1;
            if (k1 < i2)
            {
                i1 = k1 + 1;
            }
        }
        stroke.getPosTan((float)i1 * f3, e, null);
        if (rectf != null)
        {
            rectf.set(e[0], e[1], e[0], e[1]);
        }
        for (int l1 = i1; l1 <= i2; l1++)
        {
            if (l1 == 0)
            {
                continue;
            }
            stroke.getPosTan((float)l1 * f3, f, null);
            int j1 = l1 - 25;
            if (j1 < 0)
            {
                j1 = 0;
            }
            for (; j1 < l1; j1++)
            {
                if (!j.b(j1))
                {
                    continue;
                }
                stroke.getPosTan((float)j1 * f3, e, null);
                f1 = 2.0F + (a * k.b(j1)) / com.socialin.android.util.l.a(e[0], e[1], f[0], f[1]);
                f2 = (f[0] - e[0]) * l.b(j1);
                float f4 = (f[1] - e[1]) * l.b(j1);
                if (rectf != null)
                {
                    rectf.union(f1 * f2 + f[0], f1 * f4 + f[1]);
                    rectf.union(e[0] - f1 * f2, e[1] - f1 * f4);
                    rectf.union(e[0], e[1]);
                    rectf.union(f[0], f[1]);
                }
                canvas.drawLine(f1 * f2 + f[0], f1 * f4 + f[1], e[0] - f2 * f1, e[1] - f1 * f4, c);
            }

        }

        f1 = -d.getThickness();
        if (rectf != null)
        {
            rectf.inset(f1, f1);
        }
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        Assert.assertNotNull(rectf);
        float f3 = a * g();
        int j2 = (int)(f2 / f3);
        int k1 = (int)(f1 / f3);
        int i1 = k1;
        if ((float)k1 * f3 < f1)
        {
            i1 = k1;
            if (k1 < j2)
            {
                i1 = k1 + 1;
            }
        }
        stroke.getPosTan((float)i1 * f3, e, null);
        rectf.set(e[0], e[1], e[0], e[1]);
        for (int l1 = i1 + 1; l1 <= j2; l1++)
        {
            if (l1 == 0)
            {
                continue;
            }
            stroke.getPosTan((float)l1 * f3, f, null);
            int i2 = l1 - 25;
            int j1 = i2;
            if (i2 < 0)
            {
                j1 = 0;
            }
            for (; j1 < l1; j1++)
            {
                if (j.b(j1))
                {
                    stroke.getPosTan((float)j1 * f3, e, null);
                    f1 = (f[0] - e[0]) * l.b(j1);
                    f2 = (f[1] - e[1]) * l.b(j1);
                    float f4 = 2.0F + (a * k.b(j1)) / com.socialin.android.util.l.a(e[0], e[1], f[0], f[1]);
                    rectf.union(f4 * f1 + f[0], f4 * f2 + f[1]);
                    rectf.union(e[0] - f1 * f4, e[1] - f2 * f4);
                    rectf.union(e[0], e[1]);
                    rectf.union(f[0], f[1]);
                }
            }

        }

        f1 = -a * d.getThickness();
        rectf.inset(f1, f1);
    }

    public final void a(Xfermode xfermode)
    {
        c.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        d.set(params);
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        a(0.0F, stroke.getLength(), stroke, canvas, null);
    }

    public final void b(Brush.Params params)
    {
        params.set(d);
    }

    public final int c()
    {
        return 8;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        e e1 = new e();
        e1.c.set(c);
        e1.d.set(d);
        e1.g = g;
        e1.h = h;
        e1.i = i;
        e1.a(b);
        return e1;
    }

    public final String toString()
    {
        return "Nightmare";
    }
}
