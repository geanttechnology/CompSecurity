// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiInterstitial, InMobiAdRequestStatus

public static interface 
{

    public abstract void onAdDismissed(InMobiInterstitial inmobiinterstitial);

    public abstract void onAdDisplayed(InMobiInterstitial inmobiinterstitial);

    public abstract void onAdInteraction(InMobiInterstitial inmobiinterstitial, Map map);

    public abstract void onAdLoadFailed(InMobiInterstitial inmobiinterstitial, InMobiAdRequestStatus inmobiadrequeststatus);

    public abstract void onAdLoadSucceeded(InMobiInterstitial inmobiinterstitial);

    public abstract void onAdRewardActionCompleted(InMobiInterstitial inmobiinterstitial, Map map);

    public abstract void onUserLeftApplication(InMobiInterstitial inmobiinterstitial);
}
