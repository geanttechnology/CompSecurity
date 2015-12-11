// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.content.Intent;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.GameOverActivity;
import com.digidust.elokence.akinator.exceptions.AkTraductionsNotLoadedException;
import com.digidust.elokence.akinator.factories.AkApplicationProcessing;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.intentsoftware.addapptr.AATKit;

public class GameOverProcessing
{

    GameOverActivity activity;
    boolean canShowAd;

    public GameOverProcessing(GameOverActivity gameoveractivity)
    {
        canShowAd = true;
        activity = gameoveractivity;
    }

    public void processModeFoundOnCreate(TextView textview)
        throws AkTraductionsNotLoadedException
    {
    }

    public void processOnCreate()
    {
        canShowAd = activity.getIntent().getBooleanExtra("ShowAdOnHome", false);
    }

    public void processOnResume()
    {
        showInterstitialAd();
    }

    public void showInterstitialAd()
    {
        showInterstitialAd(false, false);
    }

    public void showInterstitialAd(boolean flag, boolean flag1)
    {
        AkLog.d("AkinatorAd", (new StringBuilder()).append("Show interstitial ").append(flag).append(" ").append(flag1).toString());
        if (canShowAd && AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
        {
            AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
            int i = AkApplicationProcessing.getInstance().getAAtkitPlacementId(2);
            canShowAd = false;
            AATKit.showPlacement(i);
        }
    }
}
