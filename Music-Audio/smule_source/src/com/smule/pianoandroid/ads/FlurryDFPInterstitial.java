// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAds;
import com.google.a.a.b.b;
import com.google.a.a.d;
import com.smule.android.c.aa;
import com.smule.pianoandroid.utils.a;

// Referenced classes of package com.smule.pianoandroid.ads:
//            f, e

public class FlurryDFPInterstitial
{

    public static long FLURRY_INTERSTITIAL_TIMEOUT = 10000L;
    private static final String TAG = com/smule/pianoandroid/ads/FlurryDFPInterstitial.getName();
    private Activity activity;
    private boolean adAvailable;
    private String adSpace;
    private Thread interstitialAdRequestThread;
    private RelativeLayout viewGroup;

    public FlurryDFPInterstitial()
    {
        adAvailable = false;
    }

    private void checkAdAvailable(b b, long l)
    {
        this;
        JVM INSTR monitorenter ;
        aa.a(TAG, "Calling FlurryAds.setAdListener");
        FlurryAds.setAdListener(new f(this, b));
        aa.a(TAG, "Checking if fullscreen ad is available");
        (new Thread(new Runnable() {

            final FlurryDFPInterstitial a;

            public void run()
            {
                FlurryAds.fetchAd(a.activity, a.adSpace, (ViewGroup)a.activity.findViewById(0x7f0a00b5), FlurryAdSize.FULLSCREEN);
            }

            
            {
                a = FlurryDFPInterstitial.this;
                super();
            }
        })).start();
        this;
        JVM INSTR monitorexit ;
        return;
        b;
        throw b;
    }

    public void destroy()
    {
    }

    public void requestInterstitialAd(b b, Activity activity1, String s, String s1, d d1, Object obj)
    {
        aa.a(TAG, (new StringBuilder()).append("Interstitial ad request from DFP with parameters ").append(s1).append(" customEventExtra = ").append(obj).toString());
        activity = activity1;
        FlurryAds.initializeAds(activity1);
        FlurryAds.setTargetingKeywords(a.c());
        boolean flag = d1.a();
        if (flag)
        {
            aa.a(TAG, "Test mode enabled");
            FlurryAds.enableTestAds(flag);
        }
        adSpace = s1;
        interstitialAdRequestThread = new Thread(new e(this, b, FLURRY_INTERSTITIAL_TIMEOUT));
        interstitialAdRequestThread.start();
    }

    public void showInterstitial()
    {
        if (adAvailable)
        {
            aa.a(TAG, "Showing already cached fullscreen ad");
            viewGroup = new RelativeLayout(activity);
            FlurryAds.displayAd(activity, adSpace, (ViewGroup)activity.findViewById(0x7f0a00b5));
        }
    }




/*
    static boolean access$102(FlurryDFPInterstitial flurrydfpinterstitial, boolean flag)
    {
        flurrydfpinterstitial.adAvailable = flag;
        return flag;
    }

*/



}
