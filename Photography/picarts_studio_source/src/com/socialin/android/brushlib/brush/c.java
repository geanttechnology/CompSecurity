// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class c extends Brush
{

    private Paint c;
    private Brush.Params d;
    private MaskFilter e;

    c()
    {
        c = new Paint();
        d = f();
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(12F);
        c.setAntiAlias(true);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        Paint paint = c;
        BlurMaskFilter blurmaskfilter = new BlurMaskFilter(a(2.0F, 12F), android.graphics.BlurMaskFilter.Blur.NORMAL);
        e = blurmaskfilter;
        paint.setMaskFilter(blurmaskfilter);
    }

    private float a(float f1, float f2)
    {
        return (((2.0F - f1) + 0.01F) * f2 * a) / 4F;
    }

    public static Brush.Params f()
    {
        Brush.Params params = new Brush.Params();
        params.setThickness(12F);
        params.setHardness(2.0F);
        return params;
    }

    public static c g()
    {
        return new c();
    }

    private void h()
    {
        if (Math.abs(d.getHardness() - 2.0F) <= 0.1F)
        {
            Paint paint = c;
            e = null;
            paint.setMaskFilter(null);
            return;
        } else
        {
            float f1 = Math.max(1.0F, a(d.getHardness(), d.getThickness()));
            Paint paint1 = c;
            BlurMaskFilter blurmaskfilter = new BlurMaskFilter(f1, android.graphics.BlurMaskFilter.Blur.NORMAL);
            e = blurmaskfilter;
            paint1.setMaskFilter(blurmaskfilter);
            return;
        }
    }

    public final void a(float f1)
    {
        super.a(f1);
        h();
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        stroke.computeBounds(rectf, true);
        f1 = -Math.max(2.0F, d.getThickness()) / 2.0F - 1.0F;
        rectf.inset(f1, f1);
    }

    public final void a(Xfermode xfermode)
    {
        c.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        d.set(params);
        h();
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        float f1 = Math.max(1.0F, d.getThickness() * a);
        if ((double)f1 < 1.5D)
        {
            c.setMaskFilter(null);
        } else
        {
            c.setMaskFilter(e);
        }
        c.setColor(d.getColor());
        c.setStrokeWidth(f1);
        canvas.drawPath(stroke.getPath(), c);
    }

    public final void b(Brush.Params params)
    {
        params.set(d);
    }

    public final int c()
    {
        return 0;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        c c1 = new c();
        c1.c.set(c);
        c1.d.set(d);
        c1.e = c1.c.getMaskFilter();
        c1.a(b);
        return c1;
    }

    public final String toString()
    {
        return "Marker";
    }
}
