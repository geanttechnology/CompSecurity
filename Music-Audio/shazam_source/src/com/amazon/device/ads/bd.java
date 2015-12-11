// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            bj, co, cn, k

public class bd
    implements bj
{

    final String a;
    private final cn b;

    public bd()
    {
        this(com/amazon/device/ads/bd.getSimpleName());
    }

    bd(String s)
    {
        a = s;
        new co();
        b = co.a(a);
    }

    public final void a()
    {
        b.b("Default ad listener called - AdLoaded.", null);
    }

    public final void a(k k1)
    {
        b.b("Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", new Object[] {
            k1.a, k1.b
        });
    }

    public final void b()
    {
        b.b("Default ad listener called - Ad Will Expand.", null);
    }

    public final void c()
    {
        b.b("Default ad listener called - Ad Collapsed.", null);
    }

    public final void d()
    {
        b.b("Default ad listener called - Ad Dismissed.", null);
    }

    public final void e()
    {
        b.b("Default ad listener called - Ad Resized.", null);
    }

    public final void f()
    {
        b.b("Default ad listener called - Ad Expired.", null);
    }
}
