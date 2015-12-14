// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.picsart.effectnew:
//            EffectShapeDrawerNew

public final class i
{

    int a;
    PointF b;
    float c;
    PointF d;
    float e;
    float f;
    public PointF g;
    public float h;
    final EffectShapeDrawerNew i;

    public i(EffectShapeDrawerNew effectshapedrawernew, PointF pointf, float f1)
    {
        i = effectshapedrawernew;
        super();
        a = -1;
        b = new PointF();
        c = 0.0F;
        d = new PointF();
        e = 1.0F;
        f = 1.0F;
        g = new PointF();
        h = 0.0F;
        b = pointf;
        c = f1;
        d = new PointF();
        a();
    }

    final void a()
    {
        if (i.m == EffectShapeDrawerNew.ShapeType.Focal)
        {
            d.x = (float)((double)b.x + Math.abs(Math.cos(Math.toRadians(-45D)) * (double)c * (double)e) + (double)i.a + 10D);
            d.y = (float)((double)b.y + Math.abs(Math.sin(Math.toRadians(-45D)) * (double)c * (double)f) + (double)i.a + 10D);
            return;
        } else
        {
            d.x = b.x + c * Math.abs(e) + i.a + 10F;
            d.y = b.y + c * Math.abs(f) + i.a + 10F;
            return;
        }
    }

    public final void a(float f1)
    {
        c = f1;
        a();
    }

    public final void a(float f1, float f2)
    {
        b.x = f1;
        b.y = f2;
        a();
    }

    public final void a(float f1, RectF rectf)
    {
        f1 /= rectf.width();
        g.x = (b.x - rectf.left) * f1;
        g.y = (b.y - rectf.top) * f1;
        h = f1 * c;
    }

    final boolean a(float f1, float f2, float f3, float f4)
    {
        return f3 >= f1 - i.b && f3 <= i.b + f1 && f4 >= f2 - i.b && f4 <= i.b + f2;
    }
}
