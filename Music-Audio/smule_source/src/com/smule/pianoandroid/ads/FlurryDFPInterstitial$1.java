// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAds;

// Referenced classes of package com.smule.pianoandroid.ads:
//            FlurryDFPInterstitial

class a
    implements Runnable
{

    final FlurryDFPInterstitial a;

    public void run()
    {
        FlurryAds.fetchAd(FlurryDFPInterstitial.access$400(a), FlurryDFPInterstitial.access$500(a), (ViewGroup)FlurryDFPInterstitial.access$400(a).findViewById(0x7f0a00b5), FlurryAdSize.FULLSCREEN);
    }

    (FlurryDFPInterstitial flurrydfpinterstitial)
    {
        a = flurrydfpinterstitial;
        super();
    }
}
