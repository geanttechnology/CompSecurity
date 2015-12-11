// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.at;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GoogleBridge

public class DFPBanner
    implements MediatedBannerAdView
{

    private MediatedBannerAdView mediatedAdView;

    public DFPBanner()
    {
    }

    public void destroy()
    {
        if (mediatedAdView != null)
        {
            mediatedAdView.destroy();
            mediatedAdView = null;
        }
    }

    public void onDestroy()
    {
        if (mediatedAdView != null)
        {
            mediatedAdView.onDestroy();
        }
    }

    public void onPause()
    {
        if (mediatedAdView != null)
        {
            mediatedAdView.onPause();
        }
    }

    public void onResume()
    {
        if (mediatedAdView != null)
        {
            mediatedAdView.onResume();
        }
    }

    public View requestAd(ad ad1, Activity activity, String s, String s1, int i, int j, at at)
    {
        String s2;
        if (GoogleBridge.a())
        {
            s2 = "com.appnexus.opensdk.mediatedviews.GooglePlayDFPBanner";
        } else
        {
            s2 = "com.appnexus.opensdk.mediatedviews.LegacyDFPBanner";
        }
        mediatedAdView = GoogleBridge.a(s2);
        if (mediatedAdView == null)
        {
            if (ad1 != null)
            {
                ad1.a(aq.d);
            }
            return null;
        } else
        {
            return mediatedAdView.requestAd(ad1, activity, s, s1, i, j, at);
        }
    }
}
