// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.ad;
import com.amazon.device.ads.ae;
import com.amazon.device.ads.ag;
import com.amazon.device.ads.bz;
import com.amazon.device.ads.cb;
import com.amazon.device.ads.cc;
import com.amazon.device.ads.cl;
import com.amazon.device.ads.cn;
import com.amazon.device.ads.h;
import com.amazon.device.ads.i;
import com.amazon.device.ads.r;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.at;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            AmazonListener, AmazonBanner, AmazonTargeting

public class AmazonInterstitial
    implements MediatedInterstitialAdView
{

    AmazonListener amazonListener;
    cb iad;

    public AmazonInterstitial()
    {
    }

    public void destroy()
    {
        try
        {
            iad.a(null);
        }
        catch (NullPointerException nullpointerexception) { }
        iad = null;
        amazonListener = null;
    }

    public boolean isReady()
    {
        boolean flag;
        if (iad != null && !iad.c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        amazonListener.a((new StringBuilder("isReady() returned ")).append(flag).toString());
        return flag;
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

    public void requestAd(af af1, Activity activity, String s, String s1, at at)
    {
        boolean flag;
        flag = false;
        iad = new cb(activity);
        amazonListener = new AmazonListener(af1, com/appnexus/opensdk/mediatedviews/AmazonBanner.getSimpleName());
        iad.a(amazonListener);
        activity = AmazonTargeting.a(iad, at, s);
        s = iad;
_L7:
        s.f();
        if (s.e())
        {
            break MISSING_BLOCK_LABEL_220;
        }
        com.amazon.device.ads.cb._cls5.a[s.a().x.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 148
    //                   2 161
    //                   3 174
    //                   4 207;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        ((cb) (s)).f.c("An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.", null);
_L6:
        if (!flag)
        {
            if (af1 != null)
            {
                af1.a(aq.c);
            }
            iad = null;
        }
        return;
_L2:
        ((cb) (s)).f.c("An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.", null);
          goto _L6
_L3:
        ((cb) (s)).f.c("An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.", null);
          goto _L6
_L4:
label0:
        {
            if (!s.a().m())
            {
                break label0;
            }
            s.a().j();
        }
          goto _L7
        ((cb) (s)).f.d("An interstitial ad could not be loaded because of an unknown issue with the web views.", null);
          goto _L6
_L5:
        ((cb) (s)).f.d("An interstitial ad could not be loaded because the view has been destroyed.", null);
          goto _L6
        ((cb) (s)).h.set(false);
        ((cb) (s)).g.a(((cb) (s)).d, activity, new ad[] {
            new ad(s.a(), activity)
        });
        flag = s.a().h();
          goto _L6
    }

    public void show()
    {
        if (iad == null || iad.d()) goto _L2; else goto _L1
_L1:
        cb cb1 = iad;
        if (!cb1.f()) goto _L4; else goto _L3
_L3:
        cb1.f.d("The ad could not be shown because it previously failed to show. Please load a new ad.", null);
_L6:
        boolean flag1 = false;
_L5:
        h h1;
        boolean flag;
        long l;
        if (flag1)
        {
            amazonListener.a("show() called ad is now showing");
            return;
        } else
        {
            amazonListener.b("show() called showAd returned failure");
            return;
        }
_L4:
label0:
        {
            if (cb1.h.get())
            {
                cb1.f.c("This interstitial ad has expired. Please load another ad.", null);
                continue; /* Loop/switch isn't completed */
            }
            l = System.nanoTime();
            if (!cb1.a().x.equals(ae.e))
            {
                break label0;
            }
            if (cb1.a().m())
            {
                cb1.f.c("This interstitial ad has expired. Please load another ad.", null);
                continue; /* Loop/switch isn't completed */
            }
            if (cb.a.getAndSet(true))
            {
                cb1.f.c("Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.", null);
                continue; /* Loop/switch isn't completed */
            }
            h1 = cb1.a();
            h1.m.a();
            if (ae.e.equals(h1.x) && h1.b(ae.f))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                cb1.b = true;
                cb1.a().f.c(com.amazon.device.ads.ck.a.o, l);
                cb1.a().f.b(com.amazon.device.ads.ck.a.q, l);
                i.a(cb1.a());
                cb1.a().f.b(com.amazon.device.ads.ck.a.p);
                bz bz1 = new bz();
                bz1.c = com/amazon/device/ads/AdActivity;
                bz1.b = cb1.c.getApplicationContext();
                bz1.a = cb1.c;
                String s = com/amazon/device/ads/cc.getName();
                bz1.d.put("adapter", s);
                boolean flag2 = bz1.a();
                if (!flag2)
                {
                    cb1.f.d("Failed to show the interstitial ad because AdActivity could not be found.", null);
                }
                flag1 = flag2;
                if (!flag2)
                {
                    i.b();
                    cb1.a().j();
                    cb.a.set(false);
                    cb1.b = false;
                    cb1.a().f.c(com.amazon.device.ads.ck.a.z);
                    flag1 = flag2;
                }
            } else
            {
                cb1.f.c("Interstitial ad could not be shown.", null);
                continue; /* Loop/switch isn't completed */
            }
        }
          goto _L5
        if (cb1.e())
        {
            cb1.f.c("The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.", null);
        } else
        if (cb1.c())
        {
            cb1.f.c("The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.", null);
        } else
        if (cb1.d())
        {
            cb1.f.c("The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.", null);
        } else
        {
            cb1.f.c("An interstitial ad is not ready to show.", null);
        }
        if (true) goto _L6; else goto _L2
_L2:
        if (iad == null)
        {
            amazonListener.b("show() called on a failed Interstitial");
            return;
        }
        if (!iad.d())
        {
            amazonListener.b("show() called on a failed Interstitial");
            return;
        } else
        {
            amazonListener.b("show() failed");
            return;
        }
    }
}
