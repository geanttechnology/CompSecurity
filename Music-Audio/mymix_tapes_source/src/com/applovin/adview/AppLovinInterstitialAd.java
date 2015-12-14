// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.adview:
//            InterstitialAdDialogCreator, u, AppLovinInterstitialAdDialog

public class AppLovinInterstitialAd extends View
{

    private AppLovinInterstitialAdDialog a;

    public AppLovinInterstitialAd(Activity activity, AttributeSet attributeset)
    {
        this(activity, attributeset, 0);
    }

    public AppLovinInterstitialAd(Activity activity, AttributeSet attributeset, int i)
    {
        super(activity, attributeset, i);
        a = null;
        attributeset = AppLovinSdk.getInstance(activity);
        if (attributeset != null && !attributeset.hasCriticalErrors())
        {
            a = (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(attributeset, activity);
        }
        setVisibility(8);
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk applovinsdk, Activity activity)
    {
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null)
        {
            throw new IllegalArgumentException("No activity specified");
        } else
        {
            return (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(applovinsdk, activity);
        }
    }

    public static boolean isAdReadyToDisplay(Activity activity)
    {
        return AppLovinSdk.getInstance(activity).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(Activity activity)
    {
        if (activity == null)
        {
            throw new IllegalArgumentException("No activity specified");
        }
        AppLovinSdk applovinsdk = AppLovinSdk.getInstance(activity);
        if (applovinsdk != null && !applovinsdk.hasCriticalErrors())
        {
            show(applovinsdk, activity);
        }
    }

    public static void show(AppLovinSdk applovinsdk, Activity activity)
    {
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null)
        {
            throw new IllegalArgumentException("No activity specified");
        } else
        {
            activity.runOnUiThread(new u(applovinsdk, activity));
            return;
        }
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (a != null)
        {
            a.show();
        }
    }
}
