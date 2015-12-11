// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.google.a.a.b.b;

// Referenced classes of package com.smule.pianoandroid.ads:
//            FlurryDFPInterstitial

class e
    implements Runnable
{

    final FlurryDFPInterstitial a;
    private b b;
    private long c;

    private e(FlurryDFPInterstitial flurrydfpinterstitial, b b1, long l)
    {
        a = flurrydfpinterstitial;
        super();
        b = b1;
        c = l;
    }

    e(FlurryDFPInterstitial flurrydfpinterstitial, b b1, long l, FlurryDFPInterstitial._cls1 _pcls1)
    {
        this(flurrydfpinterstitial, b1, l);
    }

    public void run()
    {
        FlurryDFPInterstitial.access$200(a, b, c);
    }
}
