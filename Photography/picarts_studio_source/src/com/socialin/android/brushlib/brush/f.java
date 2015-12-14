// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.svg.d;
import com.socialin.android.brushlib.util.h;
import com.socialin.android.util.l;
import java.util.Random;
import junit.framework.Assert;
import myobfuscated.b.a;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush, c

public final class f extends Brush
{

    private static final c d = new c();
    public String c;
    private Brush.Params e;
    private h f;
    private h g;
    private h h;
    private h i;
    private h j;
    private Brush.Params k;
    private Matrix l;
    private float m[];
    private float n[];

    private f()
    {
        e = f();
        f = new h();
        g = new h();
        h = new h(0.0F, 360F);
        i = new h();
        j = new h();
        k = (new Brush.Params()).setHardness(2.0F);
        new Random();
        l = new Matrix();
        m = new float[2];
        n = new float[2];
    }

    private f(f f1)
    {
        e = f();
        f = new h();
        g = new h();
        h = new h(0.0F, 360F);
        i = new h();
        j = new h();
        k = (new Brush.Params()).setHardness(2.0F);
        new Random();
        l = new Matrix();
        m = new float[2];
        n = new float[2];
        c = f1.c;
        a(f1.e);
        b = f1.b;
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setColor(0xff000000).setHardness(2.0F).setTextureThickness(6F).setTextureStyle(android.graphics.Paint.Style.STROKE).setThickness(76F).setAngle(170F).setSquish(1.0F).setSpacing(0.71F).setHueJitter(0.0F).setSizeJitter(0.76F).setAngleJitter(97F).setScattering(0.0F);
    }

    public static f g()
    {
        return new f();
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
    }

    public final void a(Xfermode xfermode)
    {
    }

    public final void a(Brush.Params params)
    {
        e.set(params);
        f.a(-params.getHueJitter(), params.getHueJitter());
        g.a(1.0F - params.getSizeJitter(), 1.0F);
        i.a(0.0F, params.getScattering());
        j.a(-params.getAngleJitter(), params.getAngleJitter());
    }

    public final void a(Stroke stroke, float f1, float f2, Canvas canvas, RectF rectf)
    {
        Assert.assertNotNull(stroke);
        Assert.assertNotNull(canvas);
        if (c != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f4 = com.socialin.android.brushlib.svg.d.a(c);
        float f5 = com.socialin.android.brushlib.svg.d.b(c);
        float f6 = Math.max(a * e.getThickness() * e.getSpacing(), 0.5F);
        int j1 = (int)(f1 / f6);
        int i1 = j1;
        if ((float)j1 * f6 < f1)
        {
            i1 = j1 + 1;
        }
        if (rectf != null)
        {
            stroke.getPosTan(f1, m, null);
            rectf.set(m[0], m[1], m[0], m[1]);
        }
        do
        {
            float f7 = (float)i1 * f6;
            if (f7 >= f2)
            {
                continue;
            }
            stroke.getPosTan(f7, m, n);
            int k1 = com.socialin.android.util.l.a(e.getColor(), f.b(i1));
            f1 = (float)e.getAlpha() / 255F;
            float f3;
            float f8;
            float af[];
            if (e.isVaryOpacity())
            {
                f1 *= myobfuscated.b.a.generate(f7, stroke);
            } else
            {
                f1 *= 255F;
            }
            k1 = k1 & 0xffffff | (int)f1 << 24;
            l.setTranslate(-f4 / 2.0F, -f5 / 2.0F);
            l.postScale(e.getSquish(), 1.0F);
            f3 = e.getAngle() + j.b(i1);
            f1 = f3;
            if (e.isAutoOrient())
            {
                f1 = f3 + (float)Math.toDegrees(Math.atan2(n[1], n[0]));
            }
            l.postRotate(f1);
            f3 = (a * e.getThickness()) / f4;
            f1 = f3;
            if (e.isVaryThickness())
            {
                f1 = f3 * myobfuscated.b.a.generate(f7, stroke);
            }
            f1 *= g.b(i1);
            l.postScale(f1, f1);
            f8 = h.b(i1);
            f3 = i.b(i1);
            f7 = (float)Math.cos(f8);
            f8 = (float)Math.sin(f8);
            af = m;
            af[0] = f7 * f3 + af[0];
            af = m;
            af[1] = f8 * f3 + af[1];
            l.postTranslate(m[0], m[1]);
            if (e.getTextureStyle() == android.graphics.Paint.Style.FILL)
            {
                com.socialin.android.brushlib.svg.d.a(c, canvas, l, k1, b.xfermode);
            } else
            {
                k.setColor(k1);
                k.setThickness(e.getTextureThickness());
                d.a(k);
                d.a(b);
                com.socialin.android.brushlib.svg.d.a(c, canvas, l, d);
            }
            if (rectf != null)
            {
                rectf.union(m[0], m[1]);
                rectf.inset(-a * e.getThickness(), -f1 * f5 - e.getTextureThickness());
            }
            i1++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        a(stroke, 0.0F, stroke.getLength(), canvas, null);
    }

    public final void b(Brush.Params params)
    {
        params.set(e);
    }

    public final int c()
    {
        return 22;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        f f1 = new f(this);
        f1.a(b);
        return f1;
    }

    public final String e()
    {
        return c.substring(c.indexOf("/") + 1, c.indexOf("."));
    }

    public final String toString()
    {
        return "Shape brush";
    }

}
