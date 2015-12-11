// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.view.View;
import com.amazon.device.ads.ab;
import com.amazon.device.ads.ac;
import com.amazon.device.ads.ae;
import com.amazon.device.ads.cn;
import com.amazon.device.ads.d;
import com.amazon.device.ads.e;
import com.amazon.device.ads.h;
import com.amazon.device.ads.n;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.at;
import java.util.HashMap;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            AmazonListener, AmazonTargeting

public class AmazonBanner
    implements MediatedBannerAdView
{

    n adView;
    AmazonListener amazonListener;

    public AmazonBanner()
    {
        amazonListener = null;
        adView = null;
    }

    public void destroy()
    {
        if (adView != null)
        {
            Object obj;
            try
            {
                adView.setListener(null);
            }
            catch (NullPointerException nullpointerexception) { }
            obj = adView;
            if (((n) (obj)).e)
            {
                ((n) (obj)).f.b("Destroying the AdLayout", null);
                obj.d = true;
                ((n) (obj)).a();
                obj = ((n) (obj)).getAdController();
                if (!((h) (obj)).n())
                {
                    ((h) (obj)).d.d("The ad cannot be destroyed because it has already been destroyed.", null);
                } else
                {
                    ((h) (obj)).j.a();
                    obj.x = ae.k;
                    if (((h) (obj)).t != null)
                    {
                        ((h) (obj)).a().a();
                        ((h) (obj)).l.a.clear();
                        obj.t = null;
                    }
                    obj.z = false;
                    obj.f = null;
                    obj.o = null;
                }
            }
            amazonListener = null;
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

    public View requestAd(ad ad1, Activity activity, String s, String s1, int i, int j, at at)
    {
        adView = new n(activity, new ac(i, j));
        amazonListener = new AmazonListener(ad1, com/appnexus/opensdk/mediatedviews/AmazonBanner.getSimpleName());
        adView.setListener(amazonListener);
        activity = AmazonTargeting.a(adView, at, s);
        adView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
        if (!adView.a(activity))
        {
            amazonListener.b("loadAd() call rejected");
            if (ad1 != null)
            {
                ad1.a(aq.c);
            }
            adView = null;
        }
        return adView;
    }
}
