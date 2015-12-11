// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.facebook.ads.e;
import com.facebook.ads.f;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            FacebookListener

public class FacebookBanner
    implements MediatedBannerAdView
{

    private f adView;

    public FacebookBanner()
    {
    }

    public void destroy()
    {
        if (adView != null)
        {
            adView.b();
            try
            {
                adView.setAdListener(null);
            }
            catch (NullPointerException nullpointerexception) { }
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

    public View requestAd(ad ad, Activity activity, String s, String s1, int i, int j, at at)
    {
        ad = new FacebookListener(ad, getClass().getSimpleName());
        adView = new f(activity, s1, e.a);
        if (i != e.a.a() || j != e.a.b())
        {
            b.b(b.c, "Facebook - Attempted to instantiate with size other than the allowed size of 320x50. Instantiating with allowed size.");
        }
        adView.setAdListener(ad);
        adView.a();
        return adView;
    }
}
