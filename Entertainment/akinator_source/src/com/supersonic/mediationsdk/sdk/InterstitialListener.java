// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.logger.SupersonicError;

public interface InterstitialListener
{

    public abstract void onInterstitialAdClicked();

    public abstract void onInterstitialAdClosed();

    public abstract void onInterstitialAvailability(boolean flag);

    public abstract void onInterstitialInitFail(SupersonicError supersonicerror);

    public abstract void onInterstitialInitSuccess();

    public abstract void onInterstitialShowFail(SupersonicError supersonicerror);

    public abstract void onInterstitialShowSuccess();
}
