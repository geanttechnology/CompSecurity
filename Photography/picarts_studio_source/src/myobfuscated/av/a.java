// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.av;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.l;

// Referenced classes of package myobfuscated.av:
//            d, c, b

public final class a
    implements d
{

    b a;
    public c b;
    private Matrix c;
    private float d;
    private PointF e;
    private PointF f;
    private PointF g;
    private float h;
    private boolean i;
    private float j;

    public a(Context context)
    {
        c = new Matrix();
        e = new PointF();
        f = new PointF();
        g = new PointF();
        h = 0.0F;
        i = true;
        b = new c(context, this);
        h = Utils.a(0.0F, context);
    }

    private void a(float f1, float f2)
    {
        RectF rectf = a.c;
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
        if (!a.f)
        {
            return;
        }
        RectF rectf = a.c;
        d = 0.0F;
        if (j != 0.0F)
        {
            PointF pointf = a.d;
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
            pointf.x = 0.5F;
            pointf.y = 0.5F;
        }
        a.a();
    }

    public final void a(PointF pointf)
    {
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        if (!a.f)
        {
            return;
        }
        RectF rectf = a.c;
        d = Geom.a(pointf, pointf1);
        e.x = (pointf.x + pointf1.x) / 2.0F;
        e.y = (pointf.y + pointf1.y) / 2.0F;
        j = 0.0F;
        if (j != 0.0F)
        {
            float af[] = a(rectf.centerX(), rectf.centerY(), -j, e.x, e.y);
            rectf.offset(af[0] - rectf.centerX(), af[1] - rectf.centerY());
        }
        PointF pointf2 = a.d;
        pointf2.x = (e.x - rectf.left) / rectf.width();
        pointf2.y = (e.y - rectf.top) / rectf.height();
        f.set(pointf);
        g.set(pointf1);
        a.a();
    }

    public final void a(PointF pointf, PointF pointf1, boolean flag, boolean flag1)
    {
        if (a.f) goto _L2; else goto _L1
_L1:
        return;
_L2:
        RectF rectf = a.c;
        if (!flag || !flag1) goto _L4; else goto _L3
_L3:
        float f4;
        boolean flag2;
        f4 = Geom.a(pointf, pointf1);
        flag2 = false;
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
        PointF pointf2 = a.d;
        f1 = f4 / d;
        f8 = pointf2.x;
        f10 = rectf.width();
        f12 = rectf.left;
        f13 = pointf2.y;
        f14 = rectf.height();
        f15 = rectf.top;
        f16 = rectf.width() / a.b.width();
        f17 = f16 * f1;
        if (f17 >= 1.0F) goto _L10; else goto _L9
_L9:
        f1 = 1.0F / f16;
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
        if (flag3)
        {
            a.a();
        }
        f.set(pointf);
        g.set(pointf1);
        return;
_L10:
        if (f17 > 4F)
        {
            f1 = 4F / f16;
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
                a(f2, f6);
                f.set(pointf);
                a.a();
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
            a(f3, f7);
            g.set(pointf1);
            a.a();
            return;
        }
        if (true) goto _L1; else goto _L13
_L13:
    }

    public final void b(PointF pointf)
    {
    }

    public final void c(PointF pointf)
    {
    }

    public final void d(PointF pointf)
    {
    }
}
