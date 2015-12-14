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

public final class d extends Brush
{

    private Paint c;
    private Paint d;
    private Brush.Params e;
    private MaskFilter f;

    d()
    {
        c = new Paint();
        d = new Paint();
        e = (new Brush.Params()).setThickness(12F);
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(12F);
        c.setAntiAlias(true);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        Paint paint = c;
        BlurMaskFilter blurmaskfilter = new BlurMaskFilter(a(2.0F, 12F), android.graphics.BlurMaskFilter.Blur.NORMAL);
        f = blurmaskfilter;
        paint.setMaskFilter(blurmaskfilter);
        d.setColor(-1);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(3F);
        d.setAntiAlias(true);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setStrokeJoin(android.graphics.Paint.Join.ROUND);
    }

    private float a(float f1, float f2)
    {
        return (((2.0F - f1) + 0.01F) * f2 * a) / 4F;
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(12F);
    }

    public final void a(float f1)
    {
        super.a(f1);
        Paint paint = c;
        BlurMaskFilter blurmaskfilter = new BlurMaskFilter(a(e.getHardness(), e.getThickness()), android.graphics.BlurMaskFilter.Blur.NORMAL);
        f = blurmaskfilter;
        paint.setMaskFilter(blurmaskfilter);
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        stroke.computeBounds(rectf, true);
        f1 = -e.getThickness() / 2.0F - 1.0F;
        rectf.inset(f1, f1);
    }

    public final void a(Xfermode xfermode)
    {
        c.setXfermode(xfermode);
        d.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        e.set(params);
        Paint paint = c;
        params = new BlurMaskFilter(a(params.getHardness(), params.getThickness()), android.graphics.BlurMaskFilter.Blur.NORMAL);
        f = params;
        paint.setMaskFilter(params);
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        float f1 = e.getThickness() * a;
        if (f1 < 1.5F)
        {
            c.setMaskFilter(null);
        } else
        {
            c.setMaskFilter(f);
        }
        c.setStrokeWidth(f1);
        d.setStrokeWidth(f1 / 4F);
        c.setColor(e.getColor());
        c.setAlpha(e.getAlpha());
        canvas.drawPath(stroke.getPath(), c);
        canvas.drawPath(stroke.getPath(), d);
    }

    public final void b(Brush.Params params)
    {
        params.set(e);
    }

    public final int c()
    {
        return 7;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        d d1 = new d();
        d1.c.set(c);
        d1.d.set(d);
        d1.e.set(e);
        d1.f = d1.c.getMaskFilter();
        d1.a(b);
        return d1;
    }

    public final String toString()
    {
        return "Neon";
    }
}
