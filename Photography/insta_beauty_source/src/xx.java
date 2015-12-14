// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;

class xx
    implements Runnable
{

    final xu a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    public xx(xu xu1, float f, float f1, float f2, float f3)
    {
        a = xu1;
        super();
        d = f1;
        b = f2;
        c = f3;
        if (f < f1)
        {
            e = 1.07F;
            return;
        } else
        {
            e = 0.93F;
            return;
        }
    }

    public void run()
    {
        float f;
label0:
        {
            android.widget.ImageView imageview = a.d();
            if (imageview != null)
            {
                xu.c(a).postScale(e, e, b, c);
                xu.d(a);
                f = a.h();
                if ((e <= 1.0F || f >= d) && (e >= 1.0F || d >= f))
                {
                    break label0;
                }
                xt.a(imageview, this);
            }
            return;
        }
        f = d / f;
        xu.c(a).postScale(f, f, b, c);
        xu.d(a);
    }
}
