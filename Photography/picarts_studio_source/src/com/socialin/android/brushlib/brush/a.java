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
import java.util.Random;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class a extends Brush
{

    private Paint c;
    private Brush.Params d;
    private int e;
    private int f;
    private int g;
    private h h;
    private h i;
    private g j;
    private float k[];

    a()
    {
        c = new Paint();
        d = (new Brush.Params()).setThickness(12F).setSpacing(1.0F);
        h = new h(0.5F, 5F);
        i = new h(0.1F, 1.0F);
        j = new g();
        k = new float[2];
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(12F);
        c.setAntiAlias(true);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        a(random.nextInt(), random.nextInt(), random.nextInt());
    }

    private void a(int l, int i1, int j1)
    {
        e = l;
        f = i1;
        g = j1;
        h.a(e);
        i.a(f);
        j.a(g);
        j.a(0.05F);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(12F).setSpacing(1.0F);
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        float f3 = d.getSpacing();
        f3 = a * f3;
        int j1 = (int)(f2 / f3);
        int i1 = (int)(f1 / f3);
        int l = i1;
        if ((float)i1 * f3 < f1)
        {
            l = i1;
            if (i1 < j1)
            {
                l = i1 + 1;
            }
        }
        stroke.getPosTan((float)l * f3, k, null);
        rectf.set(k[0], k[1], k[0], k[1]);
        do
        {
            f1 = (float)l * f3;
            if (f1 <= f2)
            {
                stroke.getPosTan(f1, k, null);
                rectf.union(k[0], k[1]);
                if (j.b(l))
                {
                    rectf.union(k[0], k[1] + h.b(l) * a * d.getThickness());
                }
                l++;
            } else
            {
                f1 = -d.getThickness() * a;
                rectf.inset(f1, f1);
                return;
            }
        } while (true);
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
        float f2 = stroke.getStrokeLength();
        c.setStrokeWidth(d.getThickness() * a);
        c.setColor(d.getColor());
        canvas.drawPath(stroke.getPath(), c);
        float f1 = d.getSpacing() * a;
        int j1 = (int)(f2 / f1);
        int i1 = (int)(0.0F / f1);
        int l = i1;
        if ((float)i1 * f1 < 0.0F)
        {
            l = i1;
            if (i1 < j1)
            {
                l = i1 + 1;
            }
        }
        stroke.getPosTan((float)l * f1, k, null);
        c.setAlpha(d.getAlpha() / 2);
        for (; l <= j1; l++)
        {
            stroke.getPosTan((float)l * f1, k, null);
            if (j.b(l))
            {
                c.setStrokeWidth(i.b(l) * a * d.getThickness());
                float f3 = k[0];
                float f4 = k[1];
                float f5 = k[0];
                float f6 = k[1];
                canvas.drawLine(f3, f4, f5, h.b(l) * a * d.getThickness() + f6, c);
            }
        }

        d.getThickness();
    }

    public final void b(Brush.Params params)
    {
        params.set(d);
    }

    public final int c()
    {
        return 4;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        a a1 = new a();
        a1.c.set(c);
        a1.a(e, f, g);
        a1.d.set(d);
        a1.a(b);
        return a1;
    }

    public final String toString()
    {
        return "Drip";
    }
}
