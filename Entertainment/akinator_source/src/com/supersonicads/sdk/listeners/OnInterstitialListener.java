// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.listeners;


public interface OnInterstitialListener
{

    public abstract void onInterstitialAdClicked();

    public abstract void onInterstitialAdClosed();

    public abstract void onInterstitialAvailability(boolean flag);

    public abstract void onInterstitialInitFail(String s);

    public abstract void onInterstitialInitSuccess();

    public abstract void onInterstitialShowFail(String s);

    public abstract void onInterstitialShowSuccess();
}
