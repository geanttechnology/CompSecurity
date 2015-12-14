// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ak

public final class aj
{

    public static final PointF a = new PointF(-2F, -2F);
    public static final PointF b = new PointF(-1F, -1F);
    private final PointF c;
    private final PointF d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final boolean i;
    private final boolean j;
    private final long k;
    private final float l;

    private aj(ak ak1)
    {
        float f2 = -1F;
        super();
        float f1;
        PointF pointf;
        long l1;
        if (a(ak.a(ak1)))
        {
            pointf = ak.a(ak1);
        } else
        {
            pointf = b;
        }
        c = pointf;
        if (a(ak.b(ak1)))
        {
            pointf = ak.b(ak1);
        } else
        {
            pointf = b;
        }
        d = pointf;
        if (a(ak.c(ak1)))
        {
            f1 = ak.c(ak1);
        } else
        {
            f1 = -1F;
        }
        e = f1;
        if (a(ak.d(ak1)))
        {
            f1 = ak.d(ak1);
        } else
        {
            f1 = -1F;
        }
        f = f1;
        if (b(ak.e(ak1)))
        {
            f1 = ak.e(ak1);
        } else
        {
            f1 = -1F;
        }
        g = f1;
        if (b(ak.f(ak1)))
        {
            f1 = ak.f(ak1);
        } else
        {
            f1 = -1F;
        }
        h = f1;
        i = ak.g(ak1);
        j = ak.h(ak1);
        if (a(ak.i(ak1)))
        {
            l1 = ak.i(ak1);
        } else
        {
            l1 = 1000L;
        }
        k = l1;
        f1 = f2;
        if (c(ak.j(ak1)))
        {
            f1 = ak.j(ak1);
        }
        l = f1;
    }


    private boolean a(float f1)
    {
        return f1 > 0.0F || f1 == -2F || f1 == -1F;
    }

    private boolean a(long l1)
    {
        return l1 >= 0L;
    }

    private boolean a(PointF pointf)
    {
        return pointf != null;
    }

    private boolean b(float f1)
    {
        return true;
    }

    private boolean c(float f1)
    {
        return f1 >= 0.0F && f1 <= 1.0F;
    }

    public PointF a()
    {
        return c;
    }

    public PointF b()
    {
        return d;
    }

    public float c()
    {
        return e;
    }

    public float d()
    {
        return f;
    }

    public float e()
    {
        return g;
    }

    public float f()
    {
        return h;
    }

    public boolean g()
    {
        return j;
    }

    public long h()
    {
        return k;
    }

    public float i()
    {
        return l;
    }

}
