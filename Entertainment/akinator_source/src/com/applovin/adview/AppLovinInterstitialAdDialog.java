// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

public interface AppLovinInterstitialAdDialog
{

    public abstract void dismiss();

    public abstract boolean isAdReadyToDisplay();

    public abstract boolean isShowing();

    public abstract void setAdClickListener(AppLovinAdClickListener applovinadclicklistener);

    public abstract void setAdDisplayListener(AppLovinAdDisplayListener applovinaddisplaylistener);

    public abstract void setAdLoadListener(AppLovinAdLoadListener applovinadloadlistener);

    public abstract void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener);

    public abstract void show();

    public abstract void showAndRender(AppLovinAd applovinad);
}
