// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventInterstitialListener, CustomEventAdapter

class zzh
    implements CustomEventInterstitialListener
{

    private final CustomEventAdapter zzDK;
    final CustomEventAdapter zzDL;
    private final MediationInterstitialListener zzh;

    public void onAdClicked()
    {
        zzb.zzaj("Custom event adapter called onAdClicked.");
        zzh.onAdClicked(zzDK);
    }

    public void onAdClosed()
    {
        zzb.zzaj("Custom event adapter called onAdClosed.");
        zzh.onAdClosed(zzDK);
    }

    public void onAdFailedToLoad(int i)
    {
        zzb.zzaj("Custom event adapter called onFailedToReceiveAd.");
        zzh.onAdFailedToLoad(zzDK, i);
    }

    public void onAdLeftApplication()
    {
        zzb.zzaj("Custom event adapter called onAdLeftApplication.");
        zzh.onAdLeftApplication(zzDK);
    }

    public void onAdLoaded()
    {
        zzb.zzaj("Custom event adapter called onReceivedAd.");
        zzh.onAdLoaded(zzDL);
    }

    public void onAdOpened()
    {
        zzb.zzaj("Custom event adapter called onAdOpened.");
        zzh.onAdOpened(zzDK);
    }

    public Listener(CustomEventAdapter customeventadapter, CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
    {
        zzDL = customeventadapter;
        super();
        zzDK = customeventadapter1;
        zzh = mediationinterstitiallistener;
    }
}
