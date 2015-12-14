// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush, h

public class g extends Brush
{

    protected h c[];
    protected Paint d;
    protected Brush.Params e;
    protected boolean f;
    private float g[];
    private float h[];
    private RectF i;

    protected g()
    {
        c = new h[50];
        d = new Paint(1);
        e = new Brush.Params();
        f = false;
        g = new float[2];
        h = new float[2];
        i = new RectF();
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(0.5F);
    }

    protected g(g g1)
    {
        c = new h[50];
        d = new Paint(1);
        e = new Brush.Params();
        f = false;
        g = new float[2];
        h = new float[2];
        i = new RectF();
        d.set(g1.d);
        e.set(g1.e);
    }

    protected static int b(float f1)
    {
        return (int)(5F + ((f1 - 1.0F) * 45F) / 127F);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(80F);
    }

    public static g g()
    {
        return new g();
    }

    public final void a(float f1, float f2, Stroke stroke, Canvas canvas, RectF rectf)
    {
        if (stroke.getLength() != 0.0F)
        {
            float f3 = 5F * a;
            int i1 = b(e.getThickness());
            int k = (int)(f1 / f3);
            int j = k;
            if ((float)k * f3 < f1)
            {
                j = k + 1;
            }
            stroke.getPosTan(f1, g, h);
            if (rectf != null)
            {
                rectf.set(g[0], g[1], g[0], g[1]);
            }
            if (f1 == 0.0F)
            {
                a(g, i1);
                if (rectf != null)
                {
                    rectf.union(g[0], g[1]);
                }
            }
            do
            {
                float f4 = (float)j * f3;
                if (f4 > f2)
                {
                    break;
                }
                stroke.getPosTan(f4, g, h);
                for (int l = 0; l < i1; l++)
                {
                    float f5 = stroke.getVelocity(f4);
                    if (Float.isNaN(f5))
                    {
                        continue;
                    }
                    f1 = 1.0F / f5;
                    if (f5 < 0.05F)
                    {
                        f1 = 20F;
                    }
                    f5 = c[l].c;
                    float f6 = g[0];
                    float f7 = c[l].d;
                    float f8 = g[1];
                    c[l].e = ((f5 - f6) * 0.1F * f1 + c[l].e) * c[l].g;
                    c[l].f = (f1 * ((f7 - f8) * 0.1F) + c[l].f) * c[l].g;
                    h h1 = c[l];
                    h1.c = h1.c - c[l].e;
                    h1 = c[l];
                    h1.d = h1.d - c[l].f;
                    c[l].a.quadTo(c[l].h, c[l].i, (c[l].c + c[l].h) / 2.0F, (c[l].d + c[l].i) / 2.0F);
                    c[l].b.quadTo(c[l].h, c[l].i, (c[l].c + c[l].h) / 2.0F, (c[l].d + c[l].i) / 2.0F);
                    c[l].b.computeBounds(i, true);
                    if (rectf != null)
                    {
                        rectf.union(i);
                    }
                    d.setColor(c[l].j);
                    d.setAlpha((int)((float)e.getAlpha() * 0.9F));
                    canvas.drawPath(c[l].b, d);
                    c[l].b.rewind();
                    c[l].b.moveTo((c[l].c + c[l].h) / 2.0F, (c[l].d + c[l].i) / 2.0F);
                    c[l].h = c[l].c;
                    c[l].i = c[l].d;
                }

                j++;
            } while (true);
            if (rectf != null)
            {
                rectf.inset(-0.5F, -0.5F);
                return;
            }
        }
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
    }

    public final void a(Xfermode xfermode)
    {
        d.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        e.set(params);
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        if (f)
        {
            int k = b(e.getThickness());
            for (int j = 0; j < k; j++)
            {
                d.setColor(c[j].j);
                d.setAlpha((int)((float)e.getAlpha() * 0.9F));
                canvas.drawPath(c[j].a, d);
            }

        } else
        {
            a(0.0F, stroke.getLength(), stroke, canvas, null);
        }
    }

    protected void a(float af[], int j)
    {
        int k = e.getColor();
        int l = Color.red(k) / 2;
        int i1 = Color.green(k) / 2;
        k = Color.blue(k) / 2;
        int j1 = 0;
        while (j1 < j) 
        {
            c[j1] = new h();
            if (j1 < j / 2)
            {
                l += l / j;
                i1 += i1 / j;
                k += k / j;
            } else
            {
                l -= l / j;
                i1 -= i1 / j;
                k -= k / j;
            }
            c[j1].a.moveTo(af[0], af[1]);
            c[j1].c = af[0];
            c[j1].d = af[1];
            c[j1].h = af[0];
            c[j1].i = af[1];
            c[j1].b.moveTo(af[0], af[1]);
            c[j1].g = (float)j1 * 0.006F + 0.5F;
            c[j1].j = Color.rgb(l, i1, k);
            j1++;
        }
    }

    public final void b(Brush.Params params)
    {
        params.set(e);
    }

    public int c()
    {
        return 5;
    }

    public Object clone()
    {
        return d();
    }

    public Brush d()
    {
        g g1 = new g(this);
        g1.a(b);
        return g1;
    }

    public final void h()
    {
        int j = 0;
        f = false;
        for (int k = b(e.getThickness()); j < k; j++)
        {
            if (c[j] != null)
            {
                c[j].a.rewind();
            }
        }

    }

    public g i()
    {
        g g1 = new g();
        g1.f = true;
        g1.d.set(d);
        g1.e.set(e);
        int k = b(e.getThickness());
        for (int j = 0; j < k; j++)
        {
            g1.c[j] = new h();
            g1.c[j].a.set(c[j].a);
            g1.c[j].j = c[j].j;
        }

        return g1;
    }

    public String toString()
    {
        return "Smoke";
    }
}
