// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk;

import android.app.Activity;
import com.supersonicads.sdk.listeners.OnGenericFunctionListener;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;
import java.util.Map;

public interface SSAPublisher
{

    public abstract void forceShowInterstitial();

    public abstract void getOfferWallCredits(String s, String s1, OnOfferWallListener onofferwalllistener);

    public abstract void initInterstitial(String s, String s1, Map map, OnInterstitialListener oninterstitiallistener);

    public abstract void initRewardedVideo(String s, String s1, Map map, OnRewardedVideoListener onrewardedvideolistener);

    public abstract boolean isInterstitialAdAvailable();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void release(Activity activity);

    public abstract void runGenericFunction(String s, Map map, OnGenericFunctionListener ongenericfunctionlistener);

    public abstract void showInterstitial();

    public abstract void showOfferWall(String s, String s1, Map map, OnOfferWallListener onofferwalllistener);

    public abstract void showRewardedVideo();
}
