// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.supersonicads.sdk.SSAPublisher;
import com.supersonicads.sdk.controller.SupersonicWebView;
import com.supersonicads.sdk.data.SSASession;
import com.supersonicads.sdk.listeners.OnGenericFunctionListener;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;
import com.supersonicads.sdk.utils.DeviceProperties;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import java.util.Map;

public final class SupersonicAdsPublisherAgent
    implements SSAPublisher
{

    private static final String TAG = "SupersonicAdsPublisherAgent";
    private static MutableContextWrapper mutableContextWrapper;
    private static SupersonicAdsPublisherAgent sInstance;
    private SSASession session;
    private SupersonicWebView wvc;

    private SupersonicAdsPublisherAgent(final Activity activity, final int debugMode)
    {
        SupersonicSharedPrefHelper.getSupersonicPrefHelper(activity);
        Logger.enableLogging(debugMode);
        Logger.i("SupersonicAdsPublisherAgent", "C'tor");
        mutableContextWrapper = new MutableContextWrapper(activity);
        activity.runOnUiThread(new Runnable() {

            final SupersonicAdsPublisherAgent this$0;
            final Activity val$activity;
            final int val$debugMode;

            public void run()
            {
                wvc = new SupersonicWebView(SupersonicAdsPublisherAgent.mutableContextWrapper);
                wvc.registerConnectionReceiver(activity);
                wvc.setDebugMode(debugMode);
                wvc.downloadController();
            }

            
            {
                this$0 = SupersonicAdsPublisherAgent.this;
                activity = activity1;
                debugMode = i;
                super();
            }
        });
        startSession(activity);
    }

    private void endSession()
    {
        if (session != null)
        {
            session.endSession();
            SupersonicSharedPrefHelper.getSupersonicPrefHelper().addSession(session);
            session = null;
        }
    }

    public static SupersonicAdsPublisherAgent getInstance(Activity activity)
    {
        com/supersonicads/sdk/agent/SupersonicAdsPublisherAgent;
        JVM INSTR monitorenter ;
        activity = getInstance(activity, 0);
        com/supersonicads/sdk/agent/SupersonicAdsPublisherAgent;
        JVM INSTR monitorexit ;
        return activity;
        activity;
        throw activity;
    }

    public static SupersonicAdsPublisherAgent getInstance(Activity activity, int i)
    {
        com/supersonicads/sdk/agent/SupersonicAdsPublisherAgent;
        JVM INSTR monitorenter ;
        Logger.i("SupersonicAdsPublisherAgent", "getInstance()");
        if (sInstance != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        sInstance = new SupersonicAdsPublisherAgent(activity, i);
_L1:
        activity = sInstance;
        com/supersonicads/sdk/agent/SupersonicAdsPublisherAgent;
        JVM INSTR monitorexit ;
        return activity;
        mutableContextWrapper.setBaseContext(activity);
          goto _L1
        activity;
        throw activity;
    }

    private void startSession(Context context)
    {
        session = new SSASession(context, com.supersonicads.sdk.data.SSASession.SessionType.launched);
    }

    public void forceShowInterstitial()
    {
        wvc.forceShowInterstitial();
    }

    public void getOfferWallCredits(String s, String s1, OnOfferWallListener onofferwalllistener)
    {
        wvc.getOfferWallCredits(s, s1, onofferwalllistener);
    }

    public SupersonicWebView getWebViewController()
    {
        return wvc;
    }

    public void initInterstitial(String s, String s1, Map map, OnInterstitialListener oninterstitiallistener)
    {
        wvc.initInterstitial(s, s1, map, oninterstitiallistener);
    }

    public void initRewardedVideo(String s, String s1, Map map, OnRewardedVideoListener onrewardedvideolistener)
    {
        wvc.initBrandConnect(s, s1, map, onrewardedvideolistener);
    }

    public boolean isInterstitialAdAvailable()
    {
        return wvc.isInterstitialAdAvailable();
    }

    public void onPause(Activity activity)
    {
        try
        {
            wvc.enterBackground();
            wvc.unregisterConnectionReceiver(activity);
            endSession();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
    }

    public void onResume(Activity activity)
    {
        mutableContextWrapper.setBaseContext(activity);
        wvc.enterForeground();
        wvc.registerConnectionReceiver(activity);
        if (session == null)
        {
            resumeSession(activity);
        }
    }

    public void release(Activity activity)
    {
        Logger.i("SupersonicAdsPublisherAgent", "release()");
        DeviceProperties.release();
        wvc.unregisterConnectionReceiver(activity);
        if (!Looper.getMainLooper().equals(Looper.myLooper())) goto _L2; else goto _L1
_L1:
        wvc.destroy();
        wvc = null;
_L4:
        sInstance = null;
        endSession();
        return;
_L2:
        try
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final SupersonicAdsPublisherAgent this$0;

                public void run()
                {
                    wvc.destroy();
                    wvc = null;
                }

            
            {
                this$0 = SupersonicAdsPublisherAgent.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resumeSession(Context context)
    {
        session = new SSASession(context, com.supersonicads.sdk.data.SSASession.SessionType.backFromBG);
    }

    public void runGenericFunction(String s, Map map, OnGenericFunctionListener ongenericfunctionlistener)
    {
        wvc.runGenericFunction(s, map, ongenericfunctionlistener);
    }

    public void showInterstitial()
    {
        wvc.showInterstitial();
    }

    public void showOfferWall(String s, String s1, Map map, OnOfferWallListener onofferwalllistener)
    {
        wvc.showOfferWall(s, s1, map, onofferwalllistener);
    }

    public void showRewardedVideo()
    {
        wvc.showBrandConnect();
    }



/*
    static SupersonicWebView access$002(SupersonicAdsPublisherAgent supersonicadspublisheragent, SupersonicWebView supersonicwebview)
    {
        supersonicadspublisheragent.wvc = supersonicwebview;
        return supersonicwebview;
    }

*/

}
