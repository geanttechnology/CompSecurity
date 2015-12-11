// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.at;
import com.mopub.mobileads.u;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            MoPubListener

public class MoPubBannerAdView
    implements MediatedBannerAdView
{

    private u adView;
    private MoPubListener mpListener;

    public MoPubBannerAdView()
    {
    }

    public void destroy()
    {
        if (adView != null)
        {
            adView.setBannerAdListener(null);
            mpListener = null;
            adView.c();
            adView = null;
        }
    }

    public void onDestroy()
    {
        destroy();
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public View requestAd(ad ad, Activity activity, String s, String s1, int i, int j, at at1)
    {
        mpListener = new MoPubListener(ad, getClass().getSimpleName());
        adView = new u(activity);
        adView.setAdUnitId(s1);
        adView.setBannerAdListener(mpListener);
        adView.setAutorefreshEnabled(false);
        if (at1 != null)
        {
            if (at1.d != null)
            {
                adView.setLocation(at1.d);
            }
            ad = MoPubListener.a(at1);
            adView.setKeywords(ad);
        }
        adView.setMinimumWidth(i);
        adView.setMinimumHeight(j);
        adView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        adView.b();
        return adView;
    }
}
