// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.jirbo.adcolony.s;
import com.jirbo.adcolony.u;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            AdColonyDFPInterstitial

class a
    implements u
{

    final AdColonyDFPInterstitial a;

    public void a(s s1)
    {
        aa.a(AdColonyDFPInterstitial.access$600(), "Attempt finished");
        aa.a(AdColonyDFPInterstitial.access$600(), (new StringBuilder()).append("canceled  ").append(s1.c()).toString());
        aa.a(AdColonyDFPInterstitial.access$600(), (new StringBuilder()).append("shown     ").append(s1.a()).toString());
        aa.a(AdColonyDFPInterstitial.access$600(), (new StringBuilder()).append("no fill   ").append(s1.d()).toString());
        aa.a(AdColonyDFPInterstitial.access$600(), (new StringBuilder()).append("not shown ").append(s1.b()).toString());
        aa.a(AdColonyDFPInterstitial.access$600(), (new StringBuilder()).append("skipped   ").append(s1.e()).toString());
    }

    public void b(s s1)
    {
        AdColonyDFPInterstitial.access$200(a).onAdOpened();
    }

    omEventInterstitialListener(AdColonyDFPInterstitial adcolonydfpinterstitial)
    {
        a = adcolonydfpinterstitial;
        super();
    }
}
