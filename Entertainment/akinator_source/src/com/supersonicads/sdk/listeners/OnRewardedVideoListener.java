// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.listeners;

import com.supersonicads.sdk.data.AdUnitsReady;

public interface OnRewardedVideoListener
{

    public abstract void onRVAdClosed();

    public abstract void onRVAdCredited(int i);

    public abstract void onRVGeneric(String s, String s1);

    public abstract void onRVInitFail(String s);

    public abstract void onRVInitSuccess(AdUnitsReady adunitsready);

    public abstract void onRVNoMoreOffers();
}
