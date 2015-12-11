// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.jirbo.adcolony.aj;
import com.jirbo.adcolony.q;
import com.jirbo.adcolony.s;
import com.jirbo.adcolony.u;
import com.smule.android.c.aa;
import com.smule.pianoandroid.utils.a;

public class AdColonyDFPInterstitial
    implements CustomEventInterstitial
{

    private static final String TAG = com/smule/pianoandroid/ads/AdColonyDFPInterstitial.getName();
    private static long TIMEOUT = 60000L;
    private CustomEventInterstitialListener listener;
    private Activity mActivity;
    private aj mAd;
    private String mAppId;
    private Thread mIsReadyThread;
    private String mZoneId;

    public AdColonyDFPInterstitial()
    {
    }

    private void onFailedToReceiveAd(CustomEventInterstitialListener customeventinterstitiallistener, Activity activity)
    {
        activity.runOnUiThread(new Runnable(customeventinterstitiallistener) {

            final CustomEventInterstitialListener a;
            final AdColonyDFPInterstitial b;

            public void run()
            {
                a.onAdFailedToLoad(0);
            }

            
            {
                b = AdColonyDFPInterstitial.this;
                a = customeventinterstitiallistener;
                super();
            }
        });
    }

    private void onReceivedAd(CustomEventInterstitialListener customeventinterstitiallistener, Activity activity)
    {
        activity.runOnUiThread(new Runnable(customeventinterstitiallistener) {

            final CustomEventInterstitialListener a;
            final AdColonyDFPInterstitial b;

            public void run()
            {
                a.onAdLoaded();
            }

            
            {
                b = AdColonyDFPInterstitial.this;
                a = customeventinterstitiallistener;
                super();
            }
        });
    }

    public void onDestroy()
    {
        if (mIsReadyThread != null)
        {
            mIsReadyThread.interrupt();
        }
        mIsReadyThread = null;
    }

    public void onPause()
    {
        q.c();
    }

    public void onResume()
    {
        q.a(mActivity);
    }

    public void requestInterstitialAd(Context context, CustomEventInterstitialListener customeventinterstitiallistener, String s, MediationAdRequest mediationadrequest, Bundle bundle)
    {
        aa.a(TAG, (new StringBuilder()).append("Ad request received with parameters ").append(s).toString());
        mActivity = (Activity)context;
        context = s.split(",");
        if (context.length == 0)
        {
            aa.a(TAG, "Wrong parameters received ");
            return;
        }
        mAppId = context[0];
        if (context.length >= 2)
        {
            mZoneId = context[1];
        }
        a.a(mActivity);
        listener = customeventinterstitiallistener;
        mAd = new aj(mZoneId);
        mIsReadyThread = new Thread(new Runnable() {

            final AdColonyDFPInterstitial a;

            public void run()
            {
                long l = AdColonyDFPInterstitial.TIMEOUT;
_L2:
                if (l <= 0L)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (a.mAd.f())
                {
                    a.onReceivedAd(a.listener, a.mActivity);
                    return;
                }
                Thread.sleep(100L);
                l -= 100L;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    a.onFailedToReceiveAd(a.listener, a.mActivity);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    aa.a(AdColonyDFPInterstitial.TAG, "isReady() thread interrupted");
                }
                return;
            }

            
            {
                a = AdColonyDFPInterstitial.this;
                super();
            }
        });
        mIsReadyThread.start();
        mAd.a(new u() {

            final AdColonyDFPInterstitial a;

            public void a(s s1)
            {
                aa.a(AdColonyDFPInterstitial.TAG, "Attempt finished");
                aa.a(AdColonyDFPInterstitial.TAG, (new StringBuilder()).append("canceled  ").append(s1.c()).toString());
                aa.a(AdColonyDFPInterstitial.TAG, (new StringBuilder()).append("shown     ").append(s1.a()).toString());
                aa.a(AdColonyDFPInterstitial.TAG, (new StringBuilder()).append("no fill   ").append(s1.d()).toString());
                aa.a(AdColonyDFPInterstitial.TAG, (new StringBuilder()).append("not shown ").append(s1.b()).toString());
                aa.a(AdColonyDFPInterstitial.TAG, (new StringBuilder()).append("skipped   ").append(s1.e()).toString());
            }

            public void b(s s1)
            {
                a.listener.onAdOpened();
            }

            
            {
                a = AdColonyDFPInterstitial.this;
                super();
            }
        });
    }

    public void showInterstitial()
    {
        if (mAd.f())
        {
            mAd.j();
        }
    }








}
