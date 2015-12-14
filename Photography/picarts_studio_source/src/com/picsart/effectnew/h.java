// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.effectnew:
//            EffectShapeDrawerNew, j, p, i

public final class h
{

    public int a;
    Paint b;
    Paint c;
    j d;
    public EffectShapeDrawerNew e;
    private Paint f;

    public h(Context context)
    {
        a = 0;
        b = new Paint();
        b.setAntiAlias(true);
        b.setFilterBitmap(true);
        b.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        b.setStyle(android.graphics.Paint.Style.FILL);
        c = new Paint();
        c.setFilterBitmap(true);
        c.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        f = new Paint();
        f.setAntiAlias(true);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        e = new EffectShapeDrawerNew(com.socialin.android.util.c.a(context.getResources(), 0x7f02024d), com.socialin.android.util.c.a(context.getResources(), 0x7f020249));
        e.n = this;
    }

    public final RectF a()
    {
        if (d != null)
        {
            return d.e();
        } else
        {
            return null;
        }
    }

    public final p a(Canvas canvas)
    {
        if (d == null)
        {
            return null;
        }
        p p1 = d();
        if (p1 != null)
        {
            android.graphics.Bitmap bitmap = d.a();
            android.graphics.Bitmap bitmap1 = d.b();
            EffectShapeDrawerNew.ShapeType shapetype = p1.j;
            float f3 = p1.g;
            float f4 = p1.h;
            float f2 = p1.i;
            int k = 255 - p1.e;
            float f5 = p1.d;
            PointF pointf = p1.f;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            paint.setStyle(android.graphics.Paint.Style.FILL);
            float f1 = f3 - (f3 * f5) / 100F;
            if (f5 > 0.0F)
            {
                paint.setMaskFilter(new BlurMaskFilter((f3 * (float)a) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL));
            }
            canvas.save();
            canvas.scale(f4, f2);
            f3 = pointf.x / f4;
            f2 = pointf.y / f2;
            if (shapetype == EffectShapeDrawerNew.ShapeType.Focal)
            {
                canvas.drawCircle(f3, f2, f1, paint);
            } else
            {
                canvas.drawRect(f3 - f1, f2 - f1, f3 + f1, f2 + f1, paint);
            }
            canvas.restore();
            c.setAlpha(k);
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, c);
            if (k < 255)
            {
                c.setAlpha(255);
                canvas.drawBitmap(bitmap1, 0.0F, 0.0F, c);
            }
        }
        return p1;
    }

    public final void a(int k)
    {
        a = k;
        BlurMaskFilter blurmaskfilter = null;
        if ((float)a > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((e.c.c * (float)a) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        b.setMaskFilter(blurmaskfilter);
    }

    public final int b()
    {
        if (d != null)
        {
            return d.h();
        } else
        {
            return 0;
        }
    }

    public final void c()
    {
        if (d != null)
        {
            e.m = EffectShapeDrawerNew.ShapeType.Focal;
            EffectShapeDrawerNew effectshapedrawernew = e;
            if (effectshapedrawernew.n != null)
            {
                RectF rectf = effectshapedrawernew.n.a();
                float f1 = effectshapedrawernew.n.b();
                effectshapedrawernew.c = new i(effectshapedrawernew, new PointF(rectf.centerX(), rectf.centerY()), Math.min(rectf.width(), rectf.height()) / 2.0F);
                effectshapedrawernew.c.a(f1, rectf);
            }
            e.l = true;
            a(0);
        }
    }

    public final p d()
    {
        p p2 = null;
        Object obj = null;
        if (d == null)
        {
            p2 = obj;
        } else
        {
            EffectShapeDrawerNew effectshapedrawernew = e;
            p p1 = p2;
            if (effectshapedrawernew.n != null)
            {
                RectF rectf = effectshapedrawernew.n.a();
                float f1 = effectshapedrawernew.n.b();
                p1 = p2;
                if (effectshapedrawernew.c != null)
                {
                    p1 = p2;
                    if (rectf != null)
                    {
                        effectshapedrawernew.c.a(f1, rectf);
                        p1 = new p();
                        p1.f = new PointF(effectshapedrawernew.c.g.x, effectshapedrawernew.c.g.y);
                        p1.g = effectshapedrawernew.c.h;
                        p1.a = EffectsDrawHistoryController.EffectDrawType.DRAW_SHAPE;
                        p1.h = effectshapedrawernew.c.e;
                        p1.i = effectshapedrawernew.c.f;
                    }
                }
            }
            p2 = p1;
            if (p1 != null)
            {
                p1.d = a;
                p1.j = e.m;
                p1.e = 255 - d.i();
                return p1;
            }
        }
        return p2;
    }
}
