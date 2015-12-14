// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            aj

public final class ak
{

    private PointF a;
    private PointF b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private long j;

    public ak()
    {
        g = -1F;
        j = 1000L;
    }

    static PointF a(ak ak1)
    {
        return ak1.a;
    }

    static PointF b(ak ak1)
    {
        return ak1.b;
    }

    static float c(ak ak1)
    {
        return ak1.c;
    }

    static float d(ak ak1)
    {
        return ak1.d;
    }

    static float e(ak ak1)
    {
        return ak1.e;
    }

    static float f(ak ak1)
    {
        return ak1.f;
    }

    static boolean g(ak ak1)
    {
        return ak1.h;
    }

    static boolean h(ak ak1)
    {
        return ak1.i;
    }

    static long i(ak ak1)
    {
        return ak1.j;
    }

    static float j(ak ak1)
    {
        return ak1.g;
    }

    public aj a()
    {
        return new aj(this, null);
    }

    public ak a(float f1)
    {
        c = f1;
        return this;
    }

    public ak a(long l)
    {
        j = l;
        return this;
    }

    public ak a(PointF pointf)
    {
        a = pointf;
        return this;
    }

    public ak a(boolean flag)
    {
        h = flag;
        return this;
    }

    public ak b(float f1)
    {
        d = f1;
        return this;
    }

    public ak b(PointF pointf)
    {
        b = pointf;
        return this;
    }

    public ak b(boolean flag)
    {
        i = flag;
        return this;
    }
}
