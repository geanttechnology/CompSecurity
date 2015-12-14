// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InterstitialAd

public static interface us
{

    public abstract void onAdLeftApplication(InterstitialAd interstitialad);

    public abstract void onClicked(InterstitialAd interstitialad);

    public abstract void onClosed(InterstitialAd interstitialad);

    public abstract void onExpired(InterstitialAd interstitialad);

    public abstract void onLoadFailed(InterstitialAd interstitialad, us us);

    public abstract void onLoaded(InterstitialAd interstitialad);

    public abstract void onShowFailed(InterstitialAd interstitialad, us us);

    public abstract void onShown(InterstitialAd interstitialad);
}
