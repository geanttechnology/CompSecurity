// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.ac;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.b.b;
import com.facebook.ads.a;
import com.facebook.ads.c;
import com.facebook.ads.i;

public class FacebookListener
    implements c, i
{

    private final ac a;
    private final String b;

    public FacebookListener(ac ac1, String s)
    {
        a = ac1;
        b = s;
    }

    public final void a()
    {
        if (a != null)
        {
            a.e();
        }
    }

    public final void a(a a1)
    {
        if (a != null)
        {
            a.c();
        }
    }

    public final void a(a a1, com.facebook.ads.b b1)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder()).append(b).append(" | Facebook - onError called for AdView with error message ").append(b1.b()).toString());
        if (b1.a() == com.facebook.ads.b.b.a())
        {
            a1 = aq.c;
        } else
        if (b1.a() == com.facebook.ads.b.c.a())
        {
            a1 = aq.b;
        } else
        if (b1.a() != com.facebook.ads.b.e.a() && b1.a() == com.facebook.ads.b.f.a())
        {
            a1 = aq.b;
        } else
        {
            a1 = aq.f;
        }
        if (a != null)
        {
            a.a(a1);
        }
    }

    public final void b()
    {
        if (a != null)
        {
            a.d();
        }
    }

    public final void b(a a1)
    {
        if (a != null)
        {
            a.f();
        }
    }
}
