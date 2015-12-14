// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.util.Log;
import android.view.View;
import com.fotoable.ad.StaticFlurryEvent;
import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.fotoable.ads:
//            GADFotoAdBanner

class er extends AdListener
{

    final GADFotoAdBanner a;

    public void onAdFailedToLoad(int i)
    {
        super.onAdFailedToLoad(i);
        StaticFlurryEvent.logBannerEventWithKV("GADBanner", StaticFlurryEvent.adLoadedFailed);
        Log.d("GADBanner", (new StringBuilder()).append("AdBanner falied.").append(String.valueOf(i)).toString());
    }

    public void onAdLoaded()
    {
        super.onAdLoaded();
        Log.d("GADBanner", "AdBanner loaded.");
        StaticFlurryEvent.logBannerEventWithKV("GADBanner", StaticFlurryEvent.adLoaded);
        if (GADFotoAdBanner.access$000(a) != null)
        {
            GADFotoAdBanner.access$100(a).setVisibility(4);
        }
    }

    er(GADFotoAdBanner gadfotoadbanner)
    {
        a = gadfotoadbanner;
        super();
    }
}
