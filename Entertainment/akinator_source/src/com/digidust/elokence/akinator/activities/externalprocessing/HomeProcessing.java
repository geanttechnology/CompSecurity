// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.content.Intent;
import com.digidust.elokence.akinator.activities.HomeActivity;
import com.digidust.elokence.akinator.factories.AkApplicationProcessing;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.intentsoftware.addapptr.AATKit;

public class HomeProcessing
{

    private HomeActivity activity;
    private boolean showAdOnHome;

    public HomeProcessing(HomeActivity homeactivity)
    {
        showAdOnHome = true;
        activity = homeactivity;
    }

    public void processOnCreate()
    {
        showAdOnHome = activity.getIntent().getBooleanExtra("ShowAdOnGameOver", true);
    }

    public void processOnResume()
    {
        if (showAdOnHome)
        {
            showInterstitialAd();
        }
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
            AATKit.showPlacement(AkApplicationProcessing.getInstance().getAAtkitPlacementId(2));
            showAdOnHome = false;
        }
    }
}
