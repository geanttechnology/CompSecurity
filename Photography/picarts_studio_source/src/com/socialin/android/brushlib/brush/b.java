// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush

public final class b extends Brush
{

    private Paint c;
    private Brush.Params d;
    private final MaskFilter e;
    private boolean f;

    b()
    {
        d = (new Brush.Params()).setThickness(12F);
        e = new EmbossMaskFilter(new float[] {
            1.0F, 1.0F, 1.0F
        }, 0.4F, 12F, 3F);
        c = new Paint();
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeWidth(12F);
        c.setAntiAlias(true);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        c.setMaskFilter(e);
    }

    private b(b b1)
    {
        d = (new Brush.Params()).setThickness(12F);
        e = new EmbossMaskFilter(new float[] {
            1.0F, 1.0F, 1.0F
        }, 0.4F, 12F, 3F);
        c = new Paint(b1.c);
        d.set(b1.d);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(12F);
    }

    private void g()
    {
        float f1 = d.getThickness();
        float f2 = a;
        if (f)
        {
            c.setMaskFilter(null);
            return;
        }
        if ((double)(f1 * f2) < 1.5D)
        {
            c.setMaskFilter(null);
            return;
        } else
        {
            c.setMaskFilter(e);
            return;
        }
    }

    public final void a(float f1)
    {
        super.a(f1);
        g();
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        stroke.computeBounds(rectf, true);
        f1 = -d.getThickness() / 2.0F - 1.0F;
        rectf.inset(f1, f1);
    }

    public final void a(Xfermode xfermode)
    {
        c.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        d.set(params);
        g();
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        float f1 = d.getThickness();
        float f2 = a;
        c.setColor(d.getColor());
        c.setStrokeWidth(f1 * f2);
        canvas.drawPath(stroke.getPath(), c);
    }

    public final void a(boolean flag)
    {
        f = flag;
        g();
    }

    public final void b(Brush.Params params)
    {
        params.set(d);
    }

    public final int c()
    {
        return 2;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        b b1 = new b(this);
        b1.a(b);
        return b1;
    }

    public final String toString()
    {
        return "Emboss";
    }
}
