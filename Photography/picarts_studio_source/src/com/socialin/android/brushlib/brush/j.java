// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.util.e;
import junit.framework.Assert;
import myobfuscated.bs.b;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            Brush, k

public final class j extends Brush
{

    public int c;
    private Brush.Params d;
    private Paint e;
    private String f;
    private Bitmap g;
    private Matrix h;
    private float i[];

    j()
    {
        d = (new Brush.Params()).setSpacing(0.99F);
        e = new Paint(2);
        h = new Matrix();
        i = new float[2];
    }

    private j(j j1)
    {
        d = (new Brush.Params()).setSpacing(0.99F);
        e = new Paint(2);
        h = new Matrix();
        i = new float[2];
        d.set(j1.d);
        e = new Paint(j1.e);
        e.setXfermode(j1.b.xfermode);
        a(j1.f);
    }

    public static Brush.Params f()
    {
        return (new Brush.Params()).setThickness(12F).setSpacing(0.99F);
    }

    public final void a(float f1, float f2, Stroke stroke, RectF rectf)
    {
        stroke.computeBounds(rectf, true);
        f1 = -a * d.getThickness();
        rectf.inset(f1, f1);
    }

    public final void a(Xfermode xfermode)
    {
        e.setXfermode(xfermode);
    }

    public final void a(Brush.Params params)
    {
        d.set(params);
    }

    public final void a(Stroke stroke, float f1, float f2, Canvas canvas, RectF rectf)
    {
        Assert.assertNotNull(stroke);
        Assert.assertNotNull(canvas);
        e.setAlpha(d.getAlpha());
        if (g == null || g.isRecycled())
        {
            g = (Bitmap)myobfuscated.bs.b.a().c(f);
        }
        if (g != null)
        {
            if (h == null)
            {
                h = new Matrix();
            }
            if (i == null)
            {
                i = new float[2];
            }
            float f4 = (a * d.getThickness()) / (float)g.getWidth();
            float f3 = a * d.getSpacing() * d.getThickness();
            if (f3 < 0.1F)
            {
                f3 = 0.1F;
            }
            int i1 = (int)(f1 / f3);
            int l = i1;
            if ((float)i1 * f3 < f1)
            {
                l = i1 + 1;
            }
            i1 = l;
            if (rectf != null)
            {
                stroke.getPosTan(f1, i, null);
                rectf.set(i[0], i[1], i[0], i[1]);
                i1 = l;
            }
            do
            {
                f1 = (float)i1 * f3;
                if (f1 >= f2)
                {
                    break;
                }
                stroke.getPosTan(f1, i, null);
                h.setTranslate(-48F, -48F);
                h.postScale(f4, f4);
                h.postTranslate(i[0], i[1]);
                canvas.drawBitmap(g, h, e);
                if (rectf != null)
                {
                    rectf.union(i[0], i[1]);
                }
                i1++;
            } while (true);
            if (rectf != null)
            {
                rectf.inset(-a * d.getThickness() * k.c, -f4 * (float)g.getHeight() * k.c);
                return;
            }
        }
    }

    public final void a(Stroke stroke, Canvas canvas)
    {
        a(stroke, 0.0F, stroke.getLength(), canvas, null);
    }

    public final void a(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "default";
        }
        f = s1;
        g = (Bitmap)myobfuscated.bs.b.a().c(f);
    }

    public final void b(Brush.Params params)
    {
        params.set(d);
    }

    public final int c()
    {
        return 21;
    }

    public final Object clone()
    {
        return d();
    }

    public final Brush d()
    {
        j j1 = new j(this);
        j1.a(b);
        j1.c = c;
        return j1;
    }

    public final String toString()
    {
        return "Sticker brush";
    }
}
