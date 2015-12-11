// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            gd, d, r, av

public class cq
{

    private static final String a = com/flurry/sdk/cq.getSimpleName();

    public cq()
    {
    }

    public static void a(r r)
    {
        if (r == null)
        {
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Firing onFetched, adObject=").append(r).toString());
            d d1 = new d();
            d1.a = r;
            d1.b = d.a.a;
            d1.b();
            return;
        }
    }

    public static void a(r r, av av)
    {
        if (r == null)
        {
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Firing onFetchFailed, adObject=").append(r).append(", errorCode=").append(av).toString());
            d d1 = new d();
            d1.a = r;
            d1.b = d.a.b;
            d1.c = av;
            d1.b();
            return;
        }
    }

    public static void b(r r)
    {
        if (r == null)
        {
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Firing onRendered, adObject=").append(r).toString());
            d d1 = new d();
            d1.a = r;
            d1.b = d.a.c;
            d1.b();
            return;
        }
    }

    public static void b(r r, av av)
    {
        if (r == null || av == null)
        {
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Firing onRenderFailed, adObject=").append(r).append(", errorCode=").append(av).toString());
            d d1 = new d();
            d1.a = r;
            d1.b = d.a.d;
            d1.c = av;
            d1.b();
            return;
        }
    }

}
