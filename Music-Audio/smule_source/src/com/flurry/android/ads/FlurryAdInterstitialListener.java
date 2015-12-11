// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


// Referenced classes of package com.flurry.android.ads:
//            FlurryAdInterstitial, FlurryAdErrorType

public interface FlurryAdInterstitialListener
{

    public abstract void onAppExit(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onClicked(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onClose(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onDisplay(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onError(FlurryAdInterstitial flurryadinterstitial, FlurryAdErrorType flurryaderrortype, int i);

    public abstract void onFetched(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onRendered(FlurryAdInterstitial flurryadinterstitial);

    public abstract void onVideoCompleted(FlurryAdInterstitial flurryadinterstitial);
}
