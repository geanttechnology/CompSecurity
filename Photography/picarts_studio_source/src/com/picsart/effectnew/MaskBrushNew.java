// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.effectnew:
//            t

public final class MaskBrushNew
{

    private static final int w[] = {
        55, 44, 32, 20, 10
    };
    public int a;
    int b;
    public float c;
    public float d;
    float e;
    public Paint f;
    Paint g;
    Paint h;
    Paint i;
    Paint j;
    Path k;
    Path l;
    Path m;
    float n;
    float o;
    float p;
    RectF q;
    Rect r;
    PointF s;
    PointF t;
    t u;
    public BrushDrawMode v;
    private final float x[] = {
        55F, 44F, 32F, 20F, 10F
    };

    public MaskBrushNew(Context context)
    {
        a = 2;
        b = 255;
        c = 75F;
        d = 100F;
        e = 100F;
        f = new Paint(2);
        g = new Paint(2);
        h = new Paint(2);
        i = new Paint(2);
        j = new Paint(2);
        k = new Path();
        l = new Path();
        m = new Path();
        p = 0.0F;
        q = new RectF();
        r = new Rect();
        s = new PointF();
        t = new PointF();
        v = BrushDrawMode.ERASE;
        a(context);
        f.setAntiAlias(true);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        f.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        f.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        f.setStrokeWidth(x[a]);
        f.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        f.setFilterBitmap(true);
        h.setAntiAlias(true);
        h.setStyle(android.graphics.Paint.Style.STROKE);
        h.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        h.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        h.setStrokeWidth(x[a]);
        h.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        i.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
    }

    private void a(Context context)
    {
        for (int i1 = 0; i1 < 5; i1++)
        {
            x[i1] = Utils.a(w[i1], context);
        }

    }

    public final int a()
    {
        int j1 = b;
        int i1 = j1;
        if (v == BrushDrawMode.DRAW)
        {
            i1 = 255 - j1;
        }
        return i1;
    }

    public final void a(float f1)
    {
        c = 100F - f1;
    }

    final void a(float f1, float f2, PointF pointf)
    {
        RectF rectf = u.e();
        int i1 = u.h();
        float f3 = rectf.left;
        float f4 = rectf.top;
        float f5 = (float)i1 / rectf.width();
        pointf.x = f5 * (f1 - f3);
        pointf.y = f5 * (f2 - f4);
    }

    public final void a(int i1)
    {
        float f6 = 128F;
        RectF rectf = u.e();
        RectF rectf1 = u.f();
        int j1 = u.h();
        a = i1;
        float f1 = rectf.width() / p;
        float f3 = rectf1.width() / rectf.width();
        float f4 = x[i1];
        f.setStrokeWidth(f3 * f1 * f4);
        float f7 = (float)j1 / rectf.width();
        f4 = (c * f.getStrokeWidth()) / 100F;
        f3 = f4 * f7;
        f1 = f.getStrokeWidth();
        h.setStrokeWidth(f1 * f7);
        if (f4 > 0.0F)
        {
            float f2 = f4;
            if (f4 > 128F)
            {
                f3 = 128F * f7;
                f2 = 128F;
            }
            if (f3 > 128F)
            {
                f3 = 128F / f7;
                f2 = f6;
            } else
            {
                float f5 = f2;
                f2 = f3;
                f3 = f5;
            }
            f.setMaskFilter(new BlurMaskFilter(f3, android.graphics.BlurMaskFilter.Blur.NORMAL));
            h.setMaskFilter(new BlurMaskFilter(f2, android.graphics.BlurMaskFilter.Blur.NORMAL));
        } else
        {
            f.setMaskFilter(null);
            h.setMaskFilter(null);
            f2 = f3;
            f3 = f4;
        }
        d = f3;
        e = f2;
    }

    public final void a(BrushDrawMode brushdrawmode)
    {
        if (v != brushdrawmode)
        {
            v = brushdrawmode;
            b = 255 - b;
        }
    }

    public final void b(int i1)
    {
        b = Math.min(255, Math.max(0, i1));
        if (v == BrushDrawMode.DRAW)
        {
            b = 255 - b;
        }
    }


    private class BrushDrawMode extends Enum
    {

        private static final BrushDrawMode $VALUES[];
        public static final BrushDrawMode DRAW;
        public static final BrushDrawMode ERASE;

        public static BrushDrawMode valueOf(String s1)
        {
            return (BrushDrawMode)Enum.valueOf(com/picsart/effectnew/MaskBrushNew$BrushDrawMode, s1);
        }

        public static BrushDrawMode[] values()
        {
            return (BrushDrawMode[])$VALUES.clone();
        }

        static 
        {
            DRAW = new BrushDrawMode("DRAW", 0);
            ERASE = new BrushDrawMode("ERASE", 1);
            $VALUES = (new BrushDrawMode[] {
                DRAW, ERASE
            });
        }

        private BrushDrawMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
