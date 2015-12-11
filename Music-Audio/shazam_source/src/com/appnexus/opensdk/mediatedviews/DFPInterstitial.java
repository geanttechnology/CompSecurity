// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.at;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GoogleBridge

public class DFPInterstitial
    implements MediatedInterstitialAdView
{

    private MediatedInterstitialAdView adView;

    public DFPInterstitial()
    {
    }

    public void destroy()
    {
        if (adView != null)
        {
            adView.destroy();
            adView = null;
        }
    }

    public boolean isReady()
    {
        return adView != null && adView.isReady();
    }

    public void onDestroy()
    {
        if (adView != null)
        {
            adView.onDestroy();
        }
    }

    public void onPause()
    {
        if (adView != null)
        {
            adView.onPause();
        }
    }

    public void onResume()
    {
        if (adView != null)
        {
            adView.onResume();
        }
    }

    public void requestAd(af af1, Activity activity, String s, String s1, at at)
    {
        String s2;
        if (GoogleBridge.a())
        {
            s2 = "com.appnexus.opensdk.mediatedviews.GooglePlayDFPInterstitial";
        } else
        {
            s2 = "com.appnexus.opensdk.mediatedviews.LegacyDFPInterstitial";
        }
        adView = GoogleBridge.b(s2);
        if (adView == null)
        {
            if (af1 != null)
            {
                af1.a(aq.d);
            }
            return;
        } else
        {
            adView.requestAd(af1, activity, s, s1, at);
            return;
        }
    }

    public void show()
    {
        if (adView != null)
        {
            adView.show();
        }
    }
}
