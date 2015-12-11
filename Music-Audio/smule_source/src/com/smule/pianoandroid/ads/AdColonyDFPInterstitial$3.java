// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;

// Referenced classes of package com.smule.pianoandroid.ads:
//            AdColonyDFPInterstitial

class a
    implements Runnable
{

    final CustomEventInterstitialListener a;
    final AdColonyDFPInterstitial b;

    public void run()
    {
        a.onAdFailedToLoad(0);
    }

    omEventInterstitialListener(AdColonyDFPInterstitial adcolonydfpinterstitial, CustomEventInterstitialListener customeventinterstitiallistener)
    {
        b = adcolonydfpinterstitial;
        a = customeventinterstitiallistener;
        super();
    }
}
