// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android.cache;

import com.unity3d.ads.android.campaign.UnityAdsCampaignHandler;

public interface IUnityAdsCacheListener
{

    public abstract void onAllCampaignsReady();

    public abstract void onCampaignReady(UnityAdsCampaignHandler unityadscampaignhandler);

    public abstract void onCampaignUpdateStarted();
}
