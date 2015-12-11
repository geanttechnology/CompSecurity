// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.jirbo.adcolony.aj;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            AdColonyDFPInterstitial

class a
    implements Runnable
{

    final AdColonyDFPInterstitial a;

    public void run()
    {
        long l = AdColonyDFPInterstitial.access$000();
_L2:
        if (l <= 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (AdColonyDFPInterstitial.access$100(a).f())
        {
            AdColonyDFPInterstitial.access$400(a, AdColonyDFPInterstitial.access$200(a), AdColonyDFPInterstitial.access$300(a));
            return;
        }
        Thread.sleep(100L);
        l -= 100L;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            AdColonyDFPInterstitial.access$500(a, AdColonyDFPInterstitial.access$200(a), AdColonyDFPInterstitial.access$300(a));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            aa.a(AdColonyDFPInterstitial.access$600(), "isReady() thread interrupted");
        }
        return;
    }

    (AdColonyDFPInterstitial adcolonydfpinterstitial)
    {
        a = adcolonydfpinterstitial;
        super();
    }
}
