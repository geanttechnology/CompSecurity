// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.ac;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.b.b;
import com.google.android.gms.ads.a;

public class GooglePlayAdListener extends a
{

    ac a;
    String b;

    public GooglePlayAdListener(ac ac1, String s)
    {
        a = ac1;
        b = s;
    }

    final void a(String s)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder()).append(b).append(" - ").append(s).toString());
    }

    final void b(String s)
    {
        com.appnexus.opensdk.b.b.e(b.c, (new StringBuilder()).append(b).append(" - ").append(s).toString());
    }

    public void onAdClosed()
    {
        super.onAdClosed();
        a("onAdClosed");
        if (a != null && (a instanceof ad))
        {
            a.e();
        }
    }

    public void onAdFailedToLoad(int i)
    {
        aq aq1;
        super.onAdFailedToLoad(i);
        a((new StringBuilder("onAdFailedToLoad with error code ")).append(i).toString());
        aq1 = aq.f;
        i;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 76
    //                   1 83
    //                   2 90
    //                   3 97;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (a != null)
        {
            a.a(aq1);
        }
        return;
_L2:
        aq1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L3:
        aq1 = aq.b;
        continue; /* Loop/switch isn't completed */
_L4:
        aq1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L5:
        aq1 = aq.c;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onAdLeftApplication()
    {
        super.onAdLeftApplication();
        a("onAdLeftApplication");
        if (a != null)
        {
            a.f();
        }
    }

    public void onAdLoaded()
    {
        super.onAdLoaded();
        a("onAdLoaded");
        if (a != null)
        {
            a.c();
        }
    }

    public void onAdOpened()
    {
        super.onAdOpened();
        a("onAdOpened");
        if (a != null && (a instanceof ad))
        {
            a.d();
        }
    }
}
