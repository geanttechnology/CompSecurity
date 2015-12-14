// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.z;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinIncentivizedInterstitial
{

    private z a;

    public AppLovinIncentivizedInterstitial(Context context)
    {
        this(AppLovinSdk.getInstance(context));
    }

    public AppLovinIncentivizedInterstitial(AppLovinSdk applovinsdk)
    {
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("SDK cannot be null");
        } else
        {
            a = new z(applovinsdk);
            return;
        }
    }

    public static AppLovinIncentivizedInterstitial create(Context context)
    {
        return create(AppLovinSdk.getInstance(context));
    }

    public static AppLovinIncentivizedInterstitial create(AppLovinSdk applovinsdk)
    {
        return new AppLovinIncentivizedInterstitial(applovinsdk);
    }

    public void dismiss()
    {
        a.d();
    }

    public String getUserIdentifier()
    {
        return z.b();
    }

    public boolean isAdReadyToDisplay()
    {
        return a.a();
    }

    public void preload(AppLovinAdLoadListener applovinadloadlistener)
    {
        if (applovinadloadlistener == null)
        {
            Log.i("AppLovinIncentivizedInterstitial", "AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
        }
        a.a(applovinadloadlistener);
    }

    public void setUserIdentifier(String s)
    {
        z.a(s);
    }

    public void show(Activity activity)
    {
        show(activity, null, null);
    }

    public void show(Activity activity, AppLovinAdRewardListener applovinadrewardlistener)
    {
        show(activity, applovinadrewardlistener, null);
    }

    public void show(Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener)
    {
        show(activity, applovinadrewardlistener, applovinadvideoplaybacklistener, null);
    }

    public void show(Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener)
    {
        show(activity, applovinadrewardlistener, applovinadvideoplaybacklistener, applovinaddisplaylistener, null);
    }

    public void show(Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener, AppLovinAdClickListener applovinadclicklistener)
    {
        a.a(activity, applovinadrewardlistener, applovinadvideoplaybacklistener, applovinaddisplaylistener, applovinadclicklistener);
    }
}
