// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.activities.PropositionPotionActivity;
import com.digidust.elokence.akinator.activities.QuestionActivity;
import com.digidust.elokence.akinator.billing.AkInappListener;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkApplicationProcessing;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.intentsoftware.addapptr.AATKit;

public class QuestionProcessing
    implements AkInappListener
{

    QuestionActivity activity;
    private android.view.View.OnClickListener mCroixFermeturePubListener;
    private Button uiImageCroixFermetureBanner;
    private RelativeLayout uiLayoutBannerAd;

    public QuestionProcessing(QuestionActivity questionactivity)
    {
        mCroixFermeturePubListener = new android.view.View.OnClickListener() {

            final QuestionProcessing this$0;

            public void onClick(View view)
            {
                view = new Intent(activity, com/digidust/elokence/akinator/activities/PropositionPotionActivity);
                view.putExtra("potion", "rayonnante");
                activity.startActivity(view);
                activity.disableAdOneTime();
            }

            
            {
                this$0 = QuestionProcessing.this;
                super();
            }
        };
        activity = questionactivity;
    }

    private void addQBannerPlacementView(int i)
    {
        ((RelativeLayout)activity.findViewById(0x7f0d029d)).addView(AATKit.getPlacementView(i), new android.widget.RelativeLayout.LayoutParams(-2, -2));
        AATKit.startPlacementAutoReload(i);
        uiImageCroixFermetureBanner.setVisibility(0);
    }

    private void hideAds()
    {
        activity.runOnUiThread(new Runnable() {

            final QuestionProcessing this$0;

            public void run()
            {
                uiLayoutBannerAd.setVisibility(8);
                uiImageCroixFermetureBanner.setVisibility(8);
            }

            
            {
                this$0 = QuestionProcessing.this;
                super();
            }
        });
    }

    private void removeQBannerPlacementView(int i)
    {
        View view = AATKit.getPlacementView(i);
        if (view.getParent() != null)
        {
            AATKit.stopPlacementAutoReload(i);
            ((ViewGroup)view.getParent()).removeView(view);
        }
        uiImageCroixFermetureBanner.setVisibility(8);
    }

    public void itemPurchased(String s)
    {
        if (s.equals(AkInappManager.getInstance().getSkuInappNoads()) || s.equals(AkInappManager.getInstance().getSkuInappUltime()))
        {
            hideAds();
        }
    }

    public void onAllPurchasesRestored()
    {
        activity.onAllPurchasesRestored();
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestAllPurchases();
    }

    public void processOnCreate()
    {
        uiImageCroixFermetureBanner = (Button)activity.findViewById(0x7f0d029c);
        uiLayoutBannerAd = (RelativeLayout)activity.findViewById(0x7f0d029d);
        activity.updateTextViewsSize();
        uiImageCroixFermetureBanner.setOnClickListener(mCroixFermeturePubListener);
    }

    public void processOnPause()
    {
        AkInappManager.getInstance().removeListener(this);
        if (!AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
        {
            AkApplicationProcessing akapplicationprocessing = AkApplicationProcessing.getInstance();
            byte byte0;
            if (activity.isTablet())
            {
                byte0 = 9;
            } else
            {
                byte0 = 8;
            }
            removeQBannerPlacementView(akapplicationprocessing.getAAtkitPlacementId(byte0));
        }
    }

    public void processOnResume()
    {
        AkInappManager.getInstance().addListener(this);
        if (!AkGameFactory.sharedInstance().areAdsEnabled() || AkGameFactory.sharedInstance().isUnlocked())
        {
            hideAds();
        }
        if (AkInappManager.getInstance().isInit())
        {
            AkInappManager.getInstance().requestAllPurchases();
        } else
        {
            AkInappManager.getInstance().init();
        }
        if (!AkGameFactory.sharedInstance().isUnlocked() && AkGameFactory.sharedInstance().areAdsEnabled())
        {
            AkApplicationProcessing akapplicationprocessing = AkApplicationProcessing.getInstance();
            byte byte0;
            if (activity.isTablet())
            {
                byte0 = 9;
            } else
            {
                byte0 = 8;
            }
            addQBannerPlacementView(akapplicationprocessing.getAAtkitPlacementId(byte0));
        }
    }

    public void skuDetailsUpdated()
    {
    }


}
