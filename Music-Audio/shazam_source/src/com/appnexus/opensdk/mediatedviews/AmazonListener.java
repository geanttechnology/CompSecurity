// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.amazon.device.ads.k;
import com.amazon.device.ads.o;
import com.appnexus.opensdk.ac;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.b.b;

class AmazonListener
    implements o
{

    final ac a;
    final String b;

    public AmazonListener(ac ac1, String s)
    {
        a = ac1;
        b = s;
    }

    public final void a()
    {
        a("onLoaded");
        if (a != null)
        {
            a.c();
        }
    }

    public final void a(k k1)
    {
        aq aq1;
        aq aq2;
        b((new StringBuilder(" onAdFailedToLoad: ")).append(k1.b).toString());
        aq2 = aq.f;
        aq1 = aq2;
        if (k1 == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.amazon.device.ads.k.a.values().length];
                try
                {
                    a[com.amazon.device.ads.k.a.d.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.amazon.device.ads.k.a.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.amazon.device.ads.k.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.amazon.device.ads.k.a.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[k1.a.ordinal()];
        JVM INSTR tableswitch 1 4: default 76
    //                   1 94
    //                   2 101
    //                   3 108
    //                   4 115;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        aq1 = aq2;
_L2:
        if (a != null)
        {
            a.a(aq1);
        }
        return;
_L4:
        aq1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L5:
        aq1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L6:
        aq1 = aq.c;
        continue; /* Loop/switch isn't completed */
_L7:
        aq1 = aq.b;
        if (true) goto _L2; else goto _L8
_L8:
    }

    final void a(String s)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder()).append(b).append(" - ").append(s).toString());
    }

    public final void b()
    {
        a("onExpanded");
        if (a != null)
        {
            a.d();
        }
    }

    final void b(String s)
    {
        com.appnexus.opensdk.b.b.e(b.c, (new StringBuilder()).append(b).append(" - ").append(s).toString());
    }

    public final void c()
    {
        a("onCollapsed");
        if (a != null)
        {
            a.e();
        }
    }

    public final void d()
    {
        a("onDismissed");
        if (a != null)
        {
            a.e();
        }
    }
}
