// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.listener;


public interface MdotMAdEventListener
{

    public abstract void didShowInterstitial();

    public abstract void onDismissScreen();

    public abstract void onFailedToReceiveInterstitialAd();

    public abstract void onInterstitialAdClick();

    public abstract void onInterstitialDismiss();

    public abstract void onLeaveApplicationFromInterstitial();

    public abstract void onReceiveInterstitialAd();

    public abstract void onRewardedVideoComplete(boolean flag, String s);

    public abstract void willShowInterstitial();
}
