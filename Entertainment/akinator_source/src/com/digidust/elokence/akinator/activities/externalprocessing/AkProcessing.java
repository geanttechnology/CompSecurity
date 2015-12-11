// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.activities.PopPedagogiqueActivity;
import com.digidust.elokence.akinator.activities.SplashscreenActivity;
import com.digidust.elokence.akinator.factories.AkApplicationProcessing;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.intentsoftware.addapptr.AATKit;

public class AkProcessing
{

    AkActivity activity;
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter broadcastReceiverFilter;
    private boolean canShowAd;

    public AkProcessing(AkActivity akactivity)
    {
        canShowAd = true;
        activity = akactivity;
    }

    private BroadcastReceiver createBroadcastReceiver()
    {
        return new BroadcastReceiver() {

            final AkProcessing this$0;

            public void onReceive(Context context, Intent intent)
            {
            }

            
            {
                this$0 = AkProcessing.this;
                super();
            }
        };
    }

    public void disableAdOneTime()
    {
        canShowAd = false;
    }

    public void processGoToHome()
    {
    }

    public void processOnCreate()
    {
        broadcastReceiver = createBroadcastReceiver();
        broadcastReceiverFilter = new IntentFilter(AkApplicationProcessing.AATKIT_HAVE_AD_ACTION);
        canShowAd = false;
    }

    public void processOnPause()
    {
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(broadcastReceiver);
        if (!(activity instanceof SplashscreenActivity))
        {
            if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
            {
                AATKit.stopPlacementAutoReload(AkApplicationProcessing.getInstance().getAAtkitPlacementId(2));
            }
            AATKit.stopPlacementAutoReload(AkApplicationProcessing.getInstance().getAAtkitPlacementId(10));
            AATKit.onActivityPause(activity);
        }
    }

    public void processOnResume()
    {
label0:
        {
            if (!(activity instanceof SplashscreenActivity))
            {
                AATKit.onActivityResume(activity);
                if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
                {
                    AATKit.startPlacementAutoReload(AkApplicationProcessing.getInstance().getAAtkitPlacementId(2));
                }
                AATKit.startPlacementAutoReload(AkApplicationProcessing.getInstance().getAAtkitPlacementId(10));
                if (!canShowAd || !AkGameFactory.sharedInstance().canShowAd() || !AkGameFactory.sharedInstance().areAdsEnabled() || activity.getClass() == com/digidust/elokence/akinator/activities/PopPedagogiqueActivity)
                {
                    break label0;
                }
                if (!AkGameFactory.sharedInstance().getClickedBanner())
                {
                    showInterstitialAd();
                }
                AkGameFactory.sharedInstance().setClickedBanner(false);
            }
            return;
        }
        canShowAd = true;
        AkGameFactory.sharedInstance().setCanShowAd(true);
    }

    public void showCenteredAd()
    {
        showCenteredAd(false, false);
    }

    public void showCenteredAd(boolean flag, boolean flag1)
    {
    }

    public void showInterstitialAd()
    {
        showInterstitialAd(false, false);
    }

    public void showInterstitialAd(boolean flag, boolean flag1)
    {
        AkLog.d("AkinatorAd", (new StringBuilder()).append("Show interstitial ").append(flag).append(" ").append(flag1).toString());
        if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
        {
            AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
            int i = AkApplicationProcessing.getInstance().getAAtkitPlacementId(2);
            canShowAd = false;
            AATKit.showPlacement(i);
        }
    }
}
