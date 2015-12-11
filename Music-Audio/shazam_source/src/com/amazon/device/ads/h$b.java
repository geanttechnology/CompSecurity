// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            g, h, cn, ae, 
//            k, l, v

final class a
    implements g
{

    final h a;

    public final void a()
    {
        h.b(a).b("DefaultAdControlCallback onAdRendered called", null);
    }

    public final void a(k k)
    {
        h.b(a).b("DefaultAdControlCallback onAdFailed called", null);
    }

    public final void a(l l)
    {
        h.b(a).b("DefaultAdControlCallback onAdEvent called", null);
    }

    public final void a(v v)
    {
        h.b(a).b("DefaultAdControlCallback onAdLoaded called", null);
    }

    public final boolean a(boolean flag)
    {
        h.b(a).b("DefaultAdControlCallback isAdReady called", null);
        return a.x.equals(ae.a) || a.x.equals(ae.g);
    }

    public final void b()
    {
        h.b(a).b("DefaultAdControlCallback postAdRendered called", null);
    }

    public final int c()
    {
        h.b(a).b("DefaultAdControlCallback adClosing called", null);
        return 1;
    }

    public final void d()
    {
        h.b(a).b("DefaultAdControlCallback onAdExpired called", null);
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
