// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.l;
import myobfuscated.av.d;

// Referenced classes of package com.socialin.android.photo.select:
//            l, f

public final class e
    implements d
{

    f a;
    com.socialin.android.photo.select.l b;
    private Matrix c;
    private float d;
    private PointF e;
    private PointF f;
    private PointF g;
    private float h;
    private boolean i;
    private float j;

    public e(Context context)
    {
        c = new Matrix();
        e = new PointF();
        f = new PointF();
        g = new PointF();
        h = 0.0F;
        i = true;
        b = new com.socialin.android.photo.select.l(context, this);
        h = Utils.a(0.0F, context);
    }

    private void a(float f1, float f2)
    {
        RectF rectf = a.d();
        c.reset();
        c.postTranslate(f1, f2);
        c.mapRect(rectf);
    }

    private float[] a(float f1, float f2, float f3, float f4, float f5)
    {
        c.reset();
        c.postRotate(f3, f4, f5);
        float af[] = new float[2];
        af[0] = f1;
        af[1] = f2;
        c.mapPoints(af);
        return af;
    }

    public final void a()
    {
        if (!a.b())
        {
            return;
        }
        RectF rectf = a.d();
        d = 0.0F;
        if (j != 0.0F)
        {
            PointF pointf = a.h();
            float f2 = pointf.x * rectf.width() + rectf.left;
            float f3 = pointf.y * rectf.height() + rectf.top;
            float f1 = l.a(new PointF(rectf.centerX(), rectf.centerY()), new PointF(rectf.centerX(), rectf.centerY() - 100F), new PointF(rectf.centerX(), rectf.centerY()), new PointF(f2, f3));
            float af[];
            if (f1 > 360F)
            {
                f1 -= 360F;
            } else
            if (f1 < 0.0F)
            {
                f1 += 360F;
            }
            af = a(rectf.centerX(), rectf.centerY(), j, f2, f3);
            rectf.offset(af[0] - rectf.centerX(), af[1] - rectf.centerY());
            f3 = l.a(new PointF(af[0], af[1]), new PointF(af[0], af[1] - 100F), new PointF(af[0], af[1]), new PointF(f2, f3));
            if (f3 > 360F)
            {
                f2 = f3 - 360F;
            } else
            {
                f2 = f3;
                if (f3 < 0.0F)
                {
                    f2 = f3 + 360F;
                }
            }
            j = f2 - f1;
            a.a(j);
            pointf.x = 0.5F;
            pointf.y = 0.5F;
        }
        a.c();
    }

    public final void a(PointF pointf)
    {
        a.a(pointf);
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        if (!a.b())
        {
            return;
        }
        a.a(pointf, pointf1);
        RectF rectf = a.d();
        d = Geom.a(pointf, pointf1);
        e.x = (pointf.x + pointf1.x) / 2.0F;
        e.y = (pointf.y + pointf1.y) / 2.0F;
        j = a.g();
        if (j != 0.0F)
        {
            float af[] = a(rectf.centerX(), rectf.centerY(), -j, e.x, e.y);
            rectf.offset(af[0] - rectf.centerX(), af[1] - rectf.centerY());
        }
        PointF pointf2 = a.h();
        pointf2.x = (e.x - rectf.left) / rectf.width();
        pointf2.y = (e.y - rectf.top) / rectf.height();
        f.set(pointf);
        g.set(pointf1);
        a.c();
    }

    public final void a(PointF pointf, PointF pointf1, boolean flag, boolean flag1)
    {
        if (a.b()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        RectF rectf = a.d();
        if (!flag || !flag1) goto _L4; else goto _L3
_L3:
        float f4;
        boolean flag2;
        f4 = Geom.a(pointf, pointf1);
        flag2 = false;
        a.l();
        if (Math.abs(f4 - d) < h) goto _L6; else goto _L5
_L5:
        if (d == 0.0F) goto _L8; else goto _L7
_L7:
        float f1;
        float f8;
        float f10;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        PointF pointf2 = a.h();
        f1 = f4 / d;
        f8 = pointf2.x;
        f10 = rectf.width();
        f12 = rectf.left;
        f13 = pointf2.y;
        f14 = rectf.height();
        f15 = rectf.top;
        f16 = rectf.width() / a.e().width();
        f19 = a.i();
        f17 = a.j();
        f18 = f16 * f1;
        if (f18 >= f19) goto _L10; else goto _L9
_L9:
        f1 = f19 / f16;
_L11:
        c.reset();
        c.postScale(f1, f1, f8 * f10 + f12, f13 * f14 + f15);
        c.mapRect(rectf);
_L8:
        d = f4;
        flag2 = true;
_L6:
        boolean flag3 = flag2;
        if (i)
        {
            f1 = (pointf.x + pointf1.x) / 2.0F;
            float f5 = (pointf.y + pointf1.y) / 2.0F;
            float f9 = f1 - e.x;
            float f11 = f5 - e.y;
            flag3 = flag2;
            if (Math.sqrt(f9 * f9 + f11 * f11) >= (double)h)
            {
                a(f9, f11);
                e.x = f1;
                e.y = f5;
                flag3 = true;
            }
        }
        if (a.f())
        {
            j = l.a(f, g, pointf, pointf1) + j;
            a.a(j);
            flag3 = true;
        }
        if (flag3)
        {
            a.k();
            a.m();
            a.c();
        }
        f.set(pointf);
        g.set(pointf1);
        return;
_L10:
        if (f18 > f17)
        {
            f1 = f17 / f16;
        }
        if (true) goto _L11; else goto _L4
_L4:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i)
        {
            float f2 = pointf.x - f.x;
            float f6 = pointf.y - f.y;
            if (Math.sqrt(f2 * f2 + f6 * f6) >= (double)h)
            {
                a.l();
                a(f2, f6);
                f.set(pointf);
                a.k();
                a.m();
                a.c();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!flag1 || !i) goto _L1; else goto _L12
_L12:
        float f3 = pointf1.x - g.x;
        float f7 = pointf1.y - g.y;
        if (Math.sqrt(f3 * f3 + f7 * f7) >= (double)h)
        {
            a.l();
            a(f3, f7);
            g.set(pointf1);
            a.k();
            a.m();
            a.c();
            return;
        }
        if (true) goto _L1; else goto _L13
_L13:
    }

    public final void b(PointF pointf)
    {
        a.b(pointf);
    }

    public final void c(PointF pointf)
    {
        a.c(pointf);
    }

    public final void d(PointF pointf)
    {
        if (a != null)
        {
            a.d(pointf);
        }
    }
}
